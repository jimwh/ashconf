package lab.ash.config;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.sql.DataSource;
import lab.ash.jparepo.utils.BlobUtil;
import lab.ash.jparepo.utils.HibernateBlobUtil;
import oracle.jdbc.pool.OracleDataSource;
import org.activiti.engine.ProcessEngine;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.support.SharedEntityManagerBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySources({@PropertySource("classpath:${env}.db.properties"),@PropertySource("classpath:application.properties")})
@EnableTransactionManagement
public class AshConfig implements EnvironmentAware {

    private Environment env;

    private static final Logger log = LoggerFactory.getLogger(AshConfig.class);

    @Bean
    @Primary
    public DataSource primaryDataSource() {

        try {
            final OracleDataSource dataSource = new OracleDataSource();
            log.info("primary.url={}", env.getProperty("primary.url"));
            dataSource.setURL(env.getProperty("primary.url"));
            dataSource.setUser(env.getProperty("primary.username"));
            dataSource.setPassword(env.getProperty("primary.password"));
            dataSource.setImplicitCachingEnabled(true);
            dataSource.setFastConnectionFailoverEnabled(true);
            final Properties properties = new Properties();
            properties.setProperty("MinLimit", "1");
            properties.setProperty("MaxLimit", "8");
            properties.setProperty("InitialLimit", "1");
            properties.setProperty("ConnectionWaitTimeout", "128");
            properties.setProperty("InactivityTimeout", "180");
            properties.setProperty("ValidateConnection", "true");
            dataSource.setConnectionProperties(properties);
            return dataSource;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(env.getProperty("secondary.driverClassName"))
                .url(env.getProperty("secondary.url"))
                .username(env.getProperty("secondary.username"))
                .password(env.getProperty("secondary.password"))
                .build();
    }

    @Bean
    public TransactionAwareDataSourceProxy transactionAwareDataSource() {
        return new TransactionAwareDataSourceProxy(primaryDataSource());
    }

    @Bean
    public JdbcTemplate primaryJdbcTemplate() throws SQLException {
        return new JdbcTemplate(transactionAwareDataSource());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        final LocalContainerEntityManagerFactoryBean entityManagerFactory =
                new LocalContainerEntityManagerFactoryBean();

        // Classpath scanning of @Component, @Service, etc annotated class
        entityManagerFactory.setPackagesToScan("lab.ash");

        entityManagerFactory.setDataSource(primaryDataSource());

        // Vendor adapter
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(false);
        vendorAdapter.setDatabase(Database.ORACLE);
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setPersistenceUnitName("persistenceUnit");

        // Hibernate properties
        final Map<String, Object > jpaPropertyMap = new HashMap<String, Object>();
        jpaPropertyMap.put("hibernate.jdbc.use_streams_for_binary", true);
        jpaPropertyMap.put("hibernate.cache.use_second_level_cache", true);
        jpaPropertyMap.put("hibernate.cache.region.factory_class","org.hibernate.cache.ehcache.EhCacheRegionFactory");
        jpaPropertyMap.put("hibernate.cache.use_query_cache",true);
        jpaPropertyMap.put("hibernate.generate_statistics", false);
        jpaPropertyMap.put("hibernate.max_fetch_depth", "2");
        jpaPropertyMap.put("hibernate.bytecode.provider", "javassist");
        jpaPropertyMap.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
        jpaPropertyMap.put("hibernate.search.default.directory_provider","filesystem");
        jpaPropertyMap.put("hibernate.show_sql", false);

        entityManagerFactory.setJpaPropertyMap(jpaPropertyMap);

        return entityManagerFactory;
    }

    @Bean
    public SharedEntityManagerBean sharedEntityManagerBean() {
        final SharedEntityManagerBean sem = new SharedEntityManagerBean();
        sem.setEntityManagerFactory(entityManagerFactory().getObject());
        return sem;
    }

    @Bean
    public JpaDialect jpaDialect() {
        return new HibernateJpaDialect();
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setNestedTransactionAllowed(true);
        transactionManager.setDefaultTimeout(300);
        transactionManager.setDataSource(primaryDataSource());
        transactionManager.setJpaDialect(jpaDialect());
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
        return new PersistenceAnnotationBeanPostProcessor();
    }
    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }

    @Bean
    public ProcessEngine processEngine() {
        final SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();
        config.setDataSource(transactionAwareDataSource());
        config.setTransactionManager(transactionManager());
        config.setJpaEntityManagerFactory(entityManagerFactory());
        config.setJpaHandleTransaction(false);
        config.setJpaCloseEntityManager(false);
        config.setProcessEngineName("RASCAL-ACTIVITI-BPM-ENGINE");
        config.setDatabaseType("oracle");
        config.setDatabaseSchemaUpdate("false");
        config.setJobExecutorActivate(true);
        config.setAsyncExecutorActivate(true);
        config.setHistory("full");
        // final Set<Class<?>> set = new HashSet<Class<?>>();
        // set.add(lab.act.service.LabMybatisMapper.class);
        // config.setCustomMybatisMappers(set);
        // Resource
        // config.setDeploymentResources();
        return config.buildProcessEngine();
    }

    @Bean
    public BlobUtil blobUtil() {
        return new HibernateBlobUtil();
    }
}
