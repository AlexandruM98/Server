package Model;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersistentaEveniment extends Persistenta{

	PersistentaEveniment(String x) {
		super(x);		
	}
	
	public Integer addEveniment(Eveniment e) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer evenimentId = null;
		try {
			tx = session.beginTransaction();			
			evenimentId = (Integer)session.save(e);
			tx.commit();			
		}
		catch(HibernateException ee) {
			if(tx!=null)
				tx.rollback();
			ee.printStackTrace();
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
	
	public Integer updateEveniment(Eveniment event) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Eveniment eveniment = session.get(Eveniment.class, event.getId());
			eveniment.setTip(event.getTip());
			eveniment.setLocatie(event.getLocatie());
			eveniment.setData(event.getData());
			eveniment.setPersoane(event.getPersoane());
			tx.commit();
			return event.getId() ;
			
		}
		catch(HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	

}
