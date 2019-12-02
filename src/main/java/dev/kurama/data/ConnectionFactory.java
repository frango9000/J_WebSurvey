package dev.kurama.data;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class ConnectionFactory {

    private static EntityManagerFactory entityManagerFactory;

    private ConnectionFactory() {
    }

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null)
            entityManagerFactory = Persistence.createEntityManagerFactory("SurveyPersistenceUnit");
        return entityManagerFactory;
    }

    public static void close() {
        entityManagerFactory.close();
    }
}