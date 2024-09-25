package servico;

import static org.junit.Assert.assertEquals;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Produto;
import entidades.Usuario;
import servico.Servicos;

/**
 *
 * @author Thomas Krevey Derkascz
 */
public class ServicosTeste {

	
	private Servicos servico;

	@BeforeEach
	public void inicializarServicos() {

		this.servico = new Servicos();
	}

	@AfterEach
	public void destruirObjeto() {

		this.servico = null;
	}

	@Test
	public void realizarCadastroUsuarioVendedorErroTest() {
		Usuario usuario = new Usuario("User", "321", "a1b2", "Vendedor");
		boolean verificacao = this.servico.realizarCadastroUsuario(usuario);

		assertFalse(verificacao);
	}
	
		
	
	@Test
	public void realizarLoginVendedorTest() {

		String usuario = this.servico.realizarLogin("321", "321");

		
		assertEquals("Vendedor",usuario);
	}
	
	
	
	@Test
	public void realizarCadastroUsuarioRepositorTest() {

		Usuario usuario = new Usuario("joao111", "01234456798", "a1b2", "Repositor");
		boolean verificacao = this.servico.realizarCadastroUsuario(usuario);

		assertTrue(verificacao);
	}


	
	


	@Test
	public void realizarLoginRepositorTest() {

		String usuario = this.servico.realizarLogin("123", "123");

		assertEquals("Repositor",usuario);
	}

	





	@Test
	public void realizarCadastroProdutoTest() {

		Produto product = new Produto("Halls", "doce", 8, 10, 12);
		boolean verificacao = this.servico.realizarCadastroProduto(product);

		assertTrue(verificacao);
	}

	
	
	
	@Test
	public void retirarProdutoTest() {

		boolean verificacao = this.servico.retirarProduto(2);

		assertTrue(verificacao);

	}
	
	@Test
	public void listarProdutosTest() {

		boolean verificacao = this.servico.listarProdutos();

		assertTrue(verificacao);

	}

	@Test
	public void inserirProdutoTest() {

		boolean verificacao = this.servico.inserirProduto(20,5);

		assertTrue(verificacao);

	}
	
		
	@Test
	public void alterarProdutoTest() {

		boolean verificacao = this.servico.alterarProduto(11, 15, 10, 5);

		assertTrue(verificacao);
	}

	
	
	@Test
	public void venderProdutoTest() {

		boolean verificacao = this.servico.venderProduto(1,5);

		assertTrue(verificacao);
	}

	@Test
	public void venderProdutoErroTest() {

		boolean verificacao = this.servico.venderProduto(19,12);

		assertFalse(verificacao);
	}
	
	@Test
	public void inserirProdutoErroTest() {

		boolean verificacao = this.servico.inserirProduto(19,12);

		assertFalse(verificacao);
	}
	
	@Test
	public void alterarProdutoErroTest() {

		boolean verificacao = this.servico.alterarProduto(11, 15, 10, 18);

		assertFalse(verificacao);
	}
	
	
	@Test
	public void realizarCadastroUsuarioVendedorTest() {
		Usuario usuario = new Usuario("joao111", "01234456789", "a1b2", "Vendedor");
		boolean verificacao = this.servico.realizarCadastroUsuario(usuario);


		assertTrue(verificacao);
	}

	@Test
	public void realizarCadastroUsuarioRepositorErroTest() {
		Usuario usuario = new Usuario("joao111", "123", "a1b2", "Repositor");
		boolean verificacao = this.servico.realizarCadastroUsuario(usuario);


		assertNotNull(verificacao);
	}
	
	
	@Test
	public void realizarLoginErroTest() {
		String usuario = this.servico.realizarLogin("0123456789", "abc123");

		
		assertEquals("nulo",usuario);
	}
	
	@Test
	public void realizarCadastroProdutoErroTest() {

		Produto product = new Produto("Halls", "doce", 8, 10, 12);
		boolean verificacao = this.servico.realizarCadastroProduto(product);

		assertFalse(verificacao);
	}
	
	@Test
	public void retirarProdutoErroTest() {

		boolean verificacao = this.servico.retirarProduto(99);

		assertFalse(verificacao);

	}
}