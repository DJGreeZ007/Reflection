import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The AutoInjectable annotation indicates that a field should be automatically injected with a dependency.
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface AutoInjectable {}