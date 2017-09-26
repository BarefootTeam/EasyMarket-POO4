package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuario")
public class Usuario extends BasicModel {

	private String nome;
	private String cpf;
	private String login;
	private String senha;
	private Integer tipo;
	private Date dataInativo;
	private Date dataCadastro;
	
	@Column(name = "nome")
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "cpf")
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Column(name = "login")
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Column(name = "senha")
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Column(name = "tipo")
	public Integer getTipo() {
		return tipo;
	}
	
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_inativo")
	public Date getDataInativo() {
		return dataInativo;
	}
	
	public void setDataInativo(Date dataInativo) {
		this.dataInativo = dataInativo;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro")
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
