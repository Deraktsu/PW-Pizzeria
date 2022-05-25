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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class Carrello implements Serializable{


	private static final long serialVersionUID = 6634095732301309175L;

	private int id_carrello;
	
	
	private Date data_ordine;
	
	
	private Date orario_ordine;
	
	

	
	
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

	
	
}
