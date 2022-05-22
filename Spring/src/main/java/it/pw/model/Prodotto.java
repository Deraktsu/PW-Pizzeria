package it.pw.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prodotti")
public class Prodotto implements Serializable{

	private static final long serialVersionUID = 2999766654118374688L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_prodotto;
	
	@Column(name = "nome", length = 255, nullable = false)
	private String nome;
	@Column(name = "descrizione", length = 255, nullable = false)
	private String descrizione;
	@Column(name = "prezzo", length = 255, nullable = false)
	private double prezzo;
	
	public int getId_prodotto() {
		return id_prodotto;
	}
	public void setId_prodotto(int id) {
		this.id_prodotto = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
}
