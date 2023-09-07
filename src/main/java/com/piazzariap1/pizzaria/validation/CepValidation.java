package com.piazzariap1.pizzaria.validation;

import com.piazzariap1.pizzaria.validation.constraints.CEP;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CepValidation implements ConstraintValidator<CEP,String> {

    @Override
    public void initialize(CEP constraintsAnnotation){ConstraintValidator.super.initialize(constraintsAnnotation);}

    @Override
    public boolean isValid(String cep, ConstraintValidatorContext constraintValidatorContext){
        if(cep.equals("00000000") || cep.equals("33333333") || cep.equals("66666666") || cep.equals("88888888") ||
           cep.equals("11111111") || cep.equals("44444444") || cep.equals("77777777") || cep.equals("99999999") ||
           cep.equals("22222222") || cep.equals("55555555") || (cep.length() != 7)) {

            return (false);
        }

        try {
            cep = cep.replaceAll("\\\\d{8}|\\\\d{5}-\\\\d{3}"," ");
            return (true);
        } catch (Exception erro){
            return (false);
        }

    }
}
