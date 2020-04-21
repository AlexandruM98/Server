package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.ContUtilizator;
import Model.Eveniment;
import Model.Persistenta;
import Model.PersistentaContUtilizator;
import Model.PersistentaEveniment;
import Model.PersistentaFactory;
import Model.Utilizator;

public class test {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		PersistentaFactory pers = new PersistentaFactory();
		PersistentaEveniment persistEvent = (PersistentaEveniment) pers.returnPersistenta("evenimente");
		
			
			
			
			
		
	}

}
