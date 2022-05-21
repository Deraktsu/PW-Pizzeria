package it.pw.model;

public class Prodotto {

	private int id_prodotto;
	private String nome;
	private String descrizione;
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
