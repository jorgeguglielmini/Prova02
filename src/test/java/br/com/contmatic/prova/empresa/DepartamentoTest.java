package br.com.contmatic.prova.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.prova.empresa.gerador.Gerador;
import br.com.contmatic.prova.empresa.templates.DepartamentoFixtureFactoryTemplate;
import br.com.contmatic.prova.testutils.Validacao;
import br.com.six2six.fixturefactory.Fixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class DepartamentoTest {

	private Departamento departamento;

	@BeforeClass
	public static void setup() {
	    new DepartamentoFixtureFactoryTemplate().load();
	}
	
	@Before
	public void iniciar() {
		departamento = Fixture.from(Departamento.class).gimme("valido");
	}

	@Test
	public void nao_deve_aceitar_atributo_nome_nulo() {
		departamento.setNome(null);
		assertFalse(Validacao.Valida(departamento));
	}

	@Test
	public void deve_aceitar_atributo_nome_valido() {
	    assertTrue(Validacao.Valida(departamento));
	}

	@Test
	public void nao_deve_aceitar_atributo_nome_vazio() {
		departamento.setNome("");
		assertFalse(Validacao.Valida(departamento));
	}

	@Test
	public void deve_aceitar_no_atributo_nome_uma_quantidade_de_caracteres_que_esteja_entre_1_e_199() {
		int nome = Gerador.geraNumeroAleatorio(1, 199);
		departamento.setNome(Gerador.geraStringAleatoria(nome));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_quantidade_de_caracteres_maior_que_200_no_atributo_nome() {
		departamento.setNome(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(200, 1000)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_nome_com_caracteres_especiais() {
		departamento.setNome(Gerador.geraStringEspecialAleatoria(Gerador.geraNumeroAleatorio(1,10)));
	}

	@Test
	public void equals_verifier() {
	    EqualsVerifier.forClass(Departamento.class).suppress(Warning.NONFINAL_FIELDS).verify();
	}
	
	@Test
	public void teste_toString() {
	    Departamento departamento1 = new Departamento("Tecnologia");
	    assertEquals("{\"nome\":\"Tecnologia\"}",departamento1.toString());
	}
	
}
