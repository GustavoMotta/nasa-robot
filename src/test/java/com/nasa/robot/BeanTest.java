package com.nasa.robot;

import com.nasa.robot.external.context.CoreContextAutoConfiguration;
import com.nasa.robot.external.validation.SpecValidator;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;

import java.lang.annotation.*;

@Inherited
@DirtiesContext
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({CoreContextAutoConfiguration.class, SpecValidator.class})
public @interface BeanTest {
}
