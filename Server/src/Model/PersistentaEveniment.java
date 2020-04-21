package Model;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersistentaEveniment extends Persistenta{

	PersistentaEveniment(String x) {
		super(x);		
	}
	
	public Integer addEveniment(String tip, String locatie, Date data, Integer persoane) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer evenimentId = null;
		try {
			tx = session.beginTransaction();
			Eveniment eveniment = new Eveniment(tip,locatie,data,persoane);
			evenimentId = (Integer)session.save(eveniment);
			tx.commit();			
		}
		catch(HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		return evenimentId;
		
	}
	
	public Eveniment findEveniment(int id) {
		Eveniment eveniment = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			eveniment = session.get(Eveniment.class, id);
			tx.commit();			
		}
		catch(HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		return eveniment;
	}
	
	public boolean deleteEveniment(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Eveniment eveniment = session.get(Eveniment.class,id);
			session.delete(eveniment);
			tx.commit();
			
		}
		catch(HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Integer updateEveniment(int id, String tip, String locatie, Date data, Integer persoane) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Eveniment eveniment = session.get(Eveniment.class, id);
			eveniment.setTip(tip);
			eveniment.setLocatie(locatie);
			eveniment.setData(data);
			eveniment.setPersoane(persoane);
			tx.commit();
			return id;
			
		}
		catch(HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	

}
