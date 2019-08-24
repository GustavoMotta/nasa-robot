package com.nasa.robot.mars;

import com.nasa.robot.BeanTest;
import com.nasa.robot.robot.Robot;
import com.nasa.robot.robot.RobotType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ValidationException;

import static org.junit.Assert.assertEquals;

@BeanTest
@RunWith(SpringRunner.class)
public class MarsRobotTest {

    @Test
    public void deveMoverRobo() {
        Robot robot = RobotType.MARS.getRobot("MML");
        assertEquals("(0, 2, W)", robot.getCoordinates());
    }

    @Test(expected = ValidationException.class)
    public void naoDeveMoverRobo() {
        RobotType.MARS.getRobot("MMLA");
    }

}