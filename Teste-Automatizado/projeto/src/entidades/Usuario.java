package entidades;



public class Usuario {

	
	private String nome;
	private String cpf;
	private String senha;
	private String funcao;
	
	
	
	public Usuario(String nome, String cpf, String senha, String funcao) {		
   	
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.funcao = funcao;
		
	}



	public String getnome() {
		return nome;
	}



	public void setnome(String nome) {
		nome = nome;
	}



	public String getcpf() {
		return cpf;
	}



	public void setcpf(String cpf) {
		cpf = cpf;
	}



	public String getsenha() {
		return senha;
	}



	public void setsenha(String senha) {
		senha = senha;
	}



	public String getfuncao() {
		return funcao;
	}



	public void setfuncao(String funcao) {
		funcao = funcao;
	}
	}
