package br.com.contmatic.prova.empresa.validar;

public final class CnpjValidator {

    private static final int CONTADOR_SEGUNDO_DIGITO_VERIFICADOR = 12;
    private static final int CONTADOR_PRIMEIRO_DIGITO_VERIFICADOR = 11;
    private static final char DIGITO_IGUAL_ZERO = 48;
    private static final int DIVISOR_MODULO_ONZE = 11;
    private static final int PESO_MAXIMO = 10;
    private static final int POSICAO_QUATORZE_CNPJ = 13;
    private static final int POSICAO_TREZE_CNPJ = 12;
    private static final int VALOR_UNITARIO = 1;
    private static final int PESO_CALCULO_CNPJ = 2;
    private static final String QUANTIDADE_DIGITOS_CNPJ_IGUAIS = "CNPJ com todos os dígitos iguais.";
    private static final int POSICAO_CARACTER_ZERO_TABELA_ASC = 48;
    private static final String QUANTIDADE_DIGITOS_CNPJ_INVALIDA = "CNPJ com quantidade de dígitos diferente de 14.";
    private static final String CNPJ_INVALIDO = "CNPJ inválido.";
    private static final int CNPJ_TAMANHO_PADRAO = 14;

    private CnpjValidator() {
    }

    public static void validaCnpj(String cnpj) {
        verificaTamanhoCnpj(cnpj);
        confereDigitosCnpj(cnpj);
        char dig13 = calculaDigitoVerificador(calculaPesoDigitoVerificadorCnpj(cnpj, CONTADOR_PRIMEIRO_DIGITO_VERIFICADOR));
        char dig14 = calculaDigitoVerificador(calculaPesoDigitoVerificadorCnpj(cnpj, CONTADOR_SEGUNDO_DIGITO_VERIFICADOR));
        if ((dig13 != cnpj.charAt(POSICAO_TREZE_CNPJ)) && (dig14 != cnpj.charAt(POSICAO_QUATORZE_CNPJ))) {
            throw new IllegalArgumentException(CNPJ_INVALIDO);
        }
    }

    private static char calculaDigitoVerificador(int somatorioAlgarismosCpnj) {
        int restoDivisaoCnpj = (somatorioAlgarismosCpnj % DIVISOR_MODULO_ONZE);  
        if (restoDivisaoCnpj == 0 || restoDivisaoCnpj == 1) {
            return DIGITO_IGUAL_ZERO;
        }   
        return (char) ((DIVISOR_MODULO_ONZE - restoDivisaoCnpj) + POSICAO_CARACTER_ZERO_TABELA_ASC);
    }

    public static int calculaPesoDigitoVerificadorCnpj(String cnpj, int posicaoDigito) {
        int somatorioAlgarismosCnpj = 0;
        int peso = PESO_CALCULO_CNPJ;
        int algarismoCnpj;
        for(int i = posicaoDigito ; i >= 0 ; i--) {
            algarismoCnpj = (cnpj.charAt(i) - POSICAO_CARACTER_ZERO_TABELA_ASC);
            somatorioAlgarismosCnpj = somatorioAlgarismosCnpj + (algarismoCnpj * peso);
            peso = peso + VALOR_UNITARIO;
            if (peso == PESO_MAXIMO)
                peso = PESO_CALCULO_CNPJ;
        }
        return somatorioAlgarismosCnpj;
    }

    private static void confereDigitosCnpj(String cnpj) {
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222") || cnpj.equals("33333333333333") || cnpj.equals("44444444444444") ||
            cnpj.equals("55555555555555") || cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888") || cnpj.equals("99999999999999")) {
            throw new IllegalArgumentException(QUANTIDADE_DIGITOS_CNPJ_IGUAIS);
        }
    }

    private static void verificaTamanhoCnpj(String cnpj) {
        if (cnpj.length() != CNPJ_TAMANHO_PADRAO) {
            throw new IllegalArgumentException(QUANTIDADE_DIGITOS_CNPJ_INVALIDA);
        }
    }
}
