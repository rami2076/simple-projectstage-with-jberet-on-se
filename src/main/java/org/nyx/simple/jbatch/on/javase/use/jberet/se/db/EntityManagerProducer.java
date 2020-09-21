/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nyx.simple.jbatch.on.javase.use.jberet.se.db;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.deltaspike.core.api.config.ConfigProperty;

/**
 *
 * @author nyx
 */
@ApplicationScoped
public class EntityManagerProducer {

    @Inject
    @ConfigProperty(name = "unitName", defaultValue = "nothing")
    private String unitName;

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitName);

    @Produces
    @EntityManagerQualifier
    public EntityManager getInstance() {
        return emf.createEntityManager();
    }

    public void dispose(@Disposes @EntityManagerQualifier EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    @PreDestroy
    public void preDestroy() {
        if (emf.isOpen()) {
            emf.close();
        }
    }

}
