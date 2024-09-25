package servico;


import entidades.Usuario;
import modelo.ProdutoModelo;
import modelo.UsuarioModelo;
import entidades.Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Servicos {

	private UsuarioModelo usuarioModelo;
	private ProdutoModelo produtoModelo;
	
	public Servicos() {
		this.usuarioModelo = new UsuarioModelo();
		this.produtoModelo = new ProdutoModelo();
    }
	
	
	public String realizarLogin(String cpf, String senha) {
		String sql = "select Funcao from login where Cpf = '"+ cpf +"'and Senha = '"+ senha +"'";	
		String result =this.usuarioModelo.realizarLogin(sql);
		if(result.equals("Vendedor")||result.equals("Repositor")||result.equals("Gerente"))
		{
			System.out.println("Logando");
			return this.usuarioModelo.realizarLogin(sql);
		}
		else {
			System.out.println("Impossível Logar");
			return "nulo";
		}
		

		}
	
	public Boolean realizarCadastroUsuario(Usuario user) {
		
		
		String sql = "select count(*) from login where Cpf = '"+ user.getcpf() +"'";
		String sql2 = "insert into login (Nome, Cpf, Senha, Funcao)"+"values('"+user.getnome() +"', '"+ user.getcpf() +"','" + user.getsenha() + "','" + user.getfuncao() +"')";
		if(this.usuarioModelo.realizarCadastroUsuario(sql, sql2)== true)
		{
			System.out.println("Usuário Cadastrado com sucesso");
			return true;
		}
		else {
			System.out.println("Impossível cadastrar usuário");
			return false;
		}
	}
	
	
	public Boolean realizarCadastroProduto(Produto product) {
		
		
		String sql = "select count(*) from produtos where Nome = '"+ product.getnome() +"'";
		String sql2 = "insert into produtos (Nome, Tipo, ValorCompra, ValorVenda, Disponibilidade)"+"values('"+ product.getnome() +"', '"+ product.gettipo() +"','" + product.getvalorCompra() + "','" + product.getvalorVenda() + "', '"+ product.getdisponibilidade() +"')";
		
		if(this.produtoModelo.realizarCadastroProduto(sql, sql2)== true)
		{
			System.out.println("Produto Cadastrado com sucesso");
			return true;
		}
		else {
			System.out.println("Impossível cadastrar produto");
			return false;
		}
	}

	
	public boolean listarProdutos() {
		
		String sql = "select * from produtos";
		
		if(this.produtoModelo.listarProdutos(sql)== true)
		{
			System.out.println("Listando Produtos");
			return true;
		}
		else {
			System.out.println("Impossível listar produtos");
			return false;
		}
		
			
	}
	

	
	public Boolean retirarProduto(Integer id) {
		
		
		String sql = "select * from produtos where Id = '"+ id +"'";
		String sql2 = "delete from produtos where Id = '"+ id +"'";
		
		if(this.produtoModelo.retirarProduto(sql, sql2)== true)
		{
			System.out.println("Produto Retirado");
			return true;
		}
		else {
			System.out.println("Impossível retirar produto");
			return false;
		}
	
		
	}
	
	public Boolean alterarProduto(float valorCompra, float valorVenda, Integer disponibilidade, Integer id) {
		
		String sql = "select * from produtos where Id = '"+ id +"'";
		String sql2 = "update produtos set ValorCompra = '"+ valorCompra +"',ValorVenda = '"+ valorVenda +"',Disponibilidade= '"+ disponibilidade +"' where Id = '"+ id +"'";
		
		if(this.produtoModelo.alterarProduto(sql, sql2)== true)
		{
			System.out.println("Produto Alterado");
			return true;
		}
		else {
			System.out.println("Impossível alterar produto");
			return false;
		}
	
		
	}
	
	public boolean inserirProduto(Integer disponibilidade, Integer id) {
		
		String sql = "select * from produtos where Id = '"+ id +"'";
		
		if(this.produtoModelo.inserirProduto(sql, disponibilidade,id)== true)
		{
			System.out.println("Inserido com sucesso");
			return true;
		}
		else {
			System.out.println("Impossível inserir ");
			return false;
		}
	
		
	}
	

	
	public Boolean venderProduto(Integer disponibilidade, Integer id) {
		
		String sql = "select * from produtos where Id = '"+ id +"'";
		
		
		
		
		if(this.produtoModelo.venderProduto(sql,disponibilidade, id)== true)
		{
			System.out.println("Produto Vendido");
			return true;
		}
		else {
			System.out.println("Impossível vender produto");
			return false;
		}
		
	}

	
public boolean listarUsuario() {
		
		String sql = "select * from login";
		
		if(this.usuarioModelo.listarUsuario(sql)== true)
		{
			System.out.println("Listando Usuários");
			return true;
		}
		else {
			System.out.println("Impossível listar usuários");
			return false;
		}
		
			
	}

	
	public Boolean retirarUsuario(Integer id) {
		
		
		String sql = "select * from login where Id = '"+ id +"'";
		String sql2 = "delete from login where Id = '"+ id +"'";
		
		if(this.usuarioModelo.retirarUsuario(sql, sql2)== true)
		{
			System.out.println("Usuário Retirado");
			return true;
		}
		else {
			System.out.println("Impossível retirar usuário");
			return false;
		}
	
		
	}
	
	public Boolean alterarUsuario(String nome, String cpf, String senha, String funcao , Integer id) {
		
		String sql = "select * from login where Id = '"+ id +"'";
		String sql2 = "update login set Nome = '"+ nome +"',Cpf = '"+ cpf +"',Senha= '"+ senha +"',Funcao= '"+ funcao +"' where Id = '"+ id +"'";
		
		if(this.usuarioModelo.alterarUsuario(sql, sql2)== true)
		{
			System.out.println("Produto Alterado");
			return true;
		}
		else {
			System.out.println("Impossível alterar produto");
			return false;
		}
	
		
	}
}
