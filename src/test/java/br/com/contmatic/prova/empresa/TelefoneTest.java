package br.com.contmatic.prova.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
    public void step_01_teste_ignore() {
        System.out.println("Mensagem não será exibida pois há a annotation @Ignore");
    }

    @Test
    public void step_03_todos_atributos_validos() {
        assertTrue(Validacao.Valida(telefone));
    }

    @Test
    public void step_04_atributo_numero_com_menos_de_8_digitos() {
        telefone = Fixture.from(Telefone.class).gimme("atributo numero com menos de 8 dígitos");
        assertFalse(Validacao.Valida(telefone));
    }

    @Test
    public void step_05_atributo_numero_com_mais_de_9_digitos() {
        telefone = Fixture.from(Telefone.class).gimme("atributo numero com mais de 9 dígitos");
        assertFalse(Validacao.Valida(telefone));
    }

    @Test
    public void step_06_atributo_numero_com_digito_0_no_inicio() {
        telefone = Fixture.from(Telefone.class).gimme("atributo numero com digito 0 no início e contendo a quantidade correta de digitos");
        assertFalse(Validacao.Valida(telefone));
    }

    @Test
    public void step_07_nao_deve_aceitar_atributo_ddd_nulo() {
        telefone.setDdd(null);
        assertFalse(Validacao.Valida(telefone));
    }
    
    @Test
    public void step_08_nao_deve_aceitar_atributo_numero_nulo() {
        telefone.setNumero(null);
        assertFalse(Validacao.Valida(telefone));
    }
    
    @Test
    public void step_09_nao_deve_aceitar_atributo_numero_com_caracteres_alfabeticos() {
        telefone = Fixture.from(Telefone.class).gimme("atributo numero com caracteres alfabeticos");
        assertFalse(Validacao.Valida(telefone));
    }
    
    @Test
    public void step_10_nao_deve_aceitar_atributo_numero_com_caracteres_alfabeticos_e_numericos() {
        telefone = Fixture.from(Telefone.class).gimme("atributo numero com caracteres alfabeticos e numericos");
        assertFalse(Validacao.Valida(telefone));
    }
    
    @Test
    public void step_11_nao_deve_aceitar_atributo_numero_com_espaco_espaco_em_branco_no_inicio() {
        telefone = Fixture.from(Telefone.class).gimme("atributo numero com espaco em branco no inicio");
        assertFalse(Validacao.Valida(telefone));
    }
    
    @Test
    public void step_12_nao_deve_aceitar_atributo_numero_com_espaco_espaco_em_branco_no_final() {
        telefone = Fixture.from(Telefone.class).gimme("atributo numero com espaco em branco no final");
        assertFalse(Validacao.Valida(telefone));
    }

    @Test
    public void equals_verifier() {
        EqualsVerifier.forClass(Telefone.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }
    
    @Test
    public void teste_toString() {
        Telefone telefone1 = new Telefone(DDD.DDD_11, "12345678");
        assertEquals("{\"numero\":\"12345678\",\"ddd\":\"DDD_11\"}",telefone1.toString());
    }
}
