package br.rn.will.seuBarriga.infra;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.rn.will.seuBarriga.domain.Usuario;
import br.rn.will.seuBarriga.service.repository.UsuarioRepository;

public class UsuarioMemoryRepository implements UsuarioRepository {
	private List<Usuario> usuarios;
	private Long currentId;
	
	public UsuarioMemoryRepository() {
		this.usuarios = new ArrayList<>();
		this.currentId = 0L;
		salvar(new Usuario(null, "User #1", "user1@mail.com", "123456"));
	}

	@Override
	public Usuario salvar(Usuario usuario) {
		Usuario newUsuario = new Usuario(nextId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
		usuarios.add(newUsuario);
		return newUsuario;
	}

	@Override
	public Optional<Usuario> findByEmail(String email) {
		return usuarios.stream().filter((user) -> user.getEmail().equalsIgnoreCase(email))
								.findFirst();
	}

	private Long nextId() {
		return ++currentId;
	}
	
	public static void main(String[] args) {
		UsuarioMemoryRepository repo = new UsuarioMemoryRepository();
	}
}
