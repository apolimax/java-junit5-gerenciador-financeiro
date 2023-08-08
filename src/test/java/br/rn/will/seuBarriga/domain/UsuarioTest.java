package br.rn.will.seuBarriga.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UsuarioTest {
	
	@Test
	public void deveCriarUsuarioValido() {
		Usuario usuario = new Usuario(1L, "João", "j@gmail.com", "123");
		
		assertEquals(1L, usuario.getId());
	}

}
