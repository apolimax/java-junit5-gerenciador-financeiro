package br.rn.will.seuBarriga.service.repository;

import java.util.Optional;

import br.rn.will.seuBarriga.domain.Usuario;

public interface UsuarioRepository {
	Usuario salvar(Usuario usuario);
	
	Optional<Usuario> findByEmail(String email);
}
