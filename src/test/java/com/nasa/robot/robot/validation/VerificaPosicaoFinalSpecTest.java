package com.nasa.robot.robot.validation;

import com.nasa.robot.robot.RobotPosition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class VerificaPosicaoFinalSpecTest {

    @Test
    public void naoDeveAceitarForaTerreno5x5YNegativo() {
        RobotPosition position = mock(RobotPosition.class);
        when(position.getX()).thenReturn(2);
        when(position.getY()).thenReturn(-1);

        VerificaPosicaoFinalSpec spec = new VerificaPosicaoFinalSpec();

        assertFalse(spec.isValid(position));
        assertEquals("Não foi possível alcançar a posição solicitada", spec.getMessage());
    }

    @Test
    public void naoDeveAceitarForaTerreno5x5XMaior4() {
        RobotPosition position = mock(RobotPosition.class);
        when(position.getX()).thenReturn(5);
        when(position.getY()).thenReturn(1);

        VerificaPosicaoFinalSpec spec = new VerificaPosicaoFinalSpec();

        assertFalse(spec.isValid(position));
        assertEquals("Não foi possível alcançar a posição solicitada", spec.getMessage());
    }

    @Test
    public void deveAceitarDentroTerreno5x5() {
        RobotPosition position = mock(RobotPosition.class);
        when(position.getX()).thenReturn(4);
        when(position.getY()).thenReturn(1);

        VerificaPosicaoFinalSpec spec = new VerificaPosicaoFinalSpec();

        assertTrue(spec.isValid(position));
    }

}