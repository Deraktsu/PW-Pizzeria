package it.pw.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "anagrafica")
public class User implements Serializable{
	
	
	private static final long serialVersionUID = 4280897582555117959L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_anagrafica;
	
	@Pattern(regexp = "[a-zA-Zטיעאשל\\s']{1,255}",message = "{user.form.error.general}")
	@Column(name = "nome", length = 255, nullable = false)
	private String nome;
	
	@Pattern(regexp = "[a-zA-Zטיעאשל\\s']{1,255}",message = "{user.form.error.general}")
	@Column(name = "cognome", length = 255, nullable = false)
	private String cognome;
	
	@Pattern(regexp = "[1-9]{1,255}",message = "{user.form.error.general}")
	@Column(name = "telefono", length = 255, nullable = false)
	private String telefono;
	
	@Pattern(regexp = "[a-zA-Z1-9Zטיעאשל\\s']{1,255}",message = "{user.form.error.general}")
	@Column(name = "username", length = 255, nullable = false)
	private String username;
	
	@Pattern(regexp = "[a-zA-Z1-9טיעאשל\\s'!#]{1,255}",message = "{user.form.error.general}")
	@Column(name = "password", length = 255, nullable = false)
	private String password;

	public int getId_anagrafica() {
		return id_anagrafica;
	}

	public void setId_anagrafica(int id_anagrafica) {
		this.id_anagrafica = id_anagrafica;
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
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
}
