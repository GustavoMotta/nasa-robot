package com.nasa.robot.robot.validation;

import com.nasa.robot.external.validation.Spec;
import com.nasa.robot.robot.RobotPosition;

public class VerificaPosicaoFinalSpec implements Spec<RobotPosition> {

    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;
    private static final int MAX_X = 4;
    private static final int MAX_Y = 4;

    private static final String MESSAGE = "Não foi possível alcançar a posição solicitada";

    @Override
    public boolean isValid(RobotPosition validable) {
        int x = validable.getX();
        int y = validable.getY();
        return x >= MIN_X && x <= MAX_X && y >= MIN_Y && y <= MAX_Y;
    }

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
