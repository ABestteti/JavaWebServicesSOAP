package org.ws.logincontrol.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class User implements Serializable {
	private static final long serialVersionUI = 1L;
	@Id
	@Column(name = "EMAIL", nullable = false)
	private String email;
	@Column(name = "NOME", nullable = false)
	private String nome;
	@Column(name = "SENHA", nullable = false)
	private String senha;
	
	public User() {		
	}
	
	public User(String email) {
		this.email = email;
	}
	
	public User(String email, String nome, String senha) {
		this.email = email;
		this.nome  = nome;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
