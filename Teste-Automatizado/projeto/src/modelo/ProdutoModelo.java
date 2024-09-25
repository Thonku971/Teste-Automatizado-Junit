package modelo;

import entidades.Produto;
import entidades.Usuario;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;



public class ProdutoModelo {

	private Conexao conexao;
	
	public ProdutoModelo() {

		this.conexao = new Conexao();
	}

	
	public Boolean realizarCadastroProduto(String sql, String sql2) {
		
		Integer ao = 0;
		try {
			Connection con = this.conexao.conectar();
			
			Statement stmt=con.createStatement();  
			ResultSet rs = stmt.executeQuery(sql); 
			while(rs.next())  
			{
				ao = ao++;  
			} 
		
			if(ao == 0)
			{
				stmt.executeUpdate(sql2) ; 				
			}
			else
			{
				System.out.println("Este Produto já existe"); 
				return false;
			}
			this.conexao.desconectar(con);
		return true;	
		}catch(Exception e){ System.out.println(e);
			return false;
		}
			
	}
	
	public boolean listarProdutos(String sql) {
		try {
			Connection con = this.conexao.conectar();
			
			Statement stmt=con.createStatement();  
			ResultSet rs = stmt.executeQuery(sql) ; 
			while(rs.next())  
				System.out.println("\n Nome : " + rs.getString(1) + "\n Tpo : " + rs.getString(2)+ "\n ValorCompra : " + rs.getFloat(3)+ "\n ValorVenda : " + rs.getFloat(4)+ "\n Disponibilidade : " + rs.getInt(5) + "\n Id : " + rs.getInt(6) + "\n");
				
			this.conexao.desconectar(con);	
			return true;
			}catch(Exception e){ System.out.println(e);
			return false;}  
		

	}
	
	
	public Boolean retirarProduto(String sql, String sql2) {
		Integer ao = 0;
		try {
			Connection con = this.conexao.conectar();
		
			Statement stmt=con.createStatement();  
			ResultSet rs = stmt.executeQuery(sql) ; 
			while(rs.next())  
			{
				ao = 1;  
			} 
		
			if(ao == 0)
			{
				System.out.println("Nenhum produto com este Id");
				return false;
			}
			else
			{
				stmt.executeUpdate(sql2);
				
			}
					
			this.conexao.desconectar(con);
			
			return true;
			
		}catch(Exception e){ System.out.println(e);
		return false;}
		
		}
	
	public Boolean alterarProduto(String sql, String sql2) {
		Integer ao = 0;
		try {
			Connection con = this.conexao.conectar();
			
			Statement stmt=con.createStatement();  
			ResultSet rs = stmt.executeQuery(sql) ; 
			while(rs.next())  
			{
				ao = 1;  
			} 
		
			if(ao == 0)
			{
				System.out.println("Nenhum produto com este Id");
				return false;
			}
			else
			{
				stmt.executeUpdate(sql2) ;
				
			}
			this.conexao.desconectar(con);
			
			return true;
			
		}catch(Exception e){ System.out.println(e);
		return false;}
				
	}
	
	public boolean inserirProduto(String sql,Integer disponibilidade, Integer id) {
		Integer tem = 0;
		Integer ao = 0;
		try {
			
			Connection con = this.conexao.conectar();
			
			Statement stmt=con.createStatement();  
			ResultSet rs = stmt.executeQuery(sql) ;
				
				while(rs.next()) {  
				ao = 1;	
				tem = rs.getInt("Disponibilidade");
				}
				if(tem >= 1 && ao == 1)
				{
					disponibilidade = tem + disponibilidade;
				
					stmt.executeUpdate("update produtos set Disponibilidade = '"+ disponibilidade +"' where Id = '"+ id +"'") ;
				}
				else
				{
					System.out.println("Impossível");
					return false;
				}
			
			this.conexao.desconectar(con);
			return true;
		}catch(Exception e){ System.out.println(e);
		return false;}
			
		
	}
	
	public Boolean venderProduto(String sql,Integer disponibilidade, Integer id) {
		Integer tem = 0;
		Integer ao = 0;
		try {
			
			Connection con = this.conexao.conectar();
			
			Statement stmt=con.createStatement();  
			ResultSet rs = stmt.executeQuery(sql) ;
				
				while(rs.next()) {  
				ao = 1;	
				tem = rs.getInt("Disponibilidade");
				}
				if(tem >= disponibilidade && ao == 1)
				{
					disponibilidade = tem - disponibilidade;
				
					stmt.executeUpdate("update produtos set Disponibilidade = '"+ disponibilidade +"' where Id = '"+ id +"'") ;
				}
				else
				{
					System.out.println("Impossível");
					return false;
				}
			
			this.conexao.desconectar(con);
			return true;
		}catch(Exception e){ System.out.println(e);
		return false;}
			
			
			
		
		
	}

}
