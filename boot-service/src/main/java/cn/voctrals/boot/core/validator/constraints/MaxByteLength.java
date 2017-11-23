package cn.voctrals.boot.core.validator.constraints;

import cn.voctrals.boot.core.validator.MaxByteLengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = MaxByteLengthValidator.class)
@Documented
public @interface MaxByteLength {

    String message() default "{error.2005}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    int value();

}