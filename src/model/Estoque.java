package model;

public class Estoque {
	
	private Produto produto;	
	private Integer quantidadeDisponivel;
	private Integer quantidadeComprada;
	private Integer quantidadeVendida;	
	
	public Integer getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}
	public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}
	public Integer getQuantidadeComprada() {
		return quantidadeComprada;
	}
	public void setQuantidadeComprada(Integer quantidadeComprada) {
		this.quantidadeComprada = quantidadeComprada;
	}
	public Integer getQuantidadeVendida() {
		return quantidadeVendida;
	}
	public void setQuantidadeVendida(Integer quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}	
}
