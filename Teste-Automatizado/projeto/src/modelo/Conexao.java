package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Connection conectar() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/barr","root","");
		System.out.println("conectou ao banco");
		return con;
		}
		catch(Exception e){ System.out.println(e);}
		return null;
	}
	
	
	
	public void desconectar(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("desconectou ao banco");
	}
}
