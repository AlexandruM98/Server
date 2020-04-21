package Model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersistentaContUtilizator extends Persistenta {

	public PersistentaContUtilizator(String x) {
		super(x);		
	}
	
	public Integer addContUtilizator(String user, String pass, Utilizator util) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer contUtilizatorId = null;
		try{
			tx = session.beginTransaction();
			ContUtilizator cont = new ContUtilizator(util,user,pass);
			contUtilizatorId = (Integer) session.save(cont);
			tx.commit();
			
		}
		catch(HibernateException e){
			if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
			
		}	
		
		return contUtilizatorId;
		
	}
	
	public ContUtilizator findContUtilizator(int id) {
		ContUtilizator cont = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
		tx = session.beginTransaction();
		cont = session.get(ContUtilizator.class, id);
		tx.commit();
		}
		catch(HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}		
		return cont;
		
	}
	
	public boolean deleteContUtilizator(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			ContUtilizator cont = session.get(ContUtilizator.class,id);
			session.delete(cont);
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
	
	public Integer updateContUtilizator(int id,String nume,String prenume,String user,String pass) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			ContUtilizator cont = session.get(ContUtilizator.class, id);
			Utilizator u = session.get(Utilizator.class, id);
			cont.setPass(pass);
			cont.setUser(user);		
			u.setNume(nume);
			u.setPrenume(prenume);
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
	
	public boolean checkValidityForLogIn(String user,String pass, String tip){
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<ContUtilizator> conturi = session
											.createQuery("from ContUtilizator")
											.getResultList();
			for(ContUtilizator cont : conturi) {
				if(cont.getUtilizator().getTip().matches(tip) & cont.getUser().matches(user) & cont.getPass().matches(pass))
					return true;
			}
			
					
		}
		catch(HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}
		
		return false;
		
	}
	
	
	

}
