package com.nasa.robot.robot;

import com.nasa.robot.external.validation.Validable;

public interface Robot extends Validable {

    String getCoordinates();

    String getSteps();

}
