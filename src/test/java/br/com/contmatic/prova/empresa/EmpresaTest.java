package br.com.contmatic.prova.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.empresa.gerador.Gerador;

public class EmpresaTest {

    private Empresa empresa;

    private Funcionario funcionario;

    private Contato contatofunc;

    private Contato contatoempresa;

    private Endereco endereco;

    private Departamento departamento;

    private Telefone telefonefunc;

    private Telefone telefoneempresa;

    @Before
    public void iniciar() {
        empresa = new Empresa("58119371000177");
        funcionario = new Funcionario("44188533838");
        departamento = new Departamento("Tecnologia");
        telefonefunc = new Telefone("11", "123456789");
        telefoneempresa = new Telefone("11", "987654321");
        contatofunc = new Contato("jorge.guglielmini@usp.br", telefonefunc);
        contatoempresa = new Contato("contmatic@contmatic.com.br", telefoneempresa);
        endereco = new Endereco("SP", "São Paulo", "Vila Formosa", "casa 2", "5214", "02312122");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cnpj_nulo() {
        empresa.setCnpj(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_nome_fantasia_nulo() {
        empresa.setNomeFantasia(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_razao_social_nulo() {
        empresa.setRazaoSocial(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_endereco_nulo() {
        empresa.setEndereco(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_contato_nulo() {
        empresa.setContato(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_funcinario_nulo() {
        empresa.setFuncionario(null);
    }

    @Test
    public void deve_aceitar_atributo_cnpj_valido() {
        String cnpjValido = "99444607000128";
        empresa.setCnpj(cnpjValido);
        assertEquals(cnpjValido, empresa.getCnpj());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cnpj_nao_valido() {
        empresa.setCnpj("1234567891234");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cnpj_diferente_de_14_digitos() {
        Integer cnpj1 = Gerador.geraNumeroAleatorio(1, 13);
        Integer cnpj2 = Gerador.geraNumeroAleatorio(15, 17);
        empresa.setCnpj(cnpj1.toString());
        empresa.setCnpj(cnpj2.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cnpj_com_caracteres_iguais_a_0() {
        empresa.setCnpj("00000000000000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cnpj_com_caracteres_iguais_a_1() {
        empresa.setCnpj("11111111111111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cnpj_com_caracteres_iguais_a_2() {
        empresa.setCnpj("22222222222222");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cnpj_com_caracteres_iguais_a_3() {
        empresa.setCnpj("33333333333333");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cnpj_com_caracteres_iguais_a_4() {
        empresa.setCnpj("44444444444444");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cnpj_com_caracteres_iguais_a_5() {
        empresa.setCnpj("55555555555555");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cnpj_com_caracteres_iguais_a_6() {
        empresa.setCnpj("66666666666666");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cnpj_com_caracteres_iguais_a_7() {
        empresa.setCnpj("77777777777777");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cnpj_com_caracteres_iguais_a_8() {
        empresa.setCnpj("88888888888888");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cnpj_com_caracteres_iguais_a_9() {
        empresa.setCnpj("99999999999999");
    }

    @Test
    public void deve_aceitar_atributo_nome_fantasia_valido() {
        String nomeFantasia = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(3, 100));
        empresa.setNomeFantasia(nomeFantasia);
        assertTrue(empresa.getNomeFantasia() == nomeFantasia);
    }

    @Test
    public void deve_aceitar_atributo_razao_social_valido() {
        String razaoSocial = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(3, 100));
        empresa.setRazaoSocial(razaoSocial);
        assertTrue(empresa.getRazaoSocial() == razaoSocial);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_nome_fantasia_com_quantidade_de_caracteres_menor_que_3() {
        String nomeFantasia = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 2));
        empresa.setNomeFantasia(nomeFantasia);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_nome_fantasia_com_quantidade_de_caracteres_maior_que_100() {
        String nomeFantasia = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(101, 120));
        empresa.setNomeFantasia(nomeFantasia);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_razao_social_com_quantidade_de_caracteres_menor_que_3() {
        String razaoSocial = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(1, 2));
        empresa.setRazaoSocial(razaoSocial);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_razao_social_com_quantidade_de_caracteres_maior_que_100() {
        String razaoSocial1 = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(50, 50));
        String razaoSocial2 = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(51, 51));
        String razaoSocial3 = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(0, 10));

        empresa.setRazaoSocial((razaoSocial1 + razaoSocial2 + razaoSocial3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_receber_atributo_nome_fantasia_vazio() {
        empresa.setNomeFantasia("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_receber_atributo_razao_social_vazio() {
        empresa.setNomeFantasia("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_receber_atributo_cnpj_vazio() {
        empresa.setNomeFantasia("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_espaco_em_branco_no_inicido_do_atributo_nome_fantasia() {
        String nomeFantasia = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(3, 50));
        empresa.setNomeFantasia(" " + nomeFantasia);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_espaco_em_branco_no_final_do_atributo_nome_fantasia() {
        String nomeFantasia = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(3, 50));
        empresa.setNomeFantasia(nomeFantasia + " ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_espaco_em_branco_no_incio_do_atributo_razao_social() {
        String razaoSocial = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(3, 50));
        empresa.setRazaoSocial(" " + razaoSocial);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_espaco_em_branco_no_final_do_atributo_razao_social() {
        String razaoSocial = Gerador.geraStringAleatoria(Gerador.geraNumeroAleatorio(3, 50));
        empresa.setRazaoSocial(razaoSocial + " ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_nome_fantasia_apenas_com_espacos_em_branco() {
        empresa.setNomeFantasia("           ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_razao_social_apenas_com_espacos_em_branco() {
        empresa.setRazaoSocial("           ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_atributo_cnpj_apenas_com_espacos_em_branco() {
        empresa.setCnpj("           ");
    }

    @Test
    public void deve_retornar_atributo_endereco() {
        empresa.setEndereco(endereco);
        assertTrue(empresa.getEndereco().equals(endereco));
    }

    @Test
    public void deve_retornar_atributo_contato() {
        empresa.setContato(contatoempresa);
        assertTrue(empresa.getContato().equals(contatoempresa));
    }

    @Test
    public void deve_retornar_atributo_funcionario() {
        empresa.setFuncionario(funcionario);
        assertTrue(empresa.getFuncionario().equals(funcionario));
    }

    @Test
    public void teste_equals_reflexivo() {
        LocalDate dataDeNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataDeNascimento, "44188533838", contatofunc, "Programador", salario, departamento);
        Empresa empresa1 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        assertTrue(empresa1.equals(empresa1));
    }

    @Test
    public void teste_equals_simetrico() {
        LocalDate dataDeNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataDeNascimento, "44188533838", contatofunc, "Programador", salario, departamento);
        Empresa empresa1 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        Empresa empresa2 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        assertTrue(empresa1.equals(empresa2) == empresa2.equals(empresa1));
    }

    @Test
    public void teste_equals_transitivo() {
        LocalDate dataDeNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataDeNascimento, "44188533838", contatofunc, "Programador", salario, departamento);
        Empresa empresa1 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        Empresa empresa2 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        Empresa empresa3 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        assertTrue(empresa1.equals(empresa2) == empresa2.equals(empresa3) == empresa1.equals(empresa3));
    }

    @SuppressWarnings("unlikely-arg-type")
    @Test
    public void teste_equals_objeto_outra_classe() {
        LocalDate dataDeNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataDeNascimento, "44188533838", contatofunc, "Programador", salario, departamento);
        Empresa empresa1 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        assertFalse(empresa1.equals(""));
    }

    @Test
    public void teste_equals_objeto_com_atributo_cnpj_diferente() {
        LocalDate dataDeNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataDeNascimento, "44188533838", contatofunc, "Programador", salario, departamento);
        Empresa empresa1 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        empresa.setCnpj("42591651000143");
        empresa.setContato(contatoempresa);
        empresa.setEndereco(endereco);
        empresa.setFuncionario(funcionario1);
        empresa.setNomeFantasia("Contimatic Phoenix");
        empresa.setRazaoSocial("Contmatic Phoenix ©");
        assertFalse(empresa1.equals(empresa));
    }

    @Test
    public void teste_equals_todos_atributos_nulos() {
        Empresa empresa1 = new Empresa("58119371000177");
        Empresa empresa2 = new Empresa("58119371000177");
        assertTrue(empresa1.equals(empresa2));
    }

    @Test
    public void teste_equals_com_objeto_nulo() {
        assertFalse(empresa.equals(null));
    }

    @Test
    public void teste_equals_todos_atributos_iguais() {
        LocalDate dataDeNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataDeNascimento, "44188533838", contatofunc, "Programador", salario, departamento);
        Empresa empresa1 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        Empresa empresa2 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        assertTrue(empresa1.equals(empresa2));
    }

    @Test
    public void teste_equals_com_todos_atributos_diferentes() {
        LocalDate dataDeNascimento = new LocalDate("1996-06-24");
        LocalDate dataDeNascimento2 = new LocalDate("1995-07-25");
        BigDecimal salario1 = new BigDecimal("2000.2");
        BigDecimal salario2= new BigDecimal("2000.3");
        Departamento departamento2 = new Departamento("Tecnologias");
        Telefone telefonefunc2 = new Telefone("12", "987654321");
        Contato contatofunc2 = new Contato("jorgeguglielmini@gmail.com", telefonefunc2);
        Endereco endereco2 = new Endereco("RJ", "Rio de Janeiro", "Vila Piaui", "casa 1", "2312", "12312122");
        Telefone telefoneempresa2 = new Telefone("12", "123456789");
        Contato contatoempresa2 = new Contato("jorgeguglielmini@gmail.com", telefoneempresa2);

        Funcionario funcionario1 = new Funcionario("José", "Aparecido", dataDeNascimento, "45223203020", contatofunc, "Programador", salario1, departamento);
        Funcionario funcionario2 = new Funcionario("Jorge Luiz", "Migliavacca", dataDeNascimento2, "44188533838", contatofunc2, "Programadora", salario2, departamento2);

        Empresa empresa1 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        Empresa empresa2 = new Empresa("42591651000143", "Phoenix", "Phoenix ©", endereco2, contatoempresa2, funcionario2);

        assertFalse(empresa1.equals(empresa2));

    }

    @Test
    public void teste_hashcode_reflexivo() {
        LocalDate dataDeNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataDeNascimento, "44188533838", contatofunc, "Programador",salario, departamento);
        Empresa empresa1 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        assertEquals(empresa1.hashCode(), empresa1.hashCode());

    }

    @Test
    public void teste_hashcode_simetrico() {
        LocalDate dataDeNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataDeNascimento, "44188533838", contatofunc, "Programador", salario, departamento);
        Empresa empresa1 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        Empresa empresa2 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        assertTrue(empresa1.hashCode() == empresa2.hashCode());
    }

    @Test
    public void teste_hashcode_transitivo() {
        LocalDate dataDeNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataDeNascimento, "44188533838", contatofunc, "Programador", salario, departamento);
        Empresa empresa1 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        Empresa empresa2 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        Empresa empresa3 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);

        assertTrue(empresa1.hashCode() == empresa2.hashCode());
        assertTrue(empresa2.hashCode() == empresa3.hashCode());
        assertTrue(empresa1.hashCode() == empresa3.hashCode());

    }

    @Test
    public void teste_hashcode_todos_atributos_nulos() {
        Empresa empresa1 = new Empresa("58119371000177");
        Empresa empresa2 = new Empresa("58119371000177");
        assertTrue(empresa1.hashCode() == empresa2.hashCode());
    }

    @Test
    public void teste_hashcode_todos_atributos_iguais() {
        LocalDate dataDeNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataDeNascimento, "44188533838", contatofunc, "Programador", salario, departamento);
        Empresa empresa1 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        Empresa empresa2 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        assertTrue(empresa1.hashCode() == empresa2.hashCode());
    }

    @Test
    public void teste_toString() {
        LocalDate dataDeNascimento = new LocalDate("1996-06-24");
        BigDecimal salario = new BigDecimal("2000.2");
        Funcionario funcionario1 = new Funcionario("Jorge Luiz", "Migliavacca", dataDeNascimento, "44188533838", contatofunc, "Programador", salario, departamento);
        Empresa empresa1 = new Empresa("58119371000177", "Contimatic Phoenix", "Contmatic Phoenix ©", endereco, contatoempresa, funcionario1);
        assertEquals("Empresa [cnpj=58119371000177, nomeFantasia=Contimatic Phoenix, razaoSocial=Contmatic Phoenix ©," +
            " endereco=Endereco [uf=SP, cidade=São Paulo, bairro=Vila Formosa, logradouro=casa 2, numero=5214, cep=02312122]," +
            " contato=Contato [email=contmatic@contmatic.com.br, telefone=Telefone [ddd=11, numero=987654321]]," +
            " funcionario=Funcionario [nome=Jorge Luiz, sobreNome=Migliavacca, dataNascimento=1996-06-24, cpf=44188533838," +
            " contato=Contato [email=jorge.guglielmini@usp.br, telefone=Telefone [ddd=11, numero=123456789]], cargo=Programador," + " salario=2000.2, departamento=Departamento [nome=Tecnologia]]]",
            empresa1.toString());

        System.out.println(empresa1);
    }
}
