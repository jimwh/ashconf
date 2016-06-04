package lab.ash;

import lab.ash.config.AshConfig;
import lab.ash.service.FooBar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan("lab.ash")
@SpringApplicationConfiguration(classes = {AshConfig.class})
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        log.info("start...");

        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        FooBar fooBar=ctx.getBean(FooBar.class);
        log.info("foobar.dir={}", fooBar.getDir());

        SpringApplication.exit(ctx);

        log.info("done...");
    }

    /*
    static void deployment(ApplicationContext ctx) {
        RepositoryService repositoryService =
                (RepositoryService) ctx.getBean("repositoryService");
        String deploymentId = repositoryService
                .createDeployment()
                .addClasspathResource("bpm/dualSignals.bpmn20.xml")
                .deploy()
                .getId();
        log.info("deploymentId={}", deploymentId);
        repositoryService.deleteDeployment(deploymentId);
    }
    */
}