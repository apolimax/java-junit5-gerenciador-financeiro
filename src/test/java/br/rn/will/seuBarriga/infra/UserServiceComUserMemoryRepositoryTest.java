package br.rn.will.seuBarriga.infra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.rn.will.seuBarriga.domain.Usuario;
import br.rn.will.seuBarriga.domain.UsuarioBuilder;
import br.rn.will.seuBarriga.domain.exceptions.ValidationException;
import br.rn.will.seuBarriga.service.UsuarioService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceComUserMemoryRepositoryTest {
	private static UsuarioService service = new UsuarioService(new UsuarioMemoryRepository());
	
	@Test
	@Order(1)
	public void deveSalvarUsuarioValido() {
		Usuario usuario = service.salvar(UsuarioBuilder.novoUsuario().comId(null).agora());
		Assertions.assertNotNull(usuario.getId());
	}
	
	@Test
	@Order(2)
	public void deveRejeitarUsuarioExistente() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> 
			service.salvar(UsuarioBuilder.novoUsuario().comId(null).agora()));
		Assertions.assertEquals("Usuário email@gmail.com já cadastrado", ex.getMessage());
	}
}
