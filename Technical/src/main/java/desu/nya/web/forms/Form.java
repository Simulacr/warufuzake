package desu.nya.web.forms;

/**
 * User: Simulacr
 * Time: 22.04.2015
 */
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Documented
public @interface Form {
  java.lang.String value();
}
