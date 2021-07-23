package br.com.contmatic.prova.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.prova.empresa.enums.DDD;
import br.com.contmatic.prova.empresa.templates.ContatoFixtureFactoryTemplate;
import br.com.contmatic.prova.testutils.Validacao;
import br.com.six2six.fixturefactory.Fixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class ContatoTest {

    private Contato contato;
    
    private Telefone telefone;
    
    @BeforeClass
    public static void setup() {
        new ContatoFixtureFactoryTemplate().load();
    }
    
    @Before
    public void iniciar() {
        contato = Fixture.from(Contato.class).gimme("valido");
    }

    @Test
    public void todos_atributos_validos() {
        assertTrue(Validacao.Valida(contato));
    }

    @Test
    public void nao_deve_aceitar_atributo_telefone_nulo() {
        contato.setTelefone(null);
        assertFalse(Validacao.Valida(contato));
    }

    @Test
    public void nao_deve_aceitar_atributo_email_nulo() {
        contato.setEmail(null);
        assertFalse(Validacao.Valida(contato));
    }

    @Test
    public void nao_deve_aceitar_atributo_email_apenas_com_espacos_em_branco() {
    }

    @Test
    public void nao_deve_aceitar_atributo_email_com_espacos_em_branco_no_inicio() {
        contato = Fixture.from(Contato.class).gimme("atributo email com espaco em branco no inicio");
        assertFalse(Validacao.Valida(contato));
    }

    @Test
    public void nao_deve_aceitar_atributo_email_com_espacos_em_branco_no_final() {
        contato = Fixture.from(Contato.class).gimme("atributo email com espaco em branco no final");
        assertFalse(Validacao.Valida(contato));
    }

    @Test
    public void deve_aceitar_no_atributo_email_uma_quantidade_de_caracteres_que_esteja_entre_1_e_199() {
    }

    @Test
    public void nao_deve_aceitar_no_atributo_email_uma_quantidade_de_caracteres_maior_que_200_no_atributo_email() {
    }
    
    @Test
    public void equals_verifier() {
        EqualsVerifier.forClass(Contato.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void teste_toString() {
        telefone = new Telefone(DDD.DDD_11,"123456789");
        Contato contato1 = new Contato("jorge.guglielmini@gmail.com", telefone);
        assertEquals("{\"email\":\"jorge.guglielmini@gmail.com\",\"telefone\":{\"numero\":\"123456789\",\"ddd\":\"DDD_11\"}}", contato1.toString());
    }
}
