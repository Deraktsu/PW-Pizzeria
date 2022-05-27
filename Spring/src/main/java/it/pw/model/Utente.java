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
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "utente")
public class Utente implements Serializable{
	
	private static final long serialVersionUID = 4280897582555117959L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_utente;
	
	@Pattern(regexp = "[a-zA-Zטיעאשל\\s']{1,255}",message = "{user.form.error.general}")
	@Column(name = "nome", length = 255, nullable = false)
	private String nome;
	
	@Pattern(regexp = "[a-zA-Zטיעאשל\\s']{1,255}",message = "{user.form.error.general}")
	@Column(name = "cognome", length = 255, nullable = false)
	private String cognome;
	
	@Pattern(regexp = "[+_\\s0-9-]{1,255}",message = "{user.form.error.general}")
	@Column(name = "telefono", length = 255, nullable = false)
	private String telefono;
	
	@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",message = "{user.form.error.general}")
	@Column(name = "email", length = 255, nullable = false)
	private String email;
	
	@Pattern(regexp = "[a-zA-Z1-9טיעאשל\\s'!#]{1,255}",message = "{user.form.error.general}")
	@Column(name = "password", length = 255, nullable = false)
	private String password;
	
	
	@OneToMany
		(
			mappedBy = "utente", 
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
		)
	private List<Ordine> ordini = new ArrayList<>();;
	



	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

	public int getId_utente() {
		return id_utente;
	}

	public void setId_utente(int id) {
		this.id_utente = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsername() {
		return getEmail();
	}

	public String getEmail() {
		return email;
	}

	public void setUsername(String email) {
		setEmail(email);
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
