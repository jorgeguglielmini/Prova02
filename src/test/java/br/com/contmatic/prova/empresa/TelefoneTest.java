package br.com.contmatic.prova.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.prova.empresa.gerador.Gerador;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TelefoneTest {

	private Telefone telefone;

	@Before
	public void iniciar() {
		telefone = new Telefone("11", "123456789");
	}

	@Ignore
	@Test
	public void step_01_teste_para_ser_ignorado() {
		System.out.println("eu sei que essa mensagem não vai ser printada");
	}

	@Test(timeout = 1000)
	public void step_02_teste_timeout() {
		for (int i = 0; i < 10; i++) {
			new Telefone("11", "123456789");
		}
	}

	@Test
	public void step_03_deve_gerar_uma_string_aleatoria_com_a_quantidade_de_caracteres_dados() {
		System.out.println(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(2, 5)));
	}

	@Test
	public void step_04_deve_exibir_um_numero_aleatorio_entre_o_intervalo_fornecido() {
		System.out.println(Gerador.geraNumeroAleatorio(0, 100));
	}

	@Test
	public void step_05_deve_aceitar_atributo_ddd_valido() {
		telefone.setDdd(Telefone.DDD[Gerador.geraNumeroAleatorio(0, Telefone.DDD.length - 1)]);
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
	public void step_24_nao_deve_aceitar_espacos_em_branco_no_final_do_atributo_ddd() {
		String ddd = Telefone.DDD[Gerador.geraNumeroAleatorio(0, Telefone.DDD.length - 1)];
		telefone.setDdd(" " + ddd);
	}

	@Test(expected = IllegalArgumentException.class)
	public void step_25_nao_deve_aceitar_espacos_em_branco_no_inicio_do_atributo_ddd() {
		String ddd = Telefone.DDD[Gerador.geraNumeroAleatorio(0, Telefone.DDD.length - 1)];
		telefone.setDdd(ddd + " ");
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

	@Test
	public void step_26_teste_equals_reflexivo() {

		Telefone telefone1 = new Telefone("11", "123456789");
		assertTrue(telefone1.equals(telefone1));
	}

	@Test
	public void step_27_teste_equals_simetrico() {

		Telefone telefone1 = new Telefone("11", "123456789");
		Telefone telefone2 = new Telefone("11", "123456789");
		assertTrue(telefone1.equals(telefone2) == telefone2.equals(telefone1));
	}

	@Test
	public void step_28_teste_equals_transitivo() {

		Telefone telefone1 = new Telefone("11", "123456789");
		Telefone telefone2 = new Telefone("11", "123456789");
		Telefone telefone3 = new Telefone("11", "123456789");

		assertTrue((telefone1.equals(telefone2) == telefone2.equals(telefone3)) == telefone1.equals(telefone3));

	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void step_29_teste_equals_objeto_outra_classe() {
		assertFalse(telefone.equals(""));
	}

	@Test
	public void step_31_teste_equals_com_objeto_nulo() {
		assertFalse(telefone.equals(null));
	}

	@Test
	public void step_34_teste_equals_todos_atributos_iguais() {
		Telefone telefone1 = new Telefone("11", "123456789");
		Telefone telefone2 = new Telefone("11", "123456789");
		assertTrue(telefone1.equals(telefone2));

	}

	@Test
	public void step_35_teste_equals_ddd_diferente() {
		Telefone telefone1 = new Telefone("11", "123456789");
		Telefone telefone2 = new Telefone("12", "123456789");
		assertFalse(telefone1.equals(telefone2));

	}

	@Test
	public void step_36_teste_equals_numero_diferente() {
		Telefone telefone1 = new Telefone("11", "123456789");
		Telefone telefone2 = new Telefone("11", "123456788");
		assertFalse(telefone1.equals(telefone2));

	}

	@Test
	public void step_37_teste_equals_todos_atributos_diferente() {
		Telefone telefone1 = new Telefone("11", "123456789");
		Telefone telefone2 = new Telefone("12", "123456788");
		assertFalse(telefone1.equals(telefone2));

	}

	@Test
	public void step_38_teste_hashcode_reflexivo() {

		Telefone telefone1 = new Telefone("11", "123456789");
		assertEquals(telefone1.hashCode(), telefone1.hashCode());
	}

	@Test
	public void step_39_teste_hashcode_simetrico() {
		Telefone telefone1 = new Telefone("11", "123456789");
		Telefone telefone2 = new Telefone("11", "123456789");
		assertTrue(telefone1.hashCode() == telefone2.hashCode());
	}

	@Test
	public void step_40_teste_hashcode_transitivo() {
		Telefone telefone1 = new Telefone("11", "123456789");
		Telefone telefone2 = new Telefone("11", "123456789");
		Telefone telefone3 = new Telefone("11", "123456789");
		assertTrue((telefone1.hashCode() == telefone2.hashCode()));
		assertTrue(telefone2.hashCode() == telefone3.hashCode());
		assertTrue(telefone1.hashCode() == telefone3.hashCode());

	}

	@Test
	public void step_42_teste_hashcode_todos_atributos_iguais() {
		Telefone telefone1 = new Telefone("11", "123456789");
		Telefone telefone2 = new Telefone("11", "123456789");
		assertTrue(telefone1.hashCode() == telefone2.hashCode());

	}

	@Test
	public void step_43_teste_hashcode_ddd_diferente() {
		Telefone telefone1 = new Telefone("11", "123456789");
		Telefone telefone2 = new Telefone("12", "123456789");
		assertFalse(telefone1.hashCode() == telefone2.hashCode());

	}

	@Test
	public void step_44_teste_hashcode_numero_diferente() {
		Telefone telefone1 = new Telefone("11", "123456789");
		Telefone telefone2 = new Telefone("11", "123456788");
		assertFalse(telefone1.hashCode() == telefone2.hashCode());

	}

	@Test
	public void step_45_teste_hashcode_todos_atributos_diferente() {
		Telefone telefone1 = new Telefone("11", "123456789");
		Telefone telefone2 = new Telefone("12", "123456788");
		assertFalse(telefone1.hashCode() == telefone2.hashCode());

	}

	@Test
	public void step_46_teste_toString() {
		Telefone telefone1 = new Telefone("11", "123456789");
		assertEquals("Telefone [ddd=11, numero=123456789]", telefone1.toString());
	}

}
