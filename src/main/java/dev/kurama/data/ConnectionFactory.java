package dev.kurama.data;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class ConnectionFactory {

    private static EntityManagerFactory entityManagerFactory;

    private ConnectionFactory() {
    }

    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null)
            synchronized (EntityManagerFactory.class) {
                if (entityManagerFactory == null)
                    entityManagerFactory = Persistence.createEntityManagerFactory("SurveyPersistenceUnit");
            }
        return entityManagerFactory.createEntityManager();
    }

    public static void close() {
        entityManagerFactory.close();
    }
}