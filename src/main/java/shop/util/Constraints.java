package shop.util;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

public class Constraints {
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @NotNull
    @Digits(fraction = 0, integer = 10)
    public @interface NumberReqParam {
        @AliasFor("name")
        String value() default "";

        @AliasFor("value")
        String name() default "";

        boolean required() default true;

        String defaultValue() default "\n\t\t\n\t\t\n\ue000\ue001\ue002\n\t\t\t\t\n";
    }

}
