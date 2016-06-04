package lab.ash.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Resource;
import lab.ash.jparepo.consent.ConsentHeaderDAO;
import lab.ash.model.consent.ConsentHeader;
import lab.ash.model.consent.ConsentSnapshot;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FooBar {

    private static final Logger log = LoggerFactory.getLogger(FooBar.class);
    @Resource
    private transient Environment env;

    @Resource
    private transient RuntimeService runtimeService;

    @Resource
    private transient ConsentHeaderDAO consentHeaderDAO;

    @Resource
    private transient ConsentSnapshotService snapshotService;

    @Resource
    private transient HistoryService historyService;

    @Resource
    private transient CustomerResourceLoader customerResourceLoader;

    public String getDir() {
        final List<ConsentHeader> list = consentHeaderDAO.findAll();
        log.info("size={}", list.size());
        if( !list.isEmpty() ) {
            testSnapshot(list.get(list.size()-1).getId());
        }
        printProcessHistory("IacucApprovalProcess");
        printTaskHistory("IacucApprovalProcess");
        log.info("runtimeService={}", runtimeService != null);
        return env.getProperty("downloadDirectory");
    }

    public void printProcessHistory(final String procDefKey) {
        final List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery()
                .processDefinitionKey(procDefKey)
                .includeProcessVariables()
                .orderByProcessInstanceBusinessKey()
                .desc()
                .list();
        for (final HistoricProcessInstance ht : list) {
            log.info("id={}, businessKey={}, startTime={}, name={}, defId={},defKey={},defName={},delReason={}",
                    ht.getId(),
                    ht.getBusinessKey(),
                    ht.getStartTime(),
                    ht.getName(),
                    ht.getProcessDefinitionId(),
                    ht.getProcessDefinitionKey(),
                    ht.getProcessDefinitionName(),
                    ht.getDeleteReason());
        }
    }

    public void printTaskHistory(final String procDefKey) {
        final List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery()
                .processDefinitionKey(procDefKey)
                .orderByHistoricTaskInstanceEndTime()
                .desc()
                .list();
        for (final HistoricTaskInstance ht : list) {
            log.info("id={}, key={}, name={}, delReason={}",
                    ht.getId(),
                    ht.getTaskDefinitionKey(),
                    ht.getName(),
                    ht.getDeleteReason());
        }
    }

    @Transactional
    private void testSnapshot(final long consentId) {

        final ConsentHeader header = consentHeaderDAO.findOne(consentId);
        final List<ConsentSnapshot> snapshotList = snapshotService.findByConsentHeader(header);
        log.info("numberOfSnapshots={}", snapshotList.size());
        final ConsentSnapshot snapshot=new ConsentSnapshot();
        snapshot.setConsentHeader(header);

        try {
            final byte[] bytes=getBytes();
            final ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes);
            snapshotService.save(snapshot,
                    byteArrayInputStream,
                    bytes.length);
        } catch (IOException e) {
            log.error("caught: ", e);
        }
    }

    private byte[] getBytes() throws IOException {
        final String name="dev.db.properties";
        final InputStream inputStream = customerResourceLoader.getInputStream(name);
        //FileOutputStream out = new FileOutputStream(new File("/tmp/"+name));
        //IOUtils.copy(inputStream, out);
        return IOUtils.toByteArray(inputStream);
    }

}
