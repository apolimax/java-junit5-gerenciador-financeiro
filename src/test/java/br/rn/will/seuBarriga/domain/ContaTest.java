package br.rn.will.seuBarriga.domain;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import br.rn.will.seuBarriga.domain.exceptions.ValidationException;

@DisplayName("Domínio: Conta")
public class ContaTest {
	@Test
	@DisplayName("Deve criar uma conta válida")
	public void deveCriarContaValida() {
		Conta conta = ContaBuilder.novaConta().agora();
		Assertions.assertAll("Conta", 
				() -> Assertions.assertEquals(1L, conta.getId()),
				() -> Assertions.assertEquals("Conta Valida", conta.getNome()),
				() -> Assertions.assertEquals(UsuarioBuilder.novoUsuario().agora(), conta.getUsuario())
		);
	}
	
	@ParameterizedTest
	@MethodSource(value = "dataProvider")
	public void deveRejeitarContaInvalida(Long id, String nome, Usuario usuario, String mensagem) {
		String errorMessage = Assertions.assertThrows(ValidationException.class, () -> {
			ContaBuilder.novaConta().comId(id).comNome(nome).comUsuario(usuario).agora();
		}).getMessage();
		
		Assertions.assertEquals(mensagem, errorMessage);
	}
	
	private static Stream<Arguments> dataProvider() {
		return Stream.of(
					Arguments.of(1L, null, UsuarioBuilder.novoUsuario().agora(), "Nome é obrigatório"),
					Arguments.of(1L, "Conta Valida", null, "Usuário é obrigatório")
				);
	}
}
