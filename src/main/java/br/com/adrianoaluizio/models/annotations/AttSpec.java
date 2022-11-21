package br.com.adrianoaluizio.models.annotations;

import br.com.adrianoaluizio.models.enums.CleanerType;
import br.com.adrianoaluizio.models.enums.FillOrientation;
import br.com.adrianoaluizio.models.enums.Format;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AttSpec {
    int length() default 1;
    FillOrientation orientation() default FillOrientation.RIGHT;
    char fillChar() default ' ';
    String value() default "";
    Format format() default Format.NONE;
    boolean required() default false;
    CleanerType cleanerType() default CleanerType.ACCENTS;
    String reference() default "";
}
