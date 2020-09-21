package org.nyx.simple.jbatch.on.javase.use.jberet.batch.common.impl;

import org.nyx.simple.jbatch.on.javase.use.jberet.batch.common.api.Result;
import org.nyx.simple.jbatch.on.javase.use.jberet.batch.common.api.ResultHolder;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author nyx
 */
@RequestScoped
public class ResultHolderImpl implements ResultHolder {

    private Result result;

    @Override
    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public Result getResult() {
        return result;
    }

}
