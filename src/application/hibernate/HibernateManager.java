package application.hibernate;

import application.entity.Address;
import application.entity.RealEstate;
import application.entity.Tenant;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateManager {
  private static SessionFactory sessionFactory = null;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      sessionFactory = buildSessionFactory();
    }
    return sessionFactory;
  }

  public static void shutdown() {
    getSessionFactory().close();
  }

  private static SessionFactory buildSessionFactory() {
    try {
      Configuration configuration = new Configuration();
      configuration.setProperty("hibernate.connection.username", "root");
      configuration.setProperty("hibernate.connection.password", "");
      configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hausbau_gbr?useSSL=false&serverTimezone=Europe/Berlin");
      configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
      configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
      configuration.setProperty("hibernate.hbm2ddl.auto", "update");
      configuration.setProperty("hibernate.show_sql", "true");
      configuration.setProperty("hibernate.format_sql", "true");
      configuration.setProperty("hibernate.use_sql_comments", "true");

      configuration.addAnnotatedClass(RealEstate.class);
      configuration.addAnnotatedClass(Address.class);
      configuration.addAnnotatedClass(Tenant.class);


      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
      return configuration.buildSessionFactory(serviceRegistry);
    } catch (Throwable ex) {
      System.err.println("ERROR: Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }
}
