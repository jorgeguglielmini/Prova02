package br.com.contmatic.prova.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.empresa.gerador.Gerador;

public class FuncionarioTest {
    private Funcionario funcionario;
    private Contato contato;
    private Departamento departamento;
    private Telefone telefone;

    @Before
    public void iniciar() {
        funcionario = new Funcionario("44188533838");
        departamento = new Departamento("Tecnologia");
        telefone = new Telefone("11", "123456789");
        contato = new Contato("jorge.guglielmini@usp.br", telefone);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_nome_nulo() {
        funcionario.setNome(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_sobrenome_nulo() {
        funcionario.setSobreNome(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_dataNascimento_nulo() {
        funcionario.setdataNascimento(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cpf_nulo() {
        funcionario.setCpf(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_contato_nulo() {
        funcionario.setContato(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cargo_nulo() {
        funcionario.setCargo(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_salario_nulo() {
        funcionario.setSalario(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_departamento_nulo() {
        funcionario.setDepartamento(null);
    }

    @Test
    public void deve_aceitar_atributo_nome_valido() {
        String nome = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(3, 50));
        funcionario.setNome(nome);
        assertEquals(nome, funcionario.getNome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_nome_com_mais_de_50_caracteres() {
        funcionario.setNome(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(51, 60)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_nome_com_menos_de_2_caracteres() {
        funcionario.setNome(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 2)));
    }

    @Test
    public void deve_aceitar_atributo_sobrenome_valido() {
        String sobreNome = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(3, 50));
        funcionario.setSobreNome(sobreNome);
        assertEquals(sobreNome, funcionario.getSobreNome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_sobrenome_com_mais_de_50_caracteres() {
        funcionario.setSobreNome(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(51, 60)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_sobrenome_com_menos_de_2_caracteres() {
        funcionario.setSobreNome(Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 2)));
    }

    @Test
    public void deve_aceitar_atributo_cpf_valido() {
        String cpfValido = "73151766242";
        funcionario.setCpf(cpfValido);
        assertEquals(cpfValido, funcionario.getCpf());
    }

    @Test
    public void deve_retornar_atributo_departamento() {
        funcionario.setDepartamento(departamento);
        assertEquals(departamento, funcionario.getDepartamento());
    }

    @Test
    public void deve_retornar_atributo_contato() {
        funcionario.setContato(contato);
        assertEquals(contato, funcionario.getContato());
    }

    @Test
    public void deve_aceitar_atributo_data_de_nascimento_valido() {
        LocalDate dataNascimento = new LocalDate("1996-06-24");
        funcionario.setdataNascimento(dataNascimento);
        assertEquals(dataNascimento, funcionario.getdataNascimento());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_data_de_nascimento_nao_valido() {
        LocalDate dataNascimento = new LocalDate();
        dataNascimento = LocalDate.now();
        funcionario.setdataNascimento(dataNascimento);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cpf_apenas_com_caracter_0() {
        funcionario.setCpf("00000000000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cpf_apenas_com_caracter_1() {
        funcionario.setCpf("11111111111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cpf_apenas_com_caracter_2() {
        funcionario.setCpf("22222222222");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cpf_apenas_com_caracter_3() {
        funcionario.setCpf("33333333333");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cpf_apenas_com_caracter_4() {
        funcionario.setCpf("44444444444");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cpf_apenas_com_caracter_5() {
        funcionario.setCpf("55555555555");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cpf_apenas_com_caracter_6() {
        funcionario.setCpf("66666666666");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cpf_apenas_com_caracter_7() {
        funcionario.setCpf("77777777777");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cpf_apenas_com_caracter_8() {
        funcionario.setCpf("88888888888");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cpf_apenas_com_caracter_9() {
        funcionario.setCpf("99999999999");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cpf_com_quantidade_de_digitos_diferente_de_onze() {
        Integer cpf1 = Gerador.geraNumeroAleatorio(1, 10);
        Integer cpf2 = Gerador.geraNumeroAleatorio(12, 13);
        funcionario.setCpf(cpf1.toString());
        funcionario.setCpf(cpf2.toString());
    }

    @Test
    public void deve_aceitar_atributo_cargo_valido() {
        String cargo = "Programador";
        funcionario.setCargo(cargo);
        assertEquals(cargo, funcionario.getCargo());
    }

    @Test
    public void deve_aceitar_atributo_contato_valido() {
        funcionario.setContato(contato);
        assertEquals(contato, funcionario.getContato());
    }

    @Test
    public void deve_aceitar_atributo_salario_valido() {
        BigDecimal salarioValido = new BigDecimal("200.2");
        funcionario.setSalario(salarioValido);
        assertEquals(salarioValido, funcionario.getSalario());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_salario_negativo() {
        BigDecimal salarioNegativo = new BigDecimal("-200.2");
        funcionario.setSalario(salarioNegativo);
    }

    @Test
    public void deve_aceitar_atributo_departamento_valido() {
        funcionario.setDepartamento(departamento);
        assertEquals(departamento, funcionario.getDepartamento());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_salario_igual_a_zero() {
        BigDecimal salarioZero = new BigDecimal("0.0");
        funcionario.setSalario(salarioZero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_receber_atributo_nome_vazio() {
        funcionario.setNome("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_receber_atributo_sobrenome_vazio() {
        funcionario.setSobreNome("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_receber_atributo_cpf_vazio() {
        funcionario.setCpf("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_receber_atributo_cargo_vazio() {
        funcionario.setCargo("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_tratar_espaco_em_branco_no_atributo_nome_no_inicio() {
        String nome = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(3, 50));
        funcionario.setNome(" " + nome);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_tratar_espaco_em_branco_no_atributo_nome_no_final() {
        String nome = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(3, 50));
        funcionario.setNome(nome + " ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_tratar_espaco_em_branco_no_atributo_sobrenome_no_inicio() {
        String sobreNome = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(3, 50));
        funcionario.setNome(" " + sobreNome);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_tratar_espaco_em_branco_no_atributo_sobrenome_no_final() {
        String sobreNome = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(3, 50));
        funcionario.setSobreNome(sobreNome + " ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_tratar_espaco_em_branco_no_atributo_cpf_no_inicio() {
        String cpf = "44188533838";
        funcionario.setCpf(" " + cpf);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_tratar_espaco_em_branco_no_atributo_cpf_no_final() {
        String cpf = "44188533838";
        funcionario.setCpf(cpf + " ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_tratar_espaco_em_branco_no_atributo_cargo_no_inicio() {
        funcionario.setCargo(" " + "Programador");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_tratar_espaco_em_branco_no_atributo_cargo_no_final() {
        String cargo = "Programador";
        funcionario.setCargo(cargo + " ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_nome_apenas_com_espacos_em_branco() {
        funcionario.setNome("           ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_sobrenome_apenas_com_espacos_em_branco() {
        funcionario.setSobreNome("           ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cpf_apenas_com_espacos_em_branco() {
        funcionario.setCpf("           ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cargo_apenas_com_espacos_em_branco() {
        funcionario.setCargo("           ");
    }

    @Test
    public void teste_equals_reflexivo() {
        LocalDate dataNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        assertTrue(funcionario1.equals(funcionario1));
    }

    @Test
    public void teste_equals_simetrico() {
        LocalDate dataNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        Funcionario funcionario2 = new Funcionario("Jorge Luiz", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        assertTrue(funcionario1.equals(funcionario2) == funcionario2.equals(funcionario1));

    }

    @Test
    public void teste_equals_transitivo() {
        LocalDate dataNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        Funcionario funcionario2 = new Funcionario("Jorge Luiz", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        Funcionario funcionario3 = new Funcionario("Jorge Luiz", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        assertTrue((funcionario1.equals(funcionario2) == funcionario2.equals(funcionario3)) == funcionario1.equals(funcionario3));
    }

    @SuppressWarnings("unlikely-arg-type")
    @Test
    public void teste_equals_objeto_outra_classe() {
        LocalDate dataNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        assertFalse(funcionario1.equals(""));

    }

    @Test
    public void teste_equals_objeto_com_atributo_cpf_diferente() {
        LocalDate dataNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario2 = new Funcionario("45223203020");
        funcionario2.setNome("Jorge Luiz");
        funcionario2.setSobreNome("Migliavacca");
        funcionario2.setdataNascimento(dataNascimento);
        funcionario2.setContato(contato);
        funcionario2.setCargo("Programador");
        funcionario2.setSalario(salario);
        funcionario2.setDepartamento(departamento);
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        assertFalse(funcionario1.equals(funcionario2));
    }

    @Test
    public void teste_equals_com_objeto_nulo() {
        assertFalse(funcionario.equals(null));
    }

    @Test
    public void teste_equals_todos_atributos_iguais() {
        LocalDate dataNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");

        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        Funcionario funcionario2 = new Funcionario("Jorge Luiz", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        assertTrue(funcionario1.equals(funcionario2));

    }

    @Test
    public void teste_equals_todos_atributos_diferentes() {
        LocalDate dataNascimento = new LocalDate("1996-06-24");
        LocalDate dataNascimento2 = new LocalDate("1995-05-23");
        BigDecimal salario1 = new BigDecimal("2000.2");
        BigDecimal salario2 = new BigDecimal("2000.1");
        Telefone telefone2 = new Telefone("12", "234567891");
        Contato contato2 = new Contato("jorgeguglielmini@gmail.com", telefone2);
        Departamento departamento2 = new Departamento("NTecnologias");

        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario1, departamento);

        Funcionario funcionario2 = new Funcionario("Roberto", "Afonso", dataNascimento2, "45223203020", contato2, "Analista", salario2, departamento2);

        assertFalse(funcionario1.equals(funcionario2));

    }

    @Test
    public void teste_equals_objeto_com_atributo_nulo_e_objeto_com_atributo_nao_nulo() {
        LocalDate dataNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        assertFalse(funcionario.equals(funcionario1));
    }

    @Test
    public void teste_equals_objeto_com_atributo_cpf_nulo_e_demais_atributos_nao_nulos() {
        LocalDate dataNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        funcionario.setNome("Jorge Luiz");
        funcionario.setSobreNome("Migliavacca");
        funcionario.setdataNascimento(dataNascimento);
        funcionario.setContato(contato);
        funcionario.setCargo("Programador");
        funcionario.setSalario(salario);
        funcionario.setDepartamento(departamento);
        assertFalse(funcionario.equals(funcionario1));
    }

    @Test
    public void teste_equals_cpf_diferente() {
        LocalDate dataNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        Funcionario funcionario2 = new Funcionario("Jorge", "Migliavacca", dataNascimento, "45223203020", contato, "Programador", salario, departamento);
        assertFalse(funcionario1.equals(funcionario2));

    }

    @Test
    public void teste_hashcode_reflexivo() {

        LocalDate dataNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        assertEquals(funcionario1.hashCode(), funcionario1.hashCode());
    }

    @Test
    public void teste_hashcode_simetrico() {
        LocalDate dataNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        Funcionario funcionario2 = new Funcionario("Jorge", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        assertTrue(funcionario1.hashCode() == funcionario2.hashCode());
    }

    @Test
    public void teste_hashcode_transitivo() {
        LocalDate dataNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        Funcionario funcionario2 = new Funcionario("Jorge", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        Funcionario funcionario3 = new Funcionario("Jorge", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        assertTrue(funcionario1.hashCode() == funcionario2.hashCode());
        assertTrue(funcionario2.hashCode() == funcionario3.hashCode());
        assertTrue(funcionario1.hashCode() == funcionario3.hashCode());

    }

    @Test
    public void teste_hashcode_todos_atributos_iguais() {
        LocalDate dataNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        Funcionario funcionario2 = new Funcionario("Jorge", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        assertTrue(funcionario1.hashCode() == funcionario2.hashCode());
    }

    @Test
    public void teste_hashcode_cpf_diferente() {
        LocalDate dataNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        String cpfFuncionario1 = new String ("63517553107");
        String cpfFuncionario2 = new String ("73151766242");       
        Funcionario funcionario1 = new Funcionario("Jorge", "Migliavacca", dataNascimento, cpfFuncionario1 ,contato, "Programador", salario, departamento);
        Funcionario funcionario2 = new Funcionario("Jorge", "Migliavacca", dataNascimento, cpfFuncionario2, contato, "Programador", salario, departamento);
        assertFalse(funcionario1.hashCode() == funcionario2.hashCode());

    }

    @Test
    public void teste_toString() {
        LocalDate dataNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge", "Migliavacca", dataNascimento, "44188533838", contato, "Programador", salario, departamento);
        assertEquals(
            "Funcionario [nome=Jorge, sobreNome=Migliavacca, dataNascimento=1996-06-24, cpf=44188533838," +
                " contato=Contato [email=jorge.guglielmini@usp.br, telefone=Telefone [ddd=11, numero=123456789]]," + " cargo=Programador, salario=2000.2, departamento=Departamento [nome=Tecnologia]]",
            funcionario1.toString());

    }
}
