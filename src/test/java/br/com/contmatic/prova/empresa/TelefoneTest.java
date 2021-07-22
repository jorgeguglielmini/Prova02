package br.com.contmatic.prova.empresa;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.prova.empresa.enums.DDD;
import br.com.contmatic.prova.empresa.templates.TelefoneFixtureFactoryTemplate;
import br.com.contmatic.prova.testutils.Validacao;
import br.com.six2six.fixturefactory.Fixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TelefoneTest {

	private Telefone telefone;

	@BeforeClass
	public static void setup() {
	    new TelefoneFixtureFactoryTemplate().load();
	}
	
	@Before
	public void iniciar() {
		telefone = Fixture.from(Telefone.class).gimme("valido");
	}

	@Ignore
	@Test
	public void step_01_teste_para_ser_ignorado() {
		System.out.println("eu sei que essa mensagem não vai ser printada");
	}

	@Test(timeout = 1000)
	public void step_02_teste_timeout() {
		for (int i = 0; i < 10; i++) {
			new Telefone(DDD.DDD_11, "123456789");
		}
	}

	@Test
	public void step_05_deve_aceitar_atributo_ddd_valido() {
	    assertTrue(Validacao.Valida(telefone));
	}

	@Test
	public void step_06_nao_deve_aceitar_atributo_numero_com_letras() {
	}

	@Test
	public void step_08_nao_deve_aceitar_atributo_numero_com_letras_e_numeros() {
		
	}

	

	@Test
	public void step_10_nao_deve_aceitar_atributo_numero_nulo() {
		
	}

	@Test
	public void step_11_nao_deve_aceitar_atributo_ddd_nulo() {
		
	}

	@Test
	public void step_12_deve_aceitar_atributo_numero_com_nove_digitos() {
	}

	

	@Test
	public void step_14_deve_aceitar_atributo_numero_com_oito_digitos() {


	}

	@Test
	public void step_15_nao_deve_aceitar_atributo_numero_menor_de_oito_digitos() {
	}

	@Test
	public void step_16_nao_deve_aceitar_atributo_numero_maior_de_nove_digitos() {
	}

	
	

	@Test
	public void step_18_nao_deve_receber_atributo_numero_vazio() {
	
	}

	

	@Test
	public void step_20_nao_deve_receber_atributo_numero_com_espacos_em_branco() {
		telefone.setNumero("                 ");
	}

	@Test
    public void step_21_nao_deve_aceitar_espacos_em_branco_no_inicio_do_atributo_numero_dado_8_numeros() {
	   
    }


	@Test
	public void step_22_nao_deve_aceitar_espacos_em_branco_no_final_do_atributo_numero_dado_8_numeros() {
	   
	}

	@Test
	public void step_48_nao_deve_aceitar_espacos_em_branco_no_inicio_do_atributo_numero_dado_9_numeros() {
	    
	}

	@Test
	public void step_23_nao_deve_aceitar_espacos_em_branco_no_final_do_atributo_numero_dado_9_numeros() {
	    
	}

	@Test
	public void equals_verifier() {
	    EqualsVerifier.forClass(Telefone.class).suppress(Warning.NONFINAL_FIELDS).verify();
	}


//teste hashcode equals e tostring

}
