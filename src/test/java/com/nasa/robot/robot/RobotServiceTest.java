package com.nasa.robot.robot;

import com.nasa.robot.BeanTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@BeanTest
@RunWith(SpringRunner.class)
@Import(RobotService.class)
public class RobotServiceTest {

    @Autowired
    private RobotService robotService;

    @Test
    public void deveRetornarCordenadas(){
        assertEquals("(0, 3, S)", robotService.move(RobotType.MARS, "MMMLL"));
    }
}