package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "preco")
public class Preco extends BasicModel {

	private Float valor;
	private Date dataInicio;
	private Date dataFinal;
	private Date dataCadastro;
	private Usuario usuario;
	private Produto produto;
	
	@Column(name = "valor")
	public Float getValor() {
		return valor;
	}
	
	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicio")
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_final")
	public Date getDataFinal() {
		return dataFinal;
	}
	
	
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro")
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
