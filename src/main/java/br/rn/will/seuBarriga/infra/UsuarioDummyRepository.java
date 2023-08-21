package br.rn.will.seuBarriga.infra;

import java.util.Optional;

import br.rn.will.seuBarriga.domain.Usuario;
import br.rn.will.seuBarriga.domain.UsuarioBuilder;
import br.rn.will.seuBarriga.service.repository.UsuarioRepository;

public class UsuarioDummyRepository implements UsuarioRepository {

	@Override
	public Usuario salvar(Usuario usuario) {
		return UsuarioBuilder.novoUsuario()
				.comNome(usuario.getNome())
				.comEmail(usuario.getEmail())
				.comSenha(usuario.getSenha())
				.agora();
	}

	@Override
	public Optional<Usuario> findByEmail(String email) {
		if ("user@mail.com".equals(email)) {
			return Optional.of(UsuarioBuilder.novoUsuario().comEmail(email).agora());
		}
		return Optional.empty();
	}

}
