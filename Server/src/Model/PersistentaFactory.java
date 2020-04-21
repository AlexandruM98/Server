package Model;

public class PersistentaFactory {
	public PersistentaFactory() {
		
		
	}
	
	public Persistenta returnPersistenta(String x) {
		if(x.equals("utilizatori")) {
			return new PersistentaContUtilizator(x);
		}
		if(x.equals("evenimente")) {
			return new PersistentaEveniment(x);
		}
		return null;
	}

}
