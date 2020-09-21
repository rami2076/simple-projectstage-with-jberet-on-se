package org.nyx.simple.jbatch.on.javase.use.jberet.operator;

/**
 *
 * @author nyx
 */
public class AppMain {

    public static void main(String[] args) {

        int result = 1; //fail=1 success=0;
        if (args.length != 1) {
            System.exit(result);
        }

        String batchName = args[0];

        BatchRunner r = new BatchRunner();
        result = r.runner(batchName);
        System.exit(result);

    }

}
