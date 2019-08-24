package com.nasa.robot.robot;

import com.nasa.robot.mars.MarsRobot;

public enum RobotType {

    MARS() {
        @Override
        public Robot getRobot(String steps) {
            return MarsRobot.Builder.create()
                    .steps(steps)
                    .build();
        }
    };

    public abstract Robot getRobot(String steps);
}