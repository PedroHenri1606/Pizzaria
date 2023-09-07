package com.piazzariap1.pizzaria.validation.constraints;

import com.piazzariap1.pizzaria.validation.CpfValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CpfValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CPF {

    String message() default "CPF informado não é válido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
