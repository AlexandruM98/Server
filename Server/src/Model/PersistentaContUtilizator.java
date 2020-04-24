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
	
	public Integer addContUtilizator(ContUtilizator cont) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer contUtilizatorId = null;
		try{
			tx = session.beginTransaction();			
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
	
	public boolean checkValidityForLogIn(ContUtilizator cont){
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<ContUtilizator> conturi = session
											.createQuery("from ContUtilizator")
											.getResultList();
			for(ContUtilizator contt : conturi) {
				if(contt.getUtilizator().getTip().matches(cont.getUtilizator().getTip()) & contt.getUser().matches(cont.getUser()) & contt.getPass().matches(cont.getPass()))
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
