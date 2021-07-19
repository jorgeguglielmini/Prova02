package br.com.contmatic.prova.empresa.validar;

public final class CpfValidator {

    private static final int POSICAO_ONZE_CPF = 10;
    private static final int DIVISOR_MODULO_DEZ = 10;
    private static final int DIVISOR_MODULO_ONZE = 11;
    private static final int POSICAO_DEZ_CPF = 9;
    private static final String QUANTIDADE_DIGITOS_CPF_IGUAIS = "CPF com todos os dígitos iguais.";
    private static final String QUANTIDADE_DIGITOS_CPF_INVALIDA = "CPF com quantidade diferente de 11 dígitos.";
    private static final int VALOR_UNITARIO = 1;
    private static final String CPF_INVALIDO = "CPF inválido.";
    private static final int PESO_CALCULO_CPF_PRIMEIRO_DIGITO = 10;
    private static final int PESO_CALCULO_CPF_SEGUNDO_DIGITO = 11;
    private static final int POSICAO_CARACTER_ZERO_TABELA_ASC = 48;
    private static final int CPF_TAMANHO_PADRAO = 11;

    private CpfValidator() {
    }

    public static void validaCpf(String cpf) {
        verificaTamanhoCpf(cpf);
        confereDigitosCpf(cpf);
        char dig10 = calculaDigitoVerificador(calculaPesoDigitoVerificador(cpf, POSICAO_DEZ_CPF));
        char dig11 = calculaDigitoVerificador(calculaPesoDigitoVerificador(cpf, POSICAO_ONZE_CPF));
        if ((dig10 != cpf.charAt(POSICAO_DEZ_CPF)) || (dig11 != cpf.charAt(POSICAO_ONZE_CPF))) {
            throw new IllegalArgumentException(CPF_INVALIDO);
        }
    }

    private static char calculaDigitoVerificador(int somatorioAlgarismosCpf) {
        int restoDivisaoCpf = DIVISOR_MODULO_ONZE - (somatorioAlgarismosCpf % DIVISOR_MODULO_ONZE);
        return (char) (((restoDivisaoCpf % DIVISOR_MODULO_ONZE) % DIVISOR_MODULO_DEZ) + POSICAO_CARACTER_ZERO_TABELA_ASC);
    }

    public static int calculaPesoDigitoVerificador(String cpf, int posicaoDigito) {
        int somatorioAlgarismosCpf = 0;
        int algarismoCpf = 0;
        int peso = posicaoDigito == POSICAO_DEZ_CPF ? PESO_CALCULO_CPF_PRIMEIRO_DIGITO : PESO_CALCULO_CPF_SEGUNDO_DIGITO;
        for(int i = 0 ; i < posicaoDigito ; i++) {
            algarismoCpf = (cpf.charAt(i) - POSICAO_CARACTER_ZERO_TABELA_ASC);
            somatorioAlgarismosCpf = somatorioAlgarismosCpf + (algarismoCpf * peso);
            peso = peso - VALOR_UNITARIO;
        }
        return somatorioAlgarismosCpf;
    }

    private static void confereDigitosCpf(String cpf) {
        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999")) {
            throw new IllegalArgumentException(QUANTIDADE_DIGITOS_CPF_IGUAIS);
        }
    }

    private static void verificaTamanhoCpf(String cpf) {
        if (cpf.length() != CPF_TAMANHO_PADRAO) {
            throw new IllegalArgumentException(QUANTIDADE_DIGITOS_CPF_INVALIDA);
        }
    }
}
