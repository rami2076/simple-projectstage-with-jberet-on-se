package org.nyx.simple.jbatch.on.javase.use.jberet.se.scope;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.jboss.weld.context.RequestContext;
import org.jboss.weld.context.unbound.Unbound;

/**
 * https://github.com/weld/core/blob/2.4/impl/src/main/java/org/jboss/weld/context/activator/ActivateRequestContextInterceptor.java
 *
 * @author nyx
 */
@Interceptor
@RequestContextInterceptor
@Priority(value = Interceptor.Priority.APPLICATION)
public class RequestContecxtOperator {

    @Inject
    @Unbound
    private RequestContext requestContext;

    @AroundInvoke
    public Object start(InvocationContext ic) {
        Object result = null;

        requestContext.activate();

        try {
            result = ic.proceed();

        } catch (Exception ex) {
            Logger.getLogger(RequestContecxtOperator.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            requestContext.invalidate();
            requestContext.deactivate();
        }

        return result;

    }

}
