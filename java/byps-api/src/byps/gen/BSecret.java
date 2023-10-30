package byps.gen;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Members or parameters declared with this annotation are not included in {@link Object#toString()}.
 * BYPS_63
 */
@Retention(RUNTIME)
@Target({ PARAMETER, METHOD })
public @interface BSecret {

}
