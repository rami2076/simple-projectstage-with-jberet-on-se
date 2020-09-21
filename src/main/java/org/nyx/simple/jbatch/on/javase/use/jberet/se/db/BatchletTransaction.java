package org.nyx.simple.jbatch.on.javase.use.jberet.se.db;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

/**
 * https://github.com/kencharos/java_batch_app_se/blob/master/src/main/java/se/SeTransactionInterceptor.java
 *
 * @author nyx
 */
@Transactional
@Interceptor
public class BatchletTransaction {

    @Inject
    @EntityManagerQualifier
    private EntityManager em;

    @AroundInvoke
    public Object doTransaction(InvocationContext ic) throws Exception {
        EntityTransaction tx = em.getTransaction();
        Object result = null;
        try {
            if (!tx.isActive()) {
                tx.begin();
            }
            System.out.println("tx interceptor start");
            result = ic.proceed();
            if (tx.isActive()) {
                tx.commit();
            }
        } catch (Exception e) {
            try {
                if (tx.isActive()) {
                    tx.rollback();
                }
            } catch (Exception e2) {
            }
            throw e;
        }
        return result;
    }
}
