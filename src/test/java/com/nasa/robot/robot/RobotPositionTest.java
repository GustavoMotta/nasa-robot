package com.nasa.robot.robot;

import com.nasa.robot.BeanTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ValidationException;

import static org.junit.Assert.assertEquals;

@BeanTest
@RunWith(SpringRunner.class)
public class RobotPositionTest {

    @Test
    public void deveIniciarPosicao0x0xN() {
        assertEquals("(0, 0, N)", RobotPosition.init().toString());
    }

    @Test
    public void deveMovimentarPara2x0xS() {
        RobotPosition robot = RobotPosition.Builder.create()
                .steps("RMMR")
                .build();

        assertEquals("(2, 0, S)", robot
                .toString());

        assertEquals(RobotDirection.SOUTH, robot.getDirection());
    }

    @Test(expected = ValidationException.class)
    public void naoDeveMovimentarForaTerreno() {
        RobotPosition.Builder.create()
                .steps("LMM")
                .build();
    }

}