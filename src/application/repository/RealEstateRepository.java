package application.repository;

import application.entity.Address;
import application.entity.RealEstate;
import application.hibernate.HibernateManager;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class RealEstateRepository {

	private Session session = HibernateManager.getSessionFactory().openSession();

	private void startSession() {
		session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
	}

	private void closeSession() {
		session.getTransaction().commit();
		session.close();
	}

	public List<RealEstate> getList() {
		startSession();
		List<RealEstate> list = session.createQuery("from RealEstate").getResultList();
		closeSession();
		return list;
	}

	public void saveOrUpdate(RealEstate realEstate) {
		this.startSession();
		Query query = session.createQuery("from Address where streetName = :streetName and number = :number and plz = :plz and location = :location ");
		query.setParameter("streetName", realEstate.getAddress().getStreetName());
		query.setParameter("number", realEstate.getAddress().getNumber());
		query.setParameter("plz", realEstate.getAddress().getPlz());
		query.setParameter("location", realEstate.getAddress().getLocation());
		Address address = null;
		try {
			address = (Address) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Diese Adresse wurde nicht gefunden, eine neue Adresse wird angelegt.");
		}
		if (address != null) {
			realEstate.setAddress(address);
		}
		session.saveOrUpdate(realEstate);
		this.closeSession();
	}

	public void delete(RealEstate id) {
		startSession();
		session.delete(id);
		closeSession();
	}
}
