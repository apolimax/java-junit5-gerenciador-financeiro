package br.rn.will.seuBarriga.service;

import java.util.Optional;

import br.rn.will.seuBarriga.domain.Usuario;
import br.rn.will.seuBarriga.domain.exceptions.ValidationException;
import br.rn.will.seuBarriga.service.repository.UsuarioRepository;

public class UsuarioService {
	private UsuarioRepository repository;

	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	public Usuario salvar(Usuario usuario) {
		repository.findByEmail(usuario.getEmail()).ifPresent(user -> {
			throw new ValidationException(String.format("Usuário % já cadastrado", user.getEmail()));
		});
			
		
		return repository.salvar(usuario);
	}
	
	public Optional<Usuario> findByEmail(String email) {
		return repository.findByEmail(email);
	}
}
