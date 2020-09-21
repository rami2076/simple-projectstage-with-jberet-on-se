package org.nyx.simple.jbatch.on.javase.use.jberet.batch.common.impl;

import javax.batch.runtime.BatchStatus;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.nyx.simple.jbatch.on.javase.use.jberet.batch.common.api.BatchFinisher;
import org.nyx.simple.jbatch.on.javase.use.jberet.batch.common.api.ResultHolder;

/**
 *
 * @author nyx
 */
@RequestScoped
public class BatchFinisherImpl implements BatchFinisher {

    @Inject
    private JobParameterImple jobParameter;

    @Inject
    private ResultHolder resultHolder;

    @Override
    public String setBatchExitStatus() {

        switch (resultHolder.getResult()) {
            case SUCSSES:
                jobParameter.getJobExecution().setBatchStatus(BatchStatus.COMPLETED);
                return "COMPLETE";
            case FAILURE:
            default:
                jobParameter.getJobExecution().setBatchStatus(BatchStatus.FAILED);
                return "FAILED";
        }

    }

    @Override
    public String setStepStatus() {
        switch (resultHolder.getResult()) {
            case SUCSSES:
                //未実装
                return "COMPLETE";
            case FAILURE:
            default:
                //未実装
                return "FAILED";
        }
    }

}
