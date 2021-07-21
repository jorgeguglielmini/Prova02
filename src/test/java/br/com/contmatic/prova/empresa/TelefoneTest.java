package br.com.contmatic.prova.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.prova.empresa.enums.DDD;
import br.com.contmatic.prova.empresa.gerador.Gerador;
import br.com.contmatic.prova.empresa.templates.TelefoneFixtureFactoryTemplate;
import br.com.contmatic.prova.testutils.Validacao;
import br.com.six2six.fixturefactory.Fixture;

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

	@Test(expected = IllegalArgumentException.class)
	public void step_06_nao_deve_aceitar_atributo_numero_com_letras() {
		telefone.setNumero(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(8, 9)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void step_07_nao_deve_aceitar_atributo_ddd_com_letras() {
		telefone.setDdd(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(2, 2)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void step_08_nao_deve_aceitar_atributo_numero_com_letras_e_numeros() {
		Integer numero = Gerador.geraNumeroAleatorio(3, 3);
		telefone.setNumero(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(5, 6)) + numero.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void step_09_nao_deve_aceitar_atributo_ddd_com_letras_e_numeros() {
		Integer ddd = Gerador.geraNumeroAleatorio(1, 1);
		telefone.setDdd(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 1)) + ddd.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void step_10_nao_deve_aceitar_atributo_numero_nulo() {
		telefone.setNumero(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void step_11_nao_deve_aceitar_atributo_ddd_nulo() {
		telefone.setDdd(null);
	}

	@Test
	public void step_12_deve_aceitar_atributo_numero_com_nove_digitos() {
		Integer numero1 = Gerador.geraNumeroAleatorio(1000, 9999);
		Integer numero2 = Gerador.geraNumeroAleatorio(10000, 99999);

		telefone.setNumero(numero1.toString() + numero2.toString());
		assertEquals(numero1.toString() + numero2.toString(), telefone.getNumero());
	}

	@Test
	public void step_13_deve_aceitar_dois_digitos_no_atributo_ddd() {
		String ddd = Telefone.DDD[Gerador.geraNumeroAleatorio(0, Telefone.DDD.length - 1)];
		telefone.setDdd(ddd);
		assertEquals(ddd.toString(), telefone.getDdd());

	}

	@Test
	public void step_14_deve_aceitar_atributo_numero_com_oito_digitos() {
		Integer numero1 = Gerador.geraNumeroAleatorio(1000, 9999);
		Integer numero2 = Gerador.geraNumeroAleatorio(1000, 9999);
		telefone.setNumero(numero1.toString() + numero2.toString());
		assertEquals(numero1.toString() + numero2.toString(), telefone.getNumero());

	}

	@Test(expected = IllegalArgumentException.class)
	public void step_15_nao_deve_aceitar_atributo_numero_menor_de_oito_digitos() {
		long numero = Gerador.geraNumeroAleatorio(0, 9999999);
		telefone.setNumero(Long.toString(numero));
		assertEquals(Long.toString(numero), telefone.getNumero());

	}

	@Test(expected = IllegalArgumentException.class)
	public void step_16_nao_deve_aceitar_atributo_numero_maior_de_nove_digitos() {
		Integer numero1 = Gerador.geraNumeroAleatorio(10000, 999999);
		Integer numero2 = Gerador.geraNumeroAleatorio(10000, 999999);
		telefone.setNumero(numero1.toString() + numero2.toString());

	}

	@Test(expected = IllegalArgumentException.class)
	public void step_17_nao_deve_aceitar_atributo_ddd_com_quantidade_menor_de_dois_digitos() {
		Integer ddd = Gerador.geraNumeroAleatorio(1, 1);
		telefone.setDdd(ddd.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void step_49_nao_deve_aceitar_atributo_ddd_com_quantidade_maior_de_dois_digitos() {
		Integer ddd = Gerador.geraNumeroAleatorio(3, 10);
		telefone.setDdd(ddd.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void step_50_nao_deve_aceitar_atributo_ddd_com_dois_digitos_mas_que_nao_esteja_na_lista() {
		telefone.setDdd("20");
	}

	@Test(expected = IllegalArgumentException.class)
	public void step_18_nao_deve_receber_atributo_numero_vazio() {
		telefone.setNumero("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void step_19_nao_deve_receber_atributo_ddd_vazio() {
		telefone.setDdd("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void step_20_nao_deve_receber_atributo_numero_com_espacos_em_branco() {
		telefone.setNumero("                 ");
	}

	@Test(expected = IllegalArgumentException.class)
    public void step_21_nao_deve_aceitar_espacos_em_branco_no_inicio_do_atributo_numero_dado_8_numeros() {
	    long numero1 = Gerador.geraNumeroAleatorio(1000, 9999);
        long numero2 = Gerador.geraNumeroAleatorio(1000, 9999);
        telefone.setNumero(" " + Long.toString(numero1 + numero2));
    }


	@Test(expected = IllegalArgumentException.class)
	public void step_22_nao_deve_aceitar_espacos_em_branco_no_final_do_atributo_numero_dado_8_numeros() {
	    long numero1 = Gerador.geraNumeroAleatorio(1000, 9999);
	    long numero2 = Gerador.geraNumeroAleatorio(1000, 9999);
        telefone.setNumero(Long.toString(numero1 + numero2) + " ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void step_48_nao_deve_aceitar_espacos_em_branco_no_inicio_do_atributo_numero_dado_9_numeros() {
	    long numero1 = Gerador.geraNumeroAleatorio(10000, 99999);
        long numero2 = Gerador.geraNumeroAleatorio(1000, 9999);		
        telefone.setNumero(" " + Long.toString(numero1 + numero2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void step_23_nao_deve_aceitar_espacos_em_branco_no_final_do_atributo_numero_dado_9_numeros() {
	    long numero1 = Gerador.geraNumeroAleatorio(10000, 99999);
		long numero2 = Gerador.geraNumeroAleatorio(1000, 9999);
		telefone.setNumero(Long.toString(numero1 + numero2) + " ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void step_47_nao_deve_aceitar_ddd_nao_valido() {
		String ddd = "11";
		boolean temNaLista = true;

		while (temNaLista) {
			ddd = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(2, 2));
			for (int i = 0; i < Telefone.DDD.length; i++) {

				if (ddd.equals(Telefone.DDD[i])) {
					temNaLista = true;
					break;
				}
				if (i == Telefone.DDD.length - 1) {
					temNaLista = false;
				}
			}
		}
		telefone.setDdd(ddd);
	}


//teste hashcode equals e tostring

}
