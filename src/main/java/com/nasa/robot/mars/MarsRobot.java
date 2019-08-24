package com.nasa.robot.mars;

import com.nasa.robot.external.model.AbstractBuilder;
import com.nasa.robot.external.validation.SpecValidator;
import com.nasa.robot.robot.Robot;
import com.nasa.robot.robot.RobotPosition;
import com.nasa.robot.robot.validation.VerificaStepsValidosSpec;

public class MarsRobot implements Robot {

    private RobotPosition robotPosition = RobotPosition.init();

    private String steps;

    private MarsRobot() {

    }

    @Override
    public String getCoordinates() {
        return robotPosition.toString();
    }

    public String getSteps() {
        return steps;
    }

    public static final class Builder extends AbstractBuilder<MarsRobot> {

        private Builder(MarsRobot robot) {
            super(robot);
        }

        public static Builder create() {
            return new Builder(new MarsRobot());
        }

        @Override
        protected void validateBeforeBuild(SpecValidator validator) {
            super.validate(validator);
            validator.run(bean, new VerificaStepsValidosSpec());
        }

        @Override
        protected MarsRobot doBuild() {
            bean.robotPosition = RobotPosition.Builder.create()
                    .steps(bean.getSteps())
                    .build();
            return super.doBuild();
        }

        public Builder steps(String steps) {
            bean.steps = steps;
            return this;
        }
    }

}
