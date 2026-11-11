
package com.factory.robot.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotHazardInputTest {

    // Verifies that the constructor initializes all input fields.
    @Test
    void shouldInitializeRobotHazardInput() {

        RobotHazardInput input =
                new RobotHazardInput(0.5, 10, "Critical");

        assertEquals(0.5, input.getArmPrecision(), 0.001);
        assertEquals(10, input.getWorkerDensity());
        assertEquals("Critical", input.getMachineryState());
    }
}
