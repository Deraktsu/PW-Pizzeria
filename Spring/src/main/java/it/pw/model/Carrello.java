package it.pw.model;

public class Carrello {

	private int id_ordine;
	private int id_prodotto;
	private String nome;
	private Double prezzo;
	private int quantita;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public int getId_ordine() {
		return id_ordine;
	}
	public void setId_ordine(int id_ordine) {
		this.id_ordine = id_ordine;
	}
	public int getId_prodotto() {
		return id_prodotto;
	}
	public void setId_prodotto(int id_prodotto) {
		this.id_prodotto = id_prodotto;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
}
