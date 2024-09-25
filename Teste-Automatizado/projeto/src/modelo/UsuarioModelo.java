package modelo;

import entidades.Produto;
import entidades.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class UsuarioModelo {

	private Conexao conexao;
	
	public UsuarioModelo() {

		this.conexao = new Conexao();
	}
	
	
public String realizarLogin(String sql) {
	Integer ao = 0;
	try {
		Connection con = this.conexao.conectar();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		String resultado="";
		System.out.println("sql   " + sql);
		while(rs.next()) {  
			ao = 1;  
			resultado = rs.getString("Funcao");
		}
			if(ao == 0)
			{
			resultado = "nulo";
				System.out.println("Nenhum usuário encontrado");
			
			}
			this.conexao.desconectar(con);
			return resultado;
	}catch(Exception e){ System.out.println(e);
		return null;
	}
}

	
	public Boolean realizarCadastroUsuario(String sql, String sql2) {
		Integer ao = 0;
		try{  
			Connection con=this.conexao.conectar();  
			Statement stmt=con.createStatement();  
			ResultSet rs = stmt.executeQuery(sql) ; 
			while(rs.next())  
			{
				ao = ao++;  

			} 
		
			if(ao == 0)
			{
				stmt.executeUpdate(sql2); 
			
				
			}
			else
			{
				System.out.println("Cpf já cadastrado");
				return false;
				
			}
			this.conexao.desconectar(con);
			return true;
		}catch(Exception e){ System.out.println(e);
		return false;}
		
	}

	
	public boolean listarUsuario(String sql) {
		try {
			Connection con = this.conexao.conectar();
			
			Statement stmt=con.createStatement();  
			ResultSet rs = stmt.executeQuery(sql) ; 
			while(rs.next())  
				System.out.println("\n Nome : " + rs.getString(1) + "\n Cpf : " + rs.getString(2)+ "\n Senha : " + rs.getString(3)+ "\n Funcao : " + rs.getString(4)+ "\n Id : " + rs.getInt(5) + "\n");
				
			this.conexao.desconectar(con);	
			return true;
			}catch(Exception e){ System.out.println(e);
			return false;}  
		

	}
	
	
	
	public Boolean retirarUsuario(String sql, String sql2) {
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
				System.out.println("Nenhum Usuario com este Id");
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
	
	public Boolean alterarUsuario(String sql, String sql2) {
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
				System.out.println("Nenhum usuario com este Id");
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
	
}
