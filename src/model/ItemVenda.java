package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_venda")
public class ItemVenda extends BasicModel {

	private Integer quantidade;
	private Float valorUnitario;
	private Produto produto;
	private Venda venda;
	
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
	
	public void setValorUnitario(Float valor_unitario) {
		this.valorUnitario = valor_unitario;
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
	@JoinColumn(name = "venda_id")
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
}
