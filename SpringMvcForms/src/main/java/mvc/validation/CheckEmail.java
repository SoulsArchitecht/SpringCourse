package mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckEmailValidator.class)
public @interface CheckEmail {

    public String value() default "xyz.com";
    public String message() default "email should be ends with xyz.com";

    //позволяет разбивать аннотации по группам
    public Class<?>[] groups() default {};
    //обычно используется для переноса информации о метаданных клиента
    public Class<? extends Payload> [] payload() default {};
}
