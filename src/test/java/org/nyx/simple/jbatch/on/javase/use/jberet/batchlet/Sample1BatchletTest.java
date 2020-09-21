package org.nyx.simple.jbatch.on.javase.use.jberet.batchlet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.nyx.simple.jbatch.on.javase.use.jberet.operator.BatchRunner;

/**
 *
 * @author nyx
 */
@RunWith(JUnit4.class)
public class Sample1BatchletTest {

    private static int SUCCESS = 0;

    private static int FAILURE = 1;

    @Test
    public void Test() throws Exception {
        BatchRunner batchRunner = new BatchRunner();

        int result = batchRunner.runner("Sample1Batchlet");

        Assert.assertEquals(FAILURE, result);

    }

}
