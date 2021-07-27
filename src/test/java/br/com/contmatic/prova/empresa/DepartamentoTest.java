package br.com.contmatic.prova.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	    System.out.println(departamento);
	    assertTrue(Validacao.Valida(departamento));
	}

	@Test
	public void nao_deve_aceitar_atributo_nome_vazio() {
		departamento.setNome("");
		assertFalse(Validacao.Valida(departamento));
	}

	@Test
	public void nao_deve_aceitar_atributo_nome_com_apenas_um_caracter_alfabetico_maiusculo() {
		departamento = Fixture.from(Departamento.class).gimme("atributo nome com apenas um caracter alfabetico maiusculo");
		assertFalse(Validacao.Valida(departamento));
	}

	@Test
    public void nao_deve_aceitar_atributo_nome_com_apenas_um_caracter_alfabetico_minusculo() {
        departamento = Fixture.from(Departamento.class).gimme("atributo nome com apenas um caracter alfabetico minusculo");
        assertFalse(Validacao.Valida(departamento));
    }

	@Test
    public void nao_deve_aceitar_atributo_nome_com_apenas_um_caracter_numerico() {
        departamento = Fixture.from(Departamento.class).gimme("atributo nome com apenas um caracter numerico");
        assertFalse(Validacao.Valida(departamento));
    }
	
	@Test
    public void nao_deve_aceitar_atributo_nome_com_apenas_caracteres_numericos() {
        departamento = Fixture.from(Departamento.class).gimme("atributo nome com caracteres numericos");
        assertFalse(Validacao.Valida(departamento));
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
