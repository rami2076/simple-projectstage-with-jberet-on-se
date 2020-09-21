package org.nyx.simple.jbatch.on.javase.use.jberet.batch.common.impl;

import org.nyx.simple.jbatch.on.javase.use.jberet.batch.common.api.JobParameter;
import java.util.Properties;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.jberet.operations.AbstractJobOperator;
import org.jberet.runtime.JobExecutionImpl;
import org.jberet.spi.JobOperatorContext;

/**
 *
 * @author nyx
 */
@RequestScoped
public class JobParameterImple implements JobParameter {

    @Inject
    private JobContext jobContext;

    @Inject
    private StepContext stepContext;

    @Override
    public Long getExecutionId() {
        return jobContext.getExecutionId();
    }

    @Override
    public Properties getRuntimeParamert() {
        return getJobExecution().getJobParameters();
    }

    @Override
    public Properties getJobProperties() {
        return jobContext.getProperties();
    }

    @Override
    public JobExecutionImpl getJobExecution() {
        return (JobExecutionImpl) getJobOperator().getJobExecution(getExecutionId());

    }

    @Override
    public AbstractJobOperator getJobOperator() {
        return (AbstractJobOperator) JobOperatorContext.getJobOperatorContext().getJobOperator();
    }

    @Override
    public Properties getStepProperties() {
        return stepContext.getProperties();
    }

}
