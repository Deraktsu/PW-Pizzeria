package it.pw.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "tipologia")
public class Tipologia implements Serializable{

	private static final long serialVersionUID = -1059228043468995766L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipologia;
	
	
	@Column(name = "descrizione", length = 255, nullable = false)
	private String descrizione;
	/*
	@OneToMany
	(
			mappedBy = "tipologia", 
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
	)
	private List<Prodotto> prodotti = new ArrayList<>();
	
	*/
	public int getId_tipologia() {
		return id_tipologia;
	}

	public void setId_tipologia(int id_tipologia) {
		this.id_tipologia = id_tipologia;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	
	
	
	
}
