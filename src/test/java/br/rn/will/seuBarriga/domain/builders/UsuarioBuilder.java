package br.rn.will.seuBarriga.domain.builders;

import br.rn.will.seuBarriga.domain.Usuario;

public class UsuarioBuilder {
	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	private UsuarioBuilder() {}
	
	public static UsuarioBuilder novoUsuario() {
		UsuarioBuilder builder = new UsuarioBuilder();
		inicializarDados(builder);
		
		return builder;
	}

	private static void inicializarDados(UsuarioBuilder builder) {
		builder.id = 1L;
		builder.nome = "Usuario Valido";
		builder.email = "email@gmail.com";
		builder.senha = "123456";
	}
	
	public UsuarioBuilder comId(Long param) {
		id = param;
		return this;
	}
	
	public UsuarioBuilder comNome(String param) {
		nome = param;
		return this;
	}
	
	public UsuarioBuilder comEmail(String param) {
		email = param;
		return this;
	}
	
	public UsuarioBuilder comSenha(String param) {
		senha = param;
		return this;
	}
	
	public Usuario agora() {
		return new Usuario(id, nome, email, senha);
	}
}
