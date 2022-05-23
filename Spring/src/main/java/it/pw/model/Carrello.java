package it.pw.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carrello")
public class Carrello implements Serializable{


	private static final long serialVersionUID = 6634095732301309175L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_carrello;
	
	@Column(name = "data_ordine", nullable = false)
	private Date data_ordine;
	
	@Column(name = "orario_ordine", nullable = false)
	private Date orario_ordine;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_utente",referencedColumnName="id_utente")
	private Utente utente;
	

	@OneToOne(
			mappedBy = "carrello", 
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
		)
	private Ordini ordini;

	
	
	public int getId_carrello() {
		return id_carrello;
	}

	public void setId_carrello(int id_carrello) {
		this.id_carrello = id_carrello;
	}

	public Date getData_ordine() {
		return data_ordine;
	}

	public void setData_ordine(Date data_ordine) {
		this.data_ordine = data_ordine;
	}

	public Date getOrario_ordine() {
		return orario_ordine;
	}

	public void setOrario_ordine(Date orario_ordine) {
		this.orario_ordine = orario_ordine;
	}

	

	public Ordini getOrdini() {
		return ordini;
	}

	public void setOrdini(Ordini ordini) {
		this.ordini = ordini;
	}
	
	
	
}
