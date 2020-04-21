package Model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Persistenta {
	
	protected static SessionFactory factory;
	
	Persistenta(String x){
		if(x.equals("utilizatori")) {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(ContUtilizator.class)
				.addAnnotatedClass(Utilizator.class)
				.buildSessionFactory();
		}
		if(x.equals("evenimente")) {
			factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Eveniment.class)
					.buildSessionFactory();
		}
	}

}
