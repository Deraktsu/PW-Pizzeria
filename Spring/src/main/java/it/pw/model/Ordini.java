package it.pw.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ordini")
public class Ordini implements Serializable{
	

	private static final long serialVersionUID = -7960474985968887272L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ordine;
	
	public int getId_ordine() {
		return id_ordine;
	}


	public void setId_ordine(int id_ordine) {
		this.id_ordine = id_ordine;
	}


	@Column(name = "data_ordine", length = 255, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataOrdine;
	@Column(name = "orario_ritiro", length = 255, nullable = false)
	private String orarioRitiro;
	@Column(name = "prezzo_totale", length = 255, nullable = false)
	private double prezzoTotale;


	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_utente", referencedColumnName = "id_utente")
	private Utente utente;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable
		(	
				name = "ordini_prodotti",
				joinColumns = @JoinColumn(name = "id_ordine", referencedColumnName = "id_ordine"),
				inverseJoinColumns = @JoinColumn(name = "id_prodotto", referencedColumnName = "id_prodotto")
		)
	List<Prodotto> prodotti = new ArrayList<>();
	
 





	public Date getDataOrdine() {
		return dataOrdine;
	}


	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}


	public String getOrarioRitiro() {
		return orarioRitiro;
	}


	public void setOrarioRitiro(String orarioRitiro) {
		this.orarioRitiro = orarioRitiro;
	}


	public double getPrezzoTotale() {
		return prezzoTotale;
	}


	public void setPrezzoTotale(double prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}


	public List<Prodotto> getProdotti() {
		return prodotti;
	}


	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}


	public Utente getUtente() {
		return utente;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}





}
