package com.nasa.robot.external.validation;

import org.springframework.stereotype.Component;

import javax.validation.ValidationException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class SpecValidator {

    @SafeVarargs
    public final <T extends Validable> void run(T validable, Spec<T>... specs) {
        if (specs == null || specs.length == 0) {
            return;
        }

        String messages = Stream.of(specs)
                .filter(spec -> !spec.isValid(validable))
                .map(Spec::getMessage)
                .collect(Collectors.joining(", "));

        if (messages != null && messages.length() > 0) {
            throw new ValidationException(messages);
        }
    }
}
