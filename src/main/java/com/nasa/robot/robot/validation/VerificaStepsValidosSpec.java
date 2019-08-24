package com.nasa.robot.robot.validation;

import com.nasa.robot.external.validation.Spec;
import com.nasa.robot.robot.Robot;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public class VerificaStepsValidosSpec implements Spec<Robot> {

    private static final String VALID_STEPS_PATTERN = "[LRM]*";

    private static final String MESSAGE = "Não foi possível alcançar a posição solicitada";

    @Override
    public boolean isValid(Robot validable) {
        String steps = validable.getSteps();
        return !StringUtils.isEmpty(steps) && Pattern.matches(VALID_STEPS_PATTERN, steps);
    }

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
