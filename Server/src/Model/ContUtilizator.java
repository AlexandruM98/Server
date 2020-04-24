package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contutilizator")
public class ContUtilizator implements Serializable {
	
	@Id
	private int id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Utilizator utilizator;
	
	@Column(name = "username")
	private String user;
	
	@Column(name = "password")
	private String pass;
	
	public ContUtilizator() {
		
	}
	
	

	public ContUtilizator(Utilizator utilizator, String user, String pass) {
		super();
		this.utilizator = utilizator;
		this.user = user;
		this.pass = pass;
	}

	public Utilizator getUtilizator() {
		return utilizator;
	}

	public void setUtilizator(Utilizator utilizator) {
		this.utilizator = utilizator;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "ContUtilizator [id=" + id + ", utilizator=" + utilizator + ", user=" + user + ", pass=" + pass + "]";
	}
	
	
	

}
