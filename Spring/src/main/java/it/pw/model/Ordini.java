package it.pw.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordini")
public class Ordini implements Serializable{
	

	private static final long serialVersionUID = -7960474985968887272L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ordine;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_prodotto", referencedColumnName = "id_prodotto")
	private Prodotto prodotti;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_carrello", referencedColumnName = "id_carrello")
	private Carrello carrello;
	


	private int quantita;




	public Prodotto getProdotti() {
		return prodotti;
	}


	public void setProdotti(Prodotto prodotti) {
		this.prodotti = prodotti;
	}


	public Carrello getCarrello() {
		return carrello;
	}


	public void setCarrello(Carrello carrello) {
		this.carrello = carrello;
	}


	public int getId_ordine() {
		return id_ordine;
	}


	public void setId_ordine(int id_ordine) {
		this.id_ordine = id_ordine;
	}



	public int getQuantita() {
		return quantita;
	}


	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}


	

}
