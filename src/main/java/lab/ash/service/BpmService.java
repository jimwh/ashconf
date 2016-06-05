package lab.ash.service;

import java.util.List;
import javax.annotation.Resource;
import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BpmService{

    @Resource
    private HistoryService historyService;

    private static final Logger log = LoggerFactory.getLogger(BpmService.class);

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


}
