package br.com.contmatic.prova.empresa;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.prova.empresa.enums.DDD;

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
    public void nao_deve_aceitar_atributo_email_nulo() {

    }

    @Test
    public void nao_deve_aceitar_atributo_telefone_nulo() {
    }

    @Test
    public void nao_deve_aceitar_atributo_email_vazio() {
    }

    @Test
    public void nao_deve_aceitar_atributo_email_apenas_com_espacos_em_branco() {
    }

    @Test
    public void deve_tratar_espacos_em_branco_do_atributo_email_no_inicio() {
    }

    @Test
    public void deve_tratar_espacos_em_branco_do_atributo_email_no_final() {
    }

    @Test
    public void deve_aceitar_no_atributo_email_uma_quantidade_de_caracteres_que_esteja_entre_1_e_199() {
    }

    @Test
    public void nao_deve_aceitar_no_atributo_email_uma_quantidade_de_caracteres_maior_que_200_no_atributo_email() {
    }
    
    @Test
    public void teste_toString() {
        Contato contato1 = new Contato("jorge.guglielmini@gmail.com", telefone);
        System.out.println(contato1);
        assertEquals("Contato [email=email, telefone=Telefone [ddd=11, numero=123456789]]", contato1.toString());
        //como está o sysout do contato:
        //{"email":"jorge.guglielmini@gmail.com","telefone":{"numero":"123456789","ddd":"DDD_11"}}
    }
}
