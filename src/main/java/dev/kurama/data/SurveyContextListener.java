package dev.kurama.data;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SurveyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Survey Init");
        sce.getServletContext().setAttribute("emf", ConnectionFactory.getEntityManagerFactory());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ConnectionFactory.getEntityManagerFactory().close();
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                log(String.format("deregistering jdbc driver: %s", driver));
            } catch (SQLException e) {
                e.printStackTrace();
                log(String.format("Error deregistering driver %s", driver));
            }

        }
        System.out.println("Survey End");
    }

    void log(String string) {
        System.out.println(string);
    }


}
