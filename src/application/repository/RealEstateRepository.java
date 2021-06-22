package application.repository;

import application.entity.RealEstate;
import application.hibernate.HibernateManager;
import org.hibernate.Session;

public class RealEstateRepository {

  private Session session = HibernateManager.getSessionFactory().openSession();

  private void startSession() {
    session = HibernateManager.getSessionFactory().openSession();
    session.beginTransaction();
  }

  private void closSession() {
    session.getTransaction().commit();
    session.close();
  }

  public void createRealEstate(RealEstate realEstate) {
    this.startSession();
    session.saveOrUpdate(realEstate);
    this.closSession();
  }
}
