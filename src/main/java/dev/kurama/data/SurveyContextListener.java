package dev.kurama.data;

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
        deregisterDrivers();
        System.out.println("Survey End");
    }

    private void deregisterDrivers() {
        //        Enumeration<Driver> drivers = DriverManager.getDrivers();
//        while (drivers.hasMoreElements()) {
//            Driver driver = drivers.nextElement();
//            try {
//                DriverManager.deregisterDriver(driver);
//                System.out.printf("deregistering jdbc driver: %s", driver);
//            } catch (SQLException e) {
//                e.printStackTrace();
//                System.out.printf("Error deregistering driver %s", driver);
//            }
//
//        }
    }


}
