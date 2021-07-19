package br.com.contmatic.prova.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.empresa.gerador.Gerador;

public class DepartamentoTest {

	private Departamento departamento;

	@Before
	public void iniciar() {
		departamento = new Departamento("Tecnologia");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_nome_nulo() {
		departamento.setNome(null);
	}

	@Test
	public void deve_aceitar_atributo_nome_valido() {
		departamento.setNome(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 199)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_nome_vazio() {
		departamento.setNome("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_atributo_nome_em_branco() {
		departamento.setNome("             ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_espacos_em_branco_no__do_atributo_nome() {
		String nome = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 10));
		departamento.setNome(" " + nome);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_espacos_em_branco_no_final_do_atributo_nome() {
		String nome = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 10));
		departamento.setNome(nome + " ");
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
	public void teste_equals_reflexivo() {
		Departamento departamento1 = new Departamento("Tecnologias");
		assertTrue(departamento1.equals(departamento1));
	}

	@Test
	public void teste_equals_simetrico() {
		Departamento departamento1 = new Departamento("Tecnologias");
		Departamento departamento2 = new Departamento("Tecnologias");
		assertTrue(departamento1.equals(departamento2) == departamento2.equals(departamento1));

	}

	@Test
	public void teste_equals_transitivo() {
		Departamento departamento1 = new Departamento("Tecnologias");
		Departamento departamento2 = new Departamento("Tecnologias");
		Departamento departamento3 = new Departamento("Tecnologias");
		assertTrue((departamento1.equals(departamento2) == departamento2.equals(departamento3)) == departamento1.equals(departamento3));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void teste_equals_objeto_outra_classe() {
		Departamento departamento1 = new Departamento("Tecnologia");
		assertFalse(departamento1.equals(""));
		
	}
	
	@Test
	public void teste_equals_todos_atributos_nulos() {
		Departamento departamento1 = new Departamento("Tecnologia");
		Departamento departamento2 = new Departamento("Tecnologia");
		assertTrue(departamento1.equals(departamento2));

	}
	
	@Test
	public void teste_equals_com_objeto_nulo() {
		Departamento departamento1 = new Departamento("Tecnologia");
		assertFalse(departamento1.equals(null));
	}
	
	

	@Test
	public void teste_equals_todos_atributos_iguais() {
		Departamento departamento1 = new Departamento("Tecnologias");
		Departamento departamento2 = new Departamento("Tecnologias");
		assertTrue(departamento1.equals(departamento2));

	}

//	@Test
//	public void teste_equals_objeto_com_atributo_nulo_e_objeto_com_atributo_nao_nulo() {
//		Departamento departamento1 = new Departamento("Tecnologias");
//		Departamento departamento2 = new Departamento(null);
//		assertFalse(departamento2.equals(departamento1));
//	}
	
	@Test
	public void teste_equals_todos_atributos_diferente() {
		Departamento departamento1 = new Departamento("Tecnologias");
		Departamento departamento2 = new Departamento("TI");
		assertFalse(departamento1.equals(departamento2));
	}

	@Test
	public void teste_hashcode_reflexivo() {

		Departamento departamento1 = new Departamento("Tecnologias");
		assertEquals(departamento1.hashCode(), departamento1.hashCode());
	}

	@Test
	public void teste_hashcode_simetrico() {
		Departamento departamento1 = new Departamento("Tecnologias");
		Departamento departamento2 = new Departamento("Tecnologias");
		assertTrue(departamento1.hashCode() == departamento2.hashCode());
	}

	@Test
	public void teste_hashcode_transitivo() {
		Departamento departamento1 = new Departamento("Tecnologias");
		Departamento departamento2 = new Departamento("Tecnologias");
		Departamento departamento3 = new Departamento("Tecnologias");
		assertTrue((departamento1.hashCode() == departamento2.hashCode()));
		assertTrue(departamento2.hashCode() == departamento3.hashCode());
		assertTrue(departamento1.hashCode() == departamento3.hashCode());

	}

//	@Test
//	public void teste_hashcode_todos_atributos_nulos() {
//		Departamento departamento1 = new Departamento(null);
//		Departamento departamento2 = new Departamento(null);
//		assertTrue(departamento1.hashCode() == departamento2.hashCode());
//
//	}
	
	@Test
	public void teste_hashcode_todos_atributos_iguais() {
		Departamento departamento1 = new Departamento("Tecnologias");
		Departamento departamento2 = new Departamento("Tecnologias");
		assertTrue(departamento1.hashCode() == departamento2.hashCode());

	}

	@Test
	public void teste_hashcode_todos_atributos_diferente() {
		Departamento departamento1 = new Departamento("Tecnologias");
		Departamento departamento2 = new Departamento("TI");
		assertFalse(departamento1.hashCode() == departamento2.hashCode());

	}

	@Test
	public void teste_toString() {
		Departamento departamento1 = new Departamento("Tecnologias");
		assertEquals("Departamento [nome=Tecnologias]", departamento1.toString());
	}

}
