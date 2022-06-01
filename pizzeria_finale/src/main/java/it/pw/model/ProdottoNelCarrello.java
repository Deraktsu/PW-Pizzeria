package it.pw.model;

public class ProdottoNelCarrello {  

	private int idOrdine;
	
	private int idProdotto;
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
	public int getIdOrdine() {
		return idOrdine;
	}
	public void setId_ordine(int idOrdine) {
		this.idOrdine = idOrdine;
	}
	public int getId_prodotto() {
		return idProdotto;
	}
	public void setId_prodotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
}
