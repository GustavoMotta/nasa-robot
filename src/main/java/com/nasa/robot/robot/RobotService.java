package com.nasa.robot.robot;

import org.springframework.stereotype.Component;

@Component
public class RobotService {

    public String move(RobotType type, String steps) {
        return type.getRobot(steps).getCoordinates();
    }
}
