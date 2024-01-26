package br.com.coyote.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.coyote.exeçao.explosaoExceptions;

public class CampoTest {
	private Campo campo;

	@BeforeEach
	void iniciaMetodo() {
		campo = new Campo(3, 3);
	}

	@Test
	void TestVizinho1() {
		Campo vizinho = new Campo(3, 2);
		boolean resultado = campo.AdicionarVizinho(vizinho);
		assertTrue(resultado);

	}
	@Test
	void Testnaovizinho() {
		Campo vizinho = new Campo(1, 1);
		boolean resultado = campo.AdicionarVizinho(vizinho);
		assertFalse(resultado);

	}

	@Test
	void TesteAtributoValorMarcado() {
		assertFalse(campo.ismarcado());
	}

	@Test
	void TesteAlternaMarcacao() {
		campo.AlternaMarcacao();
		assertTrue(campo.ismarcado());
	}

	@Test
	void TesteAlternaMarcacaoDuasChamada() {
		campo.AlternaMarcacao();
		campo.AlternaMarcacao();
		assertFalse(campo.ismarcado());
	}

	@Test
	void TesteAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}

	@Test
	void TesteAbrirNaoMinadoMarcado() {
		campo.AlternaMarcacao();
		assertFalse(campo.abrir());
	}
	@Test
	void TesteAbrirMinadoMarcado() {
		campo.AlternaMarcacao();
		campo.Minar();
		assertFalse(campo.abrir());
	}
	@Test
	void TesteAbrirMinadoNaoMarcado() {
		campo.Minar();
		
		assertThrows(explosaoExceptions.class, () -> {campo.abrir();});
	}
	@Test
	void TesteComVizinhos() {
		
		Campo vizinho1 = new Campo (2,2);
		
		Campo vizinhoDovizinho1 = new Campo (1,1);
		Campo vizinho12 = new Campo (1,1);
		vizinho12.Minar();
		vizinho1.AdicionarVizinho(vizinhoDovizinho1);
		campo.abrir();
		
		assertTrue(vizinhoDovizinho1.isAberto() && vizinho1.isfechado());
	}}
