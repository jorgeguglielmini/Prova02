package br.com.contmatic.prova.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.empresa.gerador.Gerador;

public class EnderecoTest {

	private Endereco endereco;

	@Before
	public void iniciar() {
		endereco = new Endereco("05110000","5335");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_estado_nulo() {
		endereco.setUf(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_cidade_nulo() {
		endereco.setCidade(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_bairro_nulo() {
		endereco.setBairro(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_logradouro_nulo() {
		endereco.setLogradouro(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_numero_nulo() {
		endereco.setNumero(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_cep_nulo() {
		endereco.setCep(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_uf_nao_valido() {
		String uf = "SP";
		boolean temNaLista = true;

		while (temNaLista) {
			uf = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(2, 2));
			for (int i = 0; i < Endereco.SIGLAS_UF.length; i++) {

				if (uf.equals(Endereco.SIGLAS_UF[i])) {
					temNaLista = true;
					break;
				}
				if (i == Endereco.SIGLAS_UF.length - 1) {
					temNaLista = false;
				}
			}
		}
		endereco.setUf(uf);
	}

	@Test
	public void deve_aceitar_uf_valido() {
		String uf = Endereco.SIGLAS_UF[Gerador.geraNumeroAleatorio(0, Endereco.SIGLAS_UF.length - 1)];
		endereco.setUf(uf);
		assertEquals(uf, endereco.getUf());
	}

	@Test
	public void deve_aceitar_atributo_cidade_valido() {
		String cidade = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 110));
		endereco.setCidade(cidade);
		assertEquals(cidade, endereco.getCidade());
	}

	@Test
	public void deve_aceitar_atributo_bairro_valido() {
		String bairro = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 110));
		endereco.setBairro(bairro);
		assertEquals(bairro, endereco.getBairro());
	}

	@Test
	public void deve_aceitar_atributo_logradouro_valido() {
		String logradouro = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 20));
		endereco.setLogradouro(logradouro);
		assertEquals(logradouro, endereco.getLogradouro());
	}

	@Test
	public void deve_aceitar_atributo_numero_valido() {
		Integer numero = Gerador.geraNumeroAleatorio(1, 99999);
		endereco.setNumero(numero.toString());
		assertEquals(numero.toString(), endereco.getNumero());
	}

	@Test
	public void deve_aceitar_atributo_cep_valido() {
		Integer cep = Gerador.geraNumeroAleatorio(10000000, 99999999);
		System.out.println(cep);
		endereco.setCep(cep.toString());
		assertEquals(cep.toString(), endereco.getCep());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_uf_diferente_de_dois_digitos() {
		endereco.setUf(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 1)));
		endereco.setUf(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(3, 20)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_cidade_maior_de_cento_e_dez_caracteres() {
		endereco.setCidade(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(111, 200)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_bairro_maior_de_cento_e_dez_caracteres() {
		endereco.setBairro(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(111, 200)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_logradouro_maior_de_cento_e_dez_caracteres() {
		endereco.setLogradouro(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(111, 200)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_numero_maior_de_100000() {
		Integer numero = Gerador.geraNumeroAleatorio(999999, 9999999);
		System.out.println(numero);
		endereco.setNumero(numero.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_cep_diferente_de_oito_digitos() {

		Integer cep1 = Gerador.geraNumeroAleatorio(1, 9999999);
		Integer cep2 = Gerador.geraNumeroAleatorio(100000000, 999999999);

		endereco.setCep(cep1.toString());
		endereco.setCep(cep2.toString());

	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_uf_com_numeros() {
		Integer uf = 0;
		uf = Gerador.geraNumeroAleatorio(2, 2);
		endereco.setUf(uf.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_numero_com_letras() {
		String numero = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 99999));
		endereco.setNumero(numero);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_cep_com_letras_dado_8_caracteres() {
		String cep1 = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1000, 9999));
		String cep2 = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1000, 9999));
		endereco.setCep(cep1 + cep2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_tratar_espaco_em_branco_no_atributo_uf_no_inicio() {
		String uf = Endereco.SIGLAS_UF[Gerador.geraNumeroAleatorio(0, Endereco.SIGLAS_UF.length - 1)];
		endereco.setUf(" " + uf);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_tratar_espaco_em_branco_no_atributo_uf_no_final() {
		String uf = Endereco.SIGLAS_UF[Gerador.geraNumeroAleatorio(0, Endereco.SIGLAS_UF.length - 1)];
		endereco.setUf(uf + " ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_tratar_espaco_em_branco_no_atributo_cidade_no_inicio() {
		String cidade = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 110));
		endereco.setCidade(" " + cidade);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_tratar_espaco_em_branco_no_atributo_cidade_no_final() {
		String cidade = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 110));
		endereco.setCidade(cidade + " ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_tratar_espaco_em_branco_no_atributo_bairro_no_inicio() {
		String bairro = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 110));
		endereco.setBairro(" " + bairro);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_tratar_espaco_em_branco_no_atributo_bairro_no_final() {
		String bairro = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 110));
		endereco.setBairro(bairro + " ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_tratar_espaco_em_branco_no_atributo_logradouro_no_inicio() {
		String logradouro = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 20));
		endereco.setLogradouro(" " + logradouro);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_tratar_espaco_em_branco_no_atributo_logradouro_no_final() {
		String logradouro = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 20));
		endereco.setLogradouro(logradouro + " ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_tratar_espaco_em_branco_no_atributo_numero_no_inicio() {
		Integer numero = (Gerador.geraNumeroAleatorio(1, 99999));
		endereco.setNumero(" " + numero);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_tratar_espaco_em_branco_no_atributo_numero_no_final() {
		Integer numero = (Gerador.geraNumeroAleatorio(1, 99999));
		endereco.setNumero(numero + " ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_tratar_espaco_em_branco_no_atributo_cep_no_inicio() {
		Integer cep = (Gerador.geraNumeroAleatorio(10000000, 99999999));
		endereco.setCep(" " + cep);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_tratar_espaco_em_branco_no_atributo_cep_no_final() {
		Integer cep = (Gerador.geraNumeroAleatorio(10000000, 99999999));
		endereco.setCep(cep + " ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_receber_atributo_uf_vazio() {
		endereco.setUf("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_receber_atributo_cidade_vazio() {
		endereco.setCidade("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_receber_atributo_bairro_vazio() {
		endereco.setBairro("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_receber_atributo_numero_vazio() {
		endereco.setNumero("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_receber_atributo_cep_vazio() {
		endereco.setCep("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_receber_atributo_uf_com_espacos_em_branco() {
		endereco.setUf("       ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_receber_atributo_cidade_com_espacos_em_branco() {
		endereco.setUf("       ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_receber_atributo_bairro_com_espacos_em_branco() {
		endereco.setBairro("       ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_receber_atributo_logradouro_com_espacos_em_branco() {
		endereco.setLogradouro("       ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_receber_atributo_numero_com_espacos_em_branco() {
		endereco.setNumero("       ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_receber_atributo_cep_com_espacos_em_branco() {
		endereco.setCep("        ");
	}

	@Test
	public void teste_equals_reflexivo() {
		Endereco endereco1 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		System.out.println(endereco1);
		assertTrue(endereco1.equals(endereco1));
	}

	@Test
	public void teste_equals_simetrico() {

		Endereco endereco1 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		Endereco endereco2 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		assertTrue(endereco1.equals(endereco2) == endereco2.equals(endereco1));
	}

	@Test
	public void teste_equals_transitivo() {

		Endereco endereco1 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		Endereco endereco2 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		Endereco endereco3 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		assertTrue((endereco1.equals(endereco2) == endereco2.equals(endereco3)) == endereco1.equals(endereco3));

	}

	@Test
	public void teste_equals_objeto_outra_classe() {
		Endereco endereco1 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		assertFalse(endereco1.equals(""));
	}

	@Test
	public void teste_equals_todos_atributos_nulos() {
		Endereco endereco1 = new Endereco("05110000","5335");
		assertTrue(endereco.equals(endereco1));
	}

	@Test
	public void teste_equals_com_objeto_nulo() {
		assertFalse(endereco.equals(null));
	}

	@Test
	public void teste_equals_objeto_com_atributo_nulo_e_objeto_com_atributo_nao_nulo() {
		Endereco endereco1 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		assertFalse(endereco.equals(endereco1));
	}

	@Test
	public void teste_equals_objeto_com_atributo_cep_nulo_e_demais_atributos_nao_nulos() {
		Endereco endereco1 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		endereco.setUf("SP");
		endereco.setCidade("São Paulo");
		endereco.setBairro("Vila Formosa");
		endereco.setLogradouro("casa 2");
		endereco.setNumero("5214");
		assertFalse(endereco.equals(endereco1));

	}

	@Test
	public void teste_equals_todos_atributos_iguais() {
		Endereco endereco1 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		Endereco endereco2 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		assertTrue(endereco1.equals(endereco2));

	}

	@Test
	public void teste_equals_cep_diferente() {
		Endereco endereco1 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		Endereco endereco2 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312133");
		assertFalse(endereco1.equals(endereco2));

	}

	@Test
	public void teste_equals_todos_atributos_diferente() {
		Endereco endereco1 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		Endereco endereco2 = new Endereco("RJ", "Rio de Janeiro", "Vila Piaui", "casa 1", "2214", "02312133");
		assertFalse(endereco1.equals(endereco2));

	}

	@Test
	public void teste_hashcode_reflexivo() {

		Endereco endereco1 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		assertEquals(endereco1.hashCode(), endereco1.hashCode());
	}

	@Test
	public void teste_hashcode_simetrico() {
		Endereco endereco1 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		Endereco endereco2 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		assertTrue(endereco1.hashCode() == endereco2.hashCode());
	}

	@Test
	public void teste_hashcode_transitivo() {
		Endereco endereco1 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		Endereco endereco2 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		Endereco endereco3 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		assertTrue((endereco1.hashCode() == endereco2.hashCode()));
		assertTrue(endereco2.hashCode() == endereco3.hashCode());
		assertTrue(endereco1.hashCode() == endereco3.hashCode());

	}

	@Test
	public void teste_hashcode_todos_atributos_nulos() {
		Endereco endereco1 = new Endereco("05110000","5335");
		Endereco endereco2 = new Endereco("05110000","5335");
		assertTrue(endereco1.hashCode() == endereco2.hashCode());

	}

	@Test
	public void teste_hashcode_todos_atributos_iguais() {
		Endereco endereco1 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		Endereco endereco2 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		assertTrue(endereco1.hashCode() == endereco2.hashCode());

	}

	@Test
	public void teste_hashcode_cep_diferente() {
		Endereco endereco1 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		Endereco endereco2 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312133");
		assertFalse(endereco1.hashCode() == endereco2.hashCode());

	}

	@Test
	public void teste_hashcode_todos_atributos_diferente() {
		Endereco endereco1 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		Endereco endereco2 = new Endereco("RJ", "Rio de Janeiro", "Vila Piaui", "casa 1", "2214", "02312133");
		assertFalse(endereco1.hashCode() == endereco2.hashCode());

	}

	@Test
	public void step_46_teste_toString() {
		Endereco endereco1 = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
		assertEquals(
				"Endereco [uf=SP, cidade=São Paulo, bairro=Vila Formosa, logradouro=casa 2, numero=5214, cep=02312122]",
				endereco1.toString());
	}

}
