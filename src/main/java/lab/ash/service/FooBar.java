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

    @Resource
    private transient BpmService bpmService;

    public String getDir() {
        final List<ConsentHeader> list = consentHeaderDAO.findAll();
        log.info("size={}", list.size());
        if( !list.isEmpty() ) {
            //testSnapshot(list.get(list.size()-1).getId());
        }
        //bpmService.printProcessHistory("IacucApprovalProcess");
        //bpmService.printTaskHistory("IacucApprovalProcess");
        log.info("runtimeService={}", runtimeService != null);
        return env.getProperty("downloadDirectory");
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
