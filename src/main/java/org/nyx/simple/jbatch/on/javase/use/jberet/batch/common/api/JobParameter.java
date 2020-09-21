package org.nyx.simple.jbatch.on.javase.use.jberet.batch.common.api;

import java.util.Properties;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.JobExecution;

/**
 *
 * @author nyx
 */
public interface JobParameter {

    public Long getExecutionId();

    public Properties getRuntimeParamert();

    public Properties getJobProperties();

    public Properties getStepProperties();

    public <T extends JobExecution> T getJobExecution();

    public <T extends JobOperator> T getJobOperator();

}
