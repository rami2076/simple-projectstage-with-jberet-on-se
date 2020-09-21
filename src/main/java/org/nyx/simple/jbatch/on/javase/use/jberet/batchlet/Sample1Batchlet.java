package org.nyx.simple.jbatch.on.javase.use.jberet.batchlet;

import javax.batch.api.Batchlet;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import org.nyx.simple.jbatch.on.javase.use.jberet.batch.common.api.BatchFinisher;
import org.nyx.simple.jbatch.on.javase.use.jberet.se.scope.RequestContextInterceptor;
import org.nyx.simple.jbatch.on.javase.use.lib.sample1.Sample1Service;

/**
 *
 * @author nyx
 */
@Dependent
@Named("Sample1Batchlet")
public class Sample1Batchlet implements Batchlet {

    @Inject
    private Sample1Service sample1Command;

    @Inject
    private BatchFinisher batchFinisher;

    @RequestContextInterceptor
    @Override
    public String process() throws Exception {

        System.out.println("##" + sample1Command.isUnitTest());
        batchFinisher.setBatchExitStatus();

        return "COMPLETE";
    }

    @Override
    public void stop() throws Exception {
    }

}
