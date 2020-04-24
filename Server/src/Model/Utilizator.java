package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utilizator")

public class Utilizator implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nume")
	private String nume;
	
	@Column(name = "prenume")
	private String prenume;
	
	@Column(name = "tip")	
	private String tip;
	
	
	public Utilizator() {
		
	}


	public Utilizator(String nume, String prenume, String tip) {		
		this.nume = nume;
		this.prenume = prenume;
		this.tip = tip;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNume() {
		return nume;
	}


	public void setNume(String nume) {
		this.nume = nume;
	}


	public String getPrenume() {
		return prenume;
	}


	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}


	public String getTip() {
		return tip;
	}


	public void setTip(String tip) {
		this.tip = tip;
	}


	@Override
	public String toString() {
		return "Utilizator [id=" + id + ", nume=" + nume + ", prenume=" + prenume + ", tip=" + tip + "]";
	}
	
	
	
	
	

}
