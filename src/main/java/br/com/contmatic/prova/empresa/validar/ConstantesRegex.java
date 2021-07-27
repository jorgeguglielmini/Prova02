package br.com.contmatic.prova.empresa.validar;

public final class ConstantesRegex {

    private ConstantesRegex() {
    }
    
    
    public static final String VALIDACAO_NUMERO_TELEFONE = "^[1-9]{1}[0-9]{7,8}";
    public static final String VALIDACAO_NOME_DEPARTAMENTO = "^([A-ZÁÚ]{1}[a-zãõáíóúâêôç0-9]{1,48}){1}( [A-Z]{0,1}[a-zãõáíóúâêôç0-9]{1,48})*";

}
