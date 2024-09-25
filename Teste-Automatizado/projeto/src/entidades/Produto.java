package entidades;



public class Produto {

	private String nome;
	private String tipo;
	private float valorCompra;
	private float valorVenda;
	private Integer disponibilidade;
	
	public Produto(String nome, String tipo, float valorCompra, float valorVenda, Integer disponibilidade) {		
		this.nome = nome;
		this.tipo = tipo;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;		
		this.disponibilidade = disponibilidade;
	}
	
	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		nome = nome;
	}

	public String gettipo() {
		return tipo;
	}

	public void settipo(String tipo) {
		tipo = tipo;
	}

	public float getvalorCompra() {
		return valorCompra;
	}

	public void setvalorCompra(float valorCompra) {
		valorCompra = valorCompra;
	}

	public float getvalorVenda() {
		return valorVenda;
	}

	public void setvalorVenda(float valorVenda) {
		valorVenda = valorVenda;
	}

	public Integer getdisponibilidade() {
		return disponibilidade;
	}

	public void setdisponibilidade(Integer disponibilidade) {
		disponibilidade = disponibilidade;
	}
	
		
}
