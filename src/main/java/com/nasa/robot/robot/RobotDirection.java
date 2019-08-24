package com.nasa.robot.robot;

public enum RobotDirection {

    NORTH("N", "WEST", "EAST"),
    WEST("W", "SOUTH", "NORTH"),
    SOUTH("S", "EAST", "WEST"),
    EAST("E", "NORTH", "SOUTH");

    private static final char LEFT = 'L';

    private final String value;

    private final String leftDirection;

    private final String rightDirection;

    RobotDirection(String value, String leftDirection, String rightDirection) {
        this.value = value;
        this.leftDirection = leftDirection;
        this.rightDirection = rightDirection;
    }

    public String getValue() {
        return value;
    }

    public RobotDirection rotateToDirection(char direction) {
        if (LEFT == direction) {
            return RobotDirection.valueOf(leftDirection);
        }
        return RobotDirection.valueOf(rightDirection);
    }
}
