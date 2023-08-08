package br.rn.will.seuBarriga.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Domínio: Usuário")
public class UsuarioTest {
	
	@Test
	@DisplayName("Deve criar um usuário válido")
	public void deveCriarUsuarioValido() {
		Usuario usuario = new Usuario(1L, "João", "j@gmail.com", "123");
		
		Assertions.assertAll("Usuario", 
				() -> assertEquals(1L, usuario.getId()),
				() -> assertEquals("João", usuario.getNome()),
				() -> assertEquals("j@gmail.com", usuario.getEmail()),
				() -> assertEquals("123", usuario.getSenha())
				
		);
	}
}
