package com.mapbefine.mapbefine.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Transactional
@DataJpaTest(
        includeFilters = @Filter(
                type = FilterType.ANNOTATION, value = Service.class
        ),
        excludeFilters = @Filter(
                type = FilterType.REGEX,
                pattern = "com.mapbefine.mapbefine.oauth.application.*"
        )
)
public @interface ServiceTest {
}
