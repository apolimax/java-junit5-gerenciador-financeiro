package br.rn.will.seuBarriga.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.rn.will.seuBarriga.domain.builders.ContaBuilder;
import br.rn.will.seuBarriga.domain.builders.UsuarioBuilder;

public class ContaTest {
	@Test
	public void deveCriarContaValida() {
		Conta conta = ContaBuilder.novaConta().agora();
		Assertions.assertAll("Conta", 
				() -> Assertions.assertEquals(1L, conta.getId()),
				() -> Assertions.assertEquals("Conta Valida", conta.getNome()),
				() -> Assertions.assertEquals(UsuarioBuilder.novoUsuario().agora(), conta.getUsuario())
		);
	}
}
