package org.nyx.simple.jbatch.on.javase.use.jberet.batchlet;

import java.util.stream.IntStream;
import javax.batch.api.Batchlet;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author nyx
 */
@Dependent
@Named("SimpleBatchlet")
public class SimpleBatchlet implements Batchlet {



    @Override
    public String process() throws Exception {

        IntStream.range(0, 10).forEach(System.out::println);

        return "COMPLETED";
    }

    @Override
    public void stop() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
