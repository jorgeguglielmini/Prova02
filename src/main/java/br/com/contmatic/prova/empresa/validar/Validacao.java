package br.com.contmatic.prova.empresa.validar;

import java.math.BigDecimal;

import org.joda.time.LocalDate;

import br.com.contmatic.prova.empresa.Endereco;
import br.com.contmatic.prova.empresa.Telefone;

public class Validacao {

    public static void verificaNulidade(Object obj, String campo) {
        if (obj == null) {
            throw new IllegalArgumentException("O Campo " + campo + " não deve estar nulo.");
        }
    }

    public static void verificaTamanhoEmail(String email) {
        if (email.length() >= 200) {
            throw new IllegalArgumentException("O tamanho deve estar entre 1 e 200 caracteres");
        }
    }

    public static void verificaTamanhoDepartamento(String nome) {
        if (nome.length() <= 0 || nome.length() >= 200) {
            throw new IllegalArgumentException("O tamanho deve estar entre 1 e 200 caracteres");
        }
    }

    public static void assertNotBlank(Object obj, String campo) {
        if (((String) obj).isEmpty()) {
            throw new IllegalArgumentException("O Campo " + campo + "está vazio ou apenas com espaços em branco.");
        }
    }

    @SuppressWarnings("unlikely-arg-type")
    public static void assertNotBlankSalario(BigDecimal parametro) {

        if (parametro.equals(0.0)) {
            throw new IllegalArgumentException("Deve ser inserido um valor diferente de zero no campo salário.");
        }
    }

    public static void verificaEspacoEmBranco(Object obj, String campo) {
        if (((String) obj).charAt(0) == 32) {
            throw new IllegalArgumentException("O Campo " + campo + " não deve ter espaços em branco no começo.");
        }
        if ((((String) obj).charAt((((String) obj).length() - 1)) == 32)) {
            throw new IllegalArgumentException("O Campo " + campo + " não deve ter espaços em branco no final.");
        }
    }

    public static void verificaValidadeDdd(String ddd) {
        for(int i = 0 ; i < Telefone.DDD.length ; i++) {
            if (ddd.equals(Telefone.DDD[i])) {
                return;
            }
        }
        throw new IllegalArgumentException("erro");
    }

    public static void verificaUF(String uf) {
        for(int i = 0 ; i < Endereco.SIGLAS_UF.length ; i++) {
            if (uf.equals(Endereco.SIGLAS_UF[i])) {
                return;
            }
        }
        throw new IllegalArgumentException("Erro");
    }

    public static void verificaTamanhoNome(String nome) {
        if (nome.length() > 50 || nome.length() < 3) {
            throw new IllegalArgumentException("O campo Nome deve conter entre 3 e 50 caracteres");
        }
    }

    public static void verificaTamanhoSobreNome(String sobreNome) {
        if (sobreNome.length() > 50 || sobreNome.length() < 3) {
            throw new IllegalArgumentException("O campo Sobrenome deve conter entre 3 e 50 caracteres");
        }
    }

    public static void verificaTamanhoCidade(String cidade) {
        if (cidade.length() > 110) {
            throw new IllegalArgumentException("O campo Cidade deve conter até 110 caracteres");
        }
    }

    public static void verificaTamanhoNomeFantasia(String nomeFantasia) {
        if (nomeFantasia.length() > 100 || nomeFantasia.length() < 3) {
            throw new IllegalArgumentException("O campo Nome Fantasia deve conter entre 3 e 100 caracteres");
        }
    }

    public static void verificaTamanhoRazaoSocial(String razaoSocial) {
        if (razaoSocial.length() > 100 || razaoSocial.length() < 3) {
            throw new IllegalArgumentException("O campo Razão Social deve conter entre 3 e 100 caracteres");
        }
    }

    public static void verificaTamanhoUf(String uf) {
        if (uf.length() != 2) {
            throw new IllegalArgumentException("O campo UF deve conter dois caracteres");
        }
    }

    public static void verificaTamanhoBairro(String bairro) {
        if (bairro.length() > 110) {
            throw new IllegalArgumentException("O campo Bairro deve conter dois caracteres");
        }
    }

    public static void verificaTamanhoNumeroTelefone(String numero) {
        if (numero.length() != 9 && numero.length() != 8) {
            throw new IllegalArgumentException("O campo Número deve conter oito ou nove dígitos");
        }
    }

    public static void verificaTamanhoNumeroEndereco(String numero) {
        if (numero.length() > 6) {
            throw new IllegalArgumentException("O campo Número deve ser conter até seis dígitos");
        }
    }

    public static void verificaTamanhoCep(String numero) {
        if (numero.length() != 8) {
            throw new IllegalArgumentException("O campo CEP deve conter 8 números");
        }
    }

    public static void verificaTamanhoDdd(String ddd) {
        if (ddd.length() != 2) {
            throw new IllegalArgumentException("O campo DDD deve conter dois dígitos");
        }
    }

    public static void verificaTamanhoLogradouro(String logradouro) {
        if (logradouro.length() > 20) {
            throw new IllegalArgumentException("O campo Logradouro deve conter até 20 caracteres");
        }
    }

    public static void verificaSomenteLetras(String parametro, String campo) {
        for(int n : parametro.toCharArray()) {
            if (!((Character.isAlphabetic(n)))) {
                throw new IllegalArgumentException("O Campo " + campo + " deve receber apenas letras");
            }
        }
    }

    public static void verificaSomenteNumeros(String parametro, String campo) {
        for(int n : parametro.toCharArray()) {
            if ((Character.isAlphabetic(n))) {
                throw new IllegalArgumentException("O Campo " + campo + " deve receber apenas números");
            }
        }
    }

    public static void verificaValidadeData(LocalDate parametro) {

        if (parametro.isAfter(LocalDate.now()) || parametro.equals(LocalDate.now())) {
            throw new IllegalArgumentException("A Data de Nascimento inserida é inválida!");
        }
    }

}
