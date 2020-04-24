package Controller;

import java.net.*;

import Model.*;

import java.io.*;

public class ServerController {
	
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	private Persistenta pers;
	private PersistentaFactory persFact = new PersistentaFactory();
	

	private void adaugaEveniment(Eveniment obj) {
		System.out.println("Adaugam un eveniment !");
		pers = persFact.returnPersistenta("evenimente");
		Integer id = ((PersistentaEveniment)pers).addEveniment(obj);
		try {
			out.writeObject(id);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	
	private void stergeEveniment(Integer id) {
		System.out.println("Stergem evenimentul");
		pers = persFact.returnPersistenta("evenimente");
		boolean deleted = ((PersistentaEveniment)pers).deleteEveniment(id);
		try {
			out.writeObject(deleted);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	private void gasesteEveniment(Integer id) {
		System.out.print("Cautam evenimentul ");
		pers = persFact.returnPersistenta("evenimente");
		Eveniment event = ((PersistentaEveniment)pers).findEveniment(id);
		try {
			out.writeObject(event);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

	private void updateEvent(Eveniment event) {
		pers = persFact.returnPersistenta("evenimente");
		Integer id = ((PersistentaEveniment)pers).updateEveniment(event);
		try {
			out.writeObject(id);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	private void checkCont(ContUtilizator cont) {
		pers = persFact.returnPersistenta("utilizatori");
		boolean ok = ((PersistentaContUtilizator)pers).checkValidityForLogIn(cont);
		try {
			out.writeObject(ok);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private void salvareCont(ContUtilizator cont) {
		pers = persFact.returnPersistenta("utilizatori");
		Integer id =((PersistentaContUtilizator)pers).addContUtilizator(cont);
			try {
				out.writeObject(id);
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
	
	public void start(int port) {
		try {
			serverSocket = new ServerSocket(port);
			clientSocket = serverSocket.accept();
			System.out.print("Client connected ");
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new ObjectInputStream(clientSocket.getInputStream());
			String mesaj = "";
			while(!mesaj.equals("exit")) {				
					Request req = (Request) in.readObject();
					
					if(req.getOperation().equals("addEvent")) {
						adaugaEveniment((Eveniment)req.getObj());						
					}
					if(req.getOperation().equals("delEvent")) {
						stergeEveniment((Integer)req.getObj());
					}
					if(req.getOperation().equals("findEvent")) {
						gasesteEveniment((Integer)req.getObj());
					}
					if(req.getOperation().equals("updateEvent")) {
						updateEvent((Eveniment)req.getObj());
					}
					if(req.getOperation().equals("logIn")) {
						checkCont((ContUtilizator)req.getObj());
					}
					if(req.getOperation().equals("saveAcc")) {
						salvareCont((ContUtilizator)req.getObj());
					}
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	



	public void stop() {
		try {
			in.close();
			out.close();
			clientSocket.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		System.out.println("Eu sunt serverul !");
		ServerController server = new ServerController();
		server.start(6666);
		
		
		
		
		
		
	}

}
