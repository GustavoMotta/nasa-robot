package com.nasa.robot.mars;

import com.nasa.robot.robot.RobotService;
import com.nasa.robot.robot.RobotType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mars")
public class MarsController {

    private final RobotService robotService;

    public MarsController(RobotService robotService) {
        this.robotService = robotService;
    }

    @PostMapping("/{steps}")
    public ResponseEntity move(@PathVariable("steps") String steps) {
        return ResponseEntity.ok(robotService.move(RobotType.MARS, steps));
    }

}
