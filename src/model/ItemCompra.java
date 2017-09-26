package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_compra")
public class ItemCompra extends BasicModel {

	private Integer quantidade;
	private Float valorUnitario;
	private Produto produto;
	private Compra compra;
	
	@Column(name = "quantidade")
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	@Column(name = "valor_unitario")
	public Float getValorUnitario() {
		return valorUnitario;
	}
	
	public void setValorUnitario(Float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@ManyToOne
	@JoinColumn(name = "compra_id")
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}	
}
