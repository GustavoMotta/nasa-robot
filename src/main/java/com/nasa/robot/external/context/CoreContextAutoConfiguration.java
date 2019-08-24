package com.nasa.robot.external.context;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureOrder(-2147483648)
public class CoreContextAutoConfiguration {
    public CoreContextAutoConfiguration() {
    }

    @Bean
    public ContextProvider contextProvider(ApplicationContext context) {
        ContextProvider.setContext(context);
        return new ContextProvider();
    }
}
