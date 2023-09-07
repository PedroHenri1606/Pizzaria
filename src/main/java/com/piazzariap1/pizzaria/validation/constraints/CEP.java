package com.piazzariap1.pizzaria.validation.constraints;

import com.piazzariap1.pizzaria.validation.CepValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CepValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CEP {

    String message() default "CEP informado é invalido!.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
