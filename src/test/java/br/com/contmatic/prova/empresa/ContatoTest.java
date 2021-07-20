package br.com.contmatic.prova.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.prova.empresa.enums.DDD;
import br.com.contmatic.prova.empresa.gerador.Gerador;

public class ContatoTest {
	
    private Contato contato;
    
    private Telefone telefone;

    @Before
    public void iniciar() {
        telefone = new Telefone(DDD.DDD_11, "123456789");
        contato = new Contato("jorge.guglielmini@gmail.com", telefone);
    }

    @After
    public void finalizar() {
    }

    @BeforeClass
    public static void antes_da_classe() {
        System.out.println("Essa mensagem está sendo exibida uma única vez no início");
    }

    @AfterClass
    public static void depois_da_classe() {
        System.out.println("Essa mensagem está sendo exibida uma única vez no final");
    }

    @Test
    public void deve_testar_get_telefone() {
        Telefone telefone = new Telefone("11", "123456789");
        contato.setTelefone(telefone);
        contato.getTelefone();
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_email_nulo() {
        contato.setEmail(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_telefone_nulo() {
        contato.setTelefone(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_email_vazio() {
        contato.setEmail("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_email_apenas_com_espacos_em_branco() {
        contato.setEmail("       ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_tratar_espacos_em_branco_do_atributo_email_no_inicio() {
        String email = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 10));
        contato.setEmail(" " + email);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_tratar_espacos_em_branco_do_atributo_email_no_final() {
        String email = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 10));
        contato.setEmail(email + " ");
    }

    @Test
    public void deve_aceitar_no_atributo_email_uma_quantidade_de_caracteres_que_esteja_entre_1_e_199() {
        int email = Gerador.geraNumeroAleatorio(1, 199);
        contato.setEmail(Gerador.geraStringAleatoria(email));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_no_atributo_email_uma_quantidade_de_caracteres_maior_que_200_no_atributo_email() {
        contato.setEmail(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(200, 1000)));
    }

    @Test
    public void teste_equals_objeto_com_atributo_telefone_diferente() {
        Telefone telefone2 = new Telefone("11", "123456789");
        telefone2.setDdd("12");
        telefone2.setNumero("123456788");
        Contato contato1 = new Contato("email", telefone);
        Contato contato2 = new Contato("email", telefone2);
        assertFalse(contato1.equals(contato2));
    }

    @Test
    public void teste_equals_com_objeto_nulo() {
        assertFalse(contato.equals(null));
    }

    @Test
    public void teste_equals_todos_atributos_iguais() {
        Contato contato1 = new Contato("email", telefone);
        Contato contato2 = new Contato("email", telefone);
        assertFalse(contato1.equals(contato2));
    }

    @Test
    public void teste_equals_objeto_nulo_e_objeto_nao_nulo() {
        Contato contato1 = new Contato("email", telefone);
        assertFalse(contato.equals(contato1));
    }

    @Test
    public void teste_equals_todos_atributos_diferente() {
        Telefone telefone1 = new Telefone("12", "123456788");
        Contato contato1 = new Contato("email", telefone);
        Contato contato2 = new Contato("email1", telefone1);
        assertFalse(contato1.equals(contato2));
    }

    @Test
    public void teste_hashcode_todos_atributos_iguais() {
        Contato contato1 = new Contato("email", telefone);
        Contato contato2 = new Contato("email", telefone);
        assertFalse(contato1.hashCode() == contato2.hashCode());
    }

    @Test
    public void teste_hashcode_todos_atributos_diferente() {
        Telefone telefone1 = new Telefone("12", "123456788");
        Contato contato1 = new Contato("email", telefone);
        Contato contato2 = new Contato("email1", telefone1);
        assertFalse(contato1.hashCode() == contato2.hashCode());
    }

    @Test
    public void teste_toString() {
        Contato contato1 = new Contato("email", telefone);
        System.out.println(contato1);
        assertEquals("Contato [email=email, telefone=Telefone [ddd=11, numero=123456789]]", contato1.toString());
    }

}
