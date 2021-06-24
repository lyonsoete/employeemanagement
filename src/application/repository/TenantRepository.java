package application.repository;

import application.entity.RealEstate;
import application.entity.Tenant;
import application.hibernate.HibernateManager;
import org.hibernate.Session;

public class TenantRepository {

	private Session session = HibernateManager.getSessionFactory().openSession();



	private void startSession() {
		session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
	}

	private void closSession() {
		session.getTransaction().commit();
		session.close();
	}

	public void createRealEstate(Tenant tenant) {
		this.startSession();
		session.saveOrUpdate(tenant);
		this.closSession();
	}
}
