package model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "venda")
public class Venda extends BasicModel {

	private Date data;
	private Usuario usuario;
	private Cliente cliente;
	private List<ItemVenda> itens;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data")
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
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
	@JoinColumn(name = "cliente_id")
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@OneToMany(mappedBy = "venda_id")
	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}
}
