package org.nyx.simple.jbatch.on.javase.use.lib.common.interceptor;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.nyx.simple.jbatch.on.javase.use.jberet.batch.common.api.Result;
import org.nyx.simple.jbatch.on.javase.use.jberet.batch.common.api.ResultHolder;

/**
 *
 * @author nyx
 */
@Interceptor
@ServiceOperation
@Priority(Interceptor.Priority.LIBRARY_AFTER)
public class ServiceInterceptor {

    @Inject
    private ResultHolder resultHolder;

    @AroundInvoke
    public Object setResult(InvocationContext ic) throws Exception {

        boolean result = (boolean) ic.proceed();

        if (result) {
            resultHolder.setResult(Result.SUCSSES);

        } else {
            resultHolder.setResult(Result.FAILURE);
        }

        return result;

    }
}
