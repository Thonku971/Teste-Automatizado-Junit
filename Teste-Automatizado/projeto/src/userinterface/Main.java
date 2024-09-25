package userinterface;

import java.util.Scanner;

import entidades.Usuario;
import entidades.Produto;
import servico.Servicos;



public class Main{

	private Scanner input;
	private Servicos servicos;

	
	public Main() {
		
		this.input = new Scanner(System.in);
		this.servicos = new Servicos();
	}

/*
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
*/
	
	public String realizarLogin() {
		
		this.input.nextLine();
		
		String cpf ;
		String senha ;
		
		
		System.out.print("Informe o Cpf: ");
		cpf = input.nextLine();
		
		System.out.print("Informe a senha: ");
		senha = input.nextLine();
		
		String user = servicos.realizarLogin(cpf, senha);
		
		if((user.equals("Vendedor"))||(user.equals("Repositor"))||(user.equals("Gerente"))) {
			
			System.out.println("Login realizado com sucesso.");
			return user;
		
		} else {
			
			System.out.println("Não foi possível realizar Login.");
			return "nulo";
		}
	}

/*
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
*/
	
public void realizarCadastroUsuario() {
		this.input.nextLine();
		String nome ; 
		String cpf ;
		String senha ;			
		String funcao = null;
		Integer func = 0;
		System.out.println("Seu Nome");
		nome = input.nextLine();
		System.out.println("Sua Senha");
		senha = input.nextLine();
		System.out.println("Seu Cpf");
		cpf = input.nextLine();
		while((func != 1)&&(func != 2)&&(func != 3))
		{
			System.out.println("Sua Funcao");
			System.out.println("1 - Repositor");
			System.out.println("2 - Vendedor");
			System.out.println("3 - Gerente");
			func = input.nextInt();
			switch(func)
			{
				case 1:
					funcao = "Repositor";
					break;
				case 2:	
					funcao = "Vendedor";
					break;
				case 3:	
					funcao = "Gerente";
					break;
				default:
					System.out.println("Inválido");
					break;
			}
		}
		Usuario user = new Usuario(nome, cpf, senha, funcao);
		if(this.servicos.realizarCadastroUsuario(user)) {	
			System.out.println("Cadastro realizado com sucesso.");		
		} else {
			System.out.println("Não foi possível realizar o Cadastro.");
		}
	}

/*
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
*/

public void realizarCadastroProduto() {
	
	this.input.nextLine();
	String nome;
	String tipo;
	float valorCompra;
	float valorVenda;
	Integer disponibilidade = 0;
	
	
	
	System.out.println("Nome do Produto");
	nome = input.nextLine();
	System.out.println("Tipo do Produto");
	tipo = input.nextLine();
	System.out.println("Valor de Compra do Produto");
	valorCompra = input.nextFloat();
	System.out.println("Valor de Venda do Produto");
	valorVenda = input.nextFloat();
	System.out.println("Disponibilidade do Produto");
	disponibilidade = input.nextInt();
	
	Produto product = new Produto(nome, tipo, valorCompra, valorVenda, disponibilidade);
	

	
	if(this.servicos.realizarCadastroProduto(product)) {
		
		System.out.println("Cadastro realizado com sucesso.");
	
	} else {
		
		System.out.println("Não foi possível realizar o Cadastro.");
	}
}

/*
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
*/

public void retirarProduto() {
	
	this.input.nextLine();
	
	Integer id = 0;
	
	servicos.listarProdutos();
	
	System.out.println("Id do Produto");
	id = input.nextInt();
	

	
	Boolean retira = servicos.retirarProduto(id);
	
	if(retira != null) {
		
		System.out.println("Retirada realizada com sucesso.");
	
	} else {
		
		System.out.println("Não foi possível realizar a Retirada.");
	}
}

/*
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
*/

public void alterarProduto() {
	
	servicos.listarProdutos();

	this.input.nextLine();
	
	
	System.out.println("Valor de Compra do Produto");
	float valorCompra = input.nextFloat();
	System.out.println("Valor de Venda do Produto");
	float valorVenda = input.nextFloat();
	System.out.println("Disponibilidade do Produto");
	Integer disponibilidade = input.nextInt();
	System.out.println("Id do Produto");
	Integer id = input.nextInt();
	
		
		
	Boolean altera = servicos.alterarProduto(valorCompra, valorVenda, disponibilidade, id);
	
	if(altera != null) {
		
		System.out.println("Alteracao realizada com sucesso.");
	
	} else {
		
		System.out.println("Não foi possível realizar a Alteracao.");
	}
}

/*
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
*/

public void inserirProduto() {
	
	servicos.listarProdutos();

	this.input.nextLine();
	
	Integer disponibilidade = 0;
	Integer id;
	
	while(disponibilidade <= 0) {
		System.out.println("Número de Produtos a serem Adicionados");
		disponibilidade = input.nextInt();
	}
		System.out.println("Id do Produto");
		id = input.nextInt();
	
		Boolean insere = servicos.inserirProduto(disponibilidade, id);
		
	if(insere != null)
		System.out.println("Insercao realizada com sucesso.");
	else
		System.out.println("Não foi possível realizar a Insercao.");
}

/*
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
*/

public void venderProduto() {
	
	
	
	servicos.listarProdutos();

	this.input.nextLine();
	
	Integer disponibilidade = 0;
	Integer id;
	
	while(disponibilidade <= 0) {
		System.out.println("Número de Produtos Vendidos");
		disponibilidade = input.nextInt();
	}
		System.out.println("Id do Produto");
		id = input.nextInt();
	
		Boolean vende = servicos.venderProduto(disponibilidade, id);
		
	if(vende != null) {
		
		System.out.println("Retirada realizada com sucesso.");
	
	} else {
		
		System.out.println("Não foi possível realizar a Retirada.");
	}
}



/*
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
*/

public void retirarUsuario() {
	
	this.input.nextLine();
	
	Integer id = 0;
	
	servicos.listarUsuario();
	
	System.out.println("Id do Usuario");
	id = input.nextInt();
	

	
	Boolean retira = servicos.retirarUsuario(id);
	
	if(retira != null) {
		
		System.out.println("Retirada realizada com sucesso.");
	
	} else {
		
		System.out.println("Não foi possível realizar a Retirada.");
	}
}

/*
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
*/

public void alterarUsuario() {
	
	servicos.listarUsuario();

	this.input.nextLine();
	String funcao = null;
	Integer func = 0;
	
	
	System.out.println("Nome do usuário");
	String nome = input.nextLine();
	System.out.println("Cpf do usuário");
	String cpf = input.nextLine();
	System.out.println("Senha");
	String senha = input.nextLine();
	while((func != 1)&&(func != 2)&&(func != 3))
	{
		System.out.println("Sua Funcao");
		System.out.println("1 - Repositor");
		System.out.println("2 - Vendedor");
		System.out.println("3 - Gerente");
		func = input.nextInt();
		switch(func)
		{
			case 1:
				funcao = "Repositor";
				break;
			case 2:	
				funcao = "Vendedor";
				break;
			case 3:	
				funcao = "Gerente";
				break;
			default:
				System.out.println("Inválido");
				break;
		}
	}
	System.out.println("Id do usuário");
	Integer id = input.nextInt();
	
		
		
	Boolean altera = servicos.alterarUsuario(nome, cpf, senha, funcao, id);
	
	if(altera != null) {
		
		System.out.println("Alteracao realizada com sucesso.");
	
	} else {
		
		System.out.println("Não foi possível realizar a Alteracao.");
	}
}



/*
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
-------------------------------------------------------------------------
*/

	public static void main(String args[]) {		

		Main main = new Main();
		
		Integer opcao = 0;
		
		while(opcao != 2)
		{
			
			
			
			System.out.println("Qual opção deseja? ");
			System.out.println("1 - Login");
			System.out.println("2 - SAIR");
			opcao = main.input.nextInt();
			
			
			switch(opcao){
				
			case 1:
				
				String ae = main.realizarLogin();
				
				if(ae.equals("Repositor"))
				{
					System.out.println("Função : Repositor");
					
					while(opcao != 5)
					{	

						System.out.println("Qual opção deseja? ");
						System.out.println("1 - Cadastro de Produto");
						System.out.println("2 - Retirada de Produto");
						System.out.println("3 - Alteração de Produto");
						System.out.println("4 - Inserção de Produto");
						System.out.println("5 - SAIR");
						opcao = main.input.nextInt();
						
						
						switch(opcao){
							
						case 1:
							System.out.println("Cadastro de Produto");
							main.realizarCadastroProduto();
							
							break;
						case 2:
							System.out.println("Retirar Produto");
							main.retirarProduto();
						
							break;
						case 3:
							System.out.println("Alterar Produto");
							main.alterarProduto();
						
							break;
							
						case 4:
							System.out.println("Inserir Produto");
							main.inserirProduto();
							break;
							
						case 5:
							System.out.println("Voltando ao menu inicial");
							break;
							
						default:	
							System.out.println("Inválido");
							break;
				
						}
					}	
				}	
				if(ae.equals("Vendedor"))
				{
					System.out.println("Função : Vendedor");
					
					while(opcao != 2)
					{	
						
						System.out.println("Qual opção deseja? ");
						System.out.println("1 - Vender Produto");
						System.out.println("2 - SAIR");
						opcao = main.input.nextInt();
						
						
						switch(opcao){
							
						case 1:
							System.out.println("Vender Produto");
							main.venderProduto();
							break;
						case 2:
							System.out.println("Voltando ao menu inicial");
							break;
						default:	
							System.out.println("Inválido");
							break;
				
						}
					}
				}
				
				if(ae.equals("Gerente"))
				{
					System.out.println("Função : Gerente");
					
					while(opcao != 4)
					{	
						
						System.out.println("Qual opção deseja? ");
						System.out.println("1 - Cadastrar novo usuário");
						System.out.println("2 - Alterar usuário");
						System.out.println("3 - Retirar usuário");
						System.out.println("4 - Sair");
						opcao = main.input.nextInt();
						
						
						switch(opcao){
							
						case 1:
							System.out.println("Cadastrar Usuário");
							main.realizarCadastroUsuario();
							break;
							
						case 2:
							System.out.println("Alterar Usuário");
							main.alterarUsuario();
							break;
							
						case 3:
							System.out.println("Retirar Usuário");
							main.retirarUsuario();
							break;
							
						case 4:
							System.out.println("Voltando ao menu inicial");
							break;
							
						default:	
							System.out.println("Inválido");
							break;
				
						}
					}
				}
				
				break;
			

			case 2:

				System.out.print("Obrigado por Utilizar! ");
				System.exit(0);
				break;
				
			default:	
				System.out.print("Inválido ");
				break;
			}
			
			
		}
		
		
	}
	
}