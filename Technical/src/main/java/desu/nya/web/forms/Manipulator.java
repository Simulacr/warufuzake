package desu.nya.web.forms;

import desu.nya.services.GenericService;
import desu.nya.shared.rights.AuthorityRole;

/**
 * User: Simulacr
 * Date: 15.10.14
 * Time: 18:41
 */
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Documented
@org.springframework.stereotype.Component
public @interface Manipulator {
  java.lang.String value() default "";
  Class listForm() default GenericListForm.class;
  Class editForm() default GenericUpdateForm.class;
  Class service() default GenericService.class;
  AuthorityRole level() default AuthorityRole.ROLE_USER;
}
