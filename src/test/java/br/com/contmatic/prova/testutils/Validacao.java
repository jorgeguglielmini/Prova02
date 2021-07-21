package br.com.contmatic.prova.testutils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Validacao {

    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private static Validator validator = validatorFactory.getValidator();

    public static boolean Valida(Object obj) {
        Set<ConstraintViolation<Object>> violacoes = validator.validate(obj);
        return violacoes.isEmpty();
    }

}
