package com.nasa.robot.external.context;

import org.springframework.context.ApplicationContext;

import static java.util.Objects.requireNonNull;

public class ContextProvider {

    private static ApplicationContext context;

    public static void setContext(ApplicationContext context) {
        ContextProvider.context = context;
    }

    public static <T> T getBean(Class<T> type) {
        requireNonNull(type, "classe não pode ser nulo");
        requireNonNull(context, "contexto não inicializado");
        return context.getBean(type);
    }
}
