package br.rn.will.seuBarriga.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import br.rn.will.seuBarriga.domain.exceptions.ValidationException;

@DisplayName("Domínio: Usuário")
public class UsuarioTest {
	
	@Test
	@DisplayName("Deve criar um usuário válido")
	public void deveCriarUsuarioValido() {
		Usuario usuario = UsuarioBuilder.novoUsuario().agora();
		
		Assertions.assertAll("Usuario", 
				() -> assertEquals(1L, usuario.getId()),
				() -> assertEquals("Usuario Valido", usuario.getNome()),
				() -> assertEquals("email@gmail.com", usuario.getEmail()),
				() -> assertEquals("123456", usuario.getSenha())
		);
	}
	
	@Test
	@DisplayName("Deve rejeitar um usuário sem nome")
	public void deveRejeitarUsuarioSemNome() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {
				UsuarioBuilder.novoUsuario().comNome(null).agora();
		});
		assertEquals("Nome é obrigatório", ex.getMessage());
	}
	
	@Test
	@DisplayName("Deve rejeitar um usuário sem email")
	public void deveRejeitarUsuarioSemEmail() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {
				UsuarioBuilder.novoUsuario().comEmail(null).agora();
		});
		assertEquals("E-mail é obrigatório", ex.getMessage());
	}
	
	@Test
	@DisplayName("Deve rejeitar um usuário sem senha")
	public void deveRejeitarUsuarioSemSenha() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {
				UsuarioBuilder.novoUsuario().comSenha(null).agora();
		});
		assertEquals("Senha é obrigatória", ex.getMessage());
	}
	
	// Teste parametrizado. Substitui os três testes acima
	@ParameterizedTest(name = "[{index}] - {4}")
	@CsvSource(value = {
			"1, NULL, email@gmail.com, 132456, Nome é obrigatório",
			"1, Usuario Valido, NULL, 132456, E-mail é obrigatório",
			"1, Usuario Valido, email@gmail.com, NULL, Senha é obrigatória"
	}, nullValues = "NULL")
	public void deveValidarCamposObrigatorios(Long id, String nome, String email, String senha, String msg) {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {
			UsuarioBuilder.novoUsuario().comId(id).comNome(nome).comEmail(email).comSenha(senha).agora();
		});
		assertEquals(msg, ex.getMessage());
	}
}
