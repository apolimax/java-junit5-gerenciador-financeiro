package br.rn.will.seuBarriga.domain;

public class ContaBuilder {
	private Long id;
	private String nome;
	private Usuario usuario;
	
	private ContaBuilder() {}
	
	public static ContaBuilder novaConta() {
		ContaBuilder builder = new ContaBuilder();
		inicializarDados(builder);
		return builder;
	}

	private static void inicializarDados(ContaBuilder builder) {
		builder.id = 1L;
		builder.nome = "Conta Valida";
		builder.usuario = UsuarioBuilder.novoUsuario().agora();
	}
	
	public ContaBuilder comId(Long param) {
		id = param;
		return this;
	}
	
	public ContaBuilder comNome(String param) {
		nome = param;
		return this;
	}
	
	public ContaBuilder comUsuario(Usuario param) {
		usuario = param;
		return this;
	}
	
	public Conta agora() {
		return new Conta(id, nome, usuario);
	}
}
