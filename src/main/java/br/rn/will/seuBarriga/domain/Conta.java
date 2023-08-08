package br.rn.will.seuBarriga.domain;

public class Conta {
	private Long id;
	private String nome;
	private Usuario usuario;
	
	public Conta(Long id, String nome, Usuario usuario) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}
}
