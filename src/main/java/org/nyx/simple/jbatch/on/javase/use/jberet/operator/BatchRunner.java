package org.nyx.simple.jbatch.on.javase.use.jberet.operator;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import org.jberet.runtime.JobExecutionImpl;

/**
 *
 * @author nyx
 */
public class BatchRunner {

    public int runner(String batchName) {
        JobOperator jobOperator = BatchRuntime.getJobOperator();

        Properties runtimejobProperties = new Properties();

        Long execututionId = jobOperator.start(batchName, runtimejobProperties);

        JobExecutionImpl jobExecutionImpl = (JobExecutionImpl) jobOperator.getJobExecution(execututionId);

        try {
            jobExecutionImpl.awaitTermination(0, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        switch (jobExecutionImpl.getBatchStatus()) {
            case COMPLETED:
                System.out.println("success.");
                return 0;

            default:
                System.out.println("failure.");
                return 1;
        }
    }
}
