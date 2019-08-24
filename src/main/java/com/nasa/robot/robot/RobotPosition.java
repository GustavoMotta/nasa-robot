package com.nasa.robot.robot;

import com.nasa.robot.external.model.AbstractBuilder;
import com.nasa.robot.external.validation.SpecValidator;
import com.nasa.robot.external.validation.Validable;
import com.nasa.robot.robot.validation.VerificaPosicaoFinalSpec;

public class RobotPosition implements Validable {

    private static final String FORMAT = "(%d, %d, %s)";

    private int x;

    private int y;

    private RobotDirection direction;

    public static RobotPosition init() {
        RobotPosition robotPosition = new RobotPosition();
        robotPosition.direction = RobotDirection.NORTH;
        return robotPosition;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public RobotDirection getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return String.format(FORMAT, x, y, direction.getValue());
    }

    public void move(String steps) {
        for (char step : steps.toCharArray()) {
            move(step);
        }
    }

    public void move(char step) {
        if (step != 'M') {
            this.direction = direction.rotateToDirection(step);
            return;
        }

        switch (direction) {
            case EAST:
                x++;
                break;
            case WEST:
                x--;
                break;
            case SOUTH:
                y--;
                break;
            default:
                y++;
        }
    }

    public static final class Builder extends AbstractBuilder<RobotPosition> {

        private Builder(RobotPosition robot) {
            super(robot);
        }

        public static Builder create() {
            return new Builder(RobotPosition.init());
        }

        @Override
        protected void validate(SpecValidator validator) {
            super.validate(validator);
            validator.run(bean, new VerificaPosicaoFinalSpec());
        }

        public Builder steps(String steps) {
            bean.move(steps);
            return this;
        }
    }
}
