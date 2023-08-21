package br.rn.will.seuBarriga.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.rn.will.seuBarriga.domain.Usuario;
import br.rn.will.seuBarriga.domain.UsuarioBuilder;
import br.rn.will.seuBarriga.service.repository.UsuarioRepository;

public class UsuarioServiceTest {
	private UsuarioService service;
	
	@Test
	public void deveRetornarEmptyQuandoUsuarioInexistente() {
		UsuarioRepository repository = Mockito.mock(UsuarioRepository.class);
		service = new UsuarioService(repository);
		
		// Treinamento. Nesse caso específico, desnecessário
		//Mockito.when(repository.findByEmail("mail@mail.com")).thenReturn(Optional.empty());
		
		Optional<Usuario> user= service.findByEmail("mail@mail.com");
		Assertions.assertTrue(user.isEmpty());
	}
	
	@Test
	public void deveRetornarUsuarioPorEmail() {
		UsuarioRepository repository = Mockito.mock(UsuarioRepository.class);
		service = new UsuarioService(repository);
		
		// Treinamento
		Mockito.when(repository.findByEmail("mail@mail.com")).thenReturn(Optional.of(UsuarioBuilder.novoUsuario().agora()));
		
		Optional<Usuario> user= service.findByEmail("mail@mail.com");
		// System.out.println(user);
		Assertions.assertTrue(user.isPresent());
		
		//Mockito.verify(repository).findByEmail("mail@mail.com"); // Verificar se o método mockado findByEmail foi chamado com o argumento "mail@mail.com"
		//Mockito.verify(repository, Mockito.times(1)).findByEmail("mail@mail.com"); // Verificar se foi chamada uma vez
	}
	
	@Test
	public void deveSalvarUsuarioComSucesso() {
		UsuarioRepository repository = Mockito.mock(UsuarioRepository.class);
		service = new UsuarioService(repository);
		
		Usuario userToSave = UsuarioBuilder.novoUsuario().comId(null).agora();
		
		Mockito.when(repository.salvar(userToSave)).thenReturn(UsuarioBuilder.novoUsuario().agora());
		
		Usuario savedUser = service.salvar(userToSave);
		Assertions.assertNotNull(savedUser.getId());
		
		Mockito.verify(repository).findByEmail(userToSave.getEmail());
	}
}
