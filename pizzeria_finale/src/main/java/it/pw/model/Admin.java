package it.pw.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "admin")
public class Admin implements Serializable{

	private static final long serialVersionUID = -5060658514902796165L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_admin;
	@Column(name = "username", length = 255, nullable = false)
	private String username;
	@Column(name = "password", length = 255, nullable = false)
	private String password;
	
	
	public int getId_admin() {
		return id_admin;
	}
	public void setId_admin(int id) {
		this.id_admin = id;
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
