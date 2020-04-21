package Model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "eveniment")
public class Eveniment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "tip")
	private String tip;
	
	@Column(name = "locatie")
	private String locatie;
	
	@Column(name = "data")
	private Date data;
	
	@Column(name = "persoane")
	private int persoane;
	
	public Eveniment() {
		
	
	}

	public Eveniment(String tip, String locatie, Date data, int persoane) {
		super();
		this.tip = tip;
		this.locatie = locatie;
		this.data = data;
		this.persoane = persoane;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getPersoane() {
		return persoane;
	}

	public void setPersoane(int persoane) {
		this.persoane = persoane;
	}

	@Override
	public String toString() {
		return "Eveniment [id=" + id + ", tip=" + tip + ", locatie=" + locatie + ", data=" + data + ", persoane="
				+ persoane + "]";
	}
	
	
	
	
	
	

}
