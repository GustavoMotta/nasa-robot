package com.nasa.robot.robot.validation;

import com.nasa.robot.mars.MarsRobot;
import com.nasa.robot.robot.validation.VerificaStepsValidosSpec;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class VerificaStepsValidosSpecTest {

    @Test
    public void naoDeveAceitarStepsVazios() {
        MarsRobot robot = mock(MarsRobot.class);
        when(robot.getSteps()).thenReturn("");

        VerificaStepsValidosSpec spec = new VerificaStepsValidosSpec();
        assertFalse(spec.isValid(robot));
        assertEquals("Não foi possível alcançar a posição solicitada", spec.getMessage());
    }

    @Test
    public void naoDeveAceitarStepsNulo() {
        MarsRobot robot = mock(MarsRobot.class);
        when(robot.getSteps()).thenReturn(null);

        VerificaStepsValidosSpec spec = new VerificaStepsValidosSpec();
        assertFalse(spec.isValid(robot));
        assertEquals("Não foi possível alcançar a posição solicitada", spec.getMessage());
    }

    @Test
    public void naoDeveAceitarStepsIvalidos() {
        MarsRobot robot = mock(MarsRobot.class);
        when(robot.getSteps()).thenReturn("MMA");

        VerificaStepsValidosSpec spec = new VerificaStepsValidosSpec();
        assertFalse(spec.isValid(robot));
        assertEquals("Não foi possível alcançar a posição solicitada", spec.getMessage());
    }

    @Test
    public void deveAceitarStepsValidos() {
        MarsRobot robot = mock(MarsRobot.class);
        when(robot.getSteps()).thenReturn("MMRL");

        VerificaStepsValidosSpec spec = new VerificaStepsValidosSpec();
        assertTrue(spec.isValid(robot));
    }
}