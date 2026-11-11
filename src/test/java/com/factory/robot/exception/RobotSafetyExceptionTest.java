
package com.factory.robot.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class RobotSafetyExceptionTest {

    // Verifies that the custom exception stores its error message.
    @Test
    void shouldStoreCustomExceptionMessage() {

        String message = "Error: Worker density must be 1-20";

        RobotSafetyException exception =
                new RobotSafetyException(message);

        assertEquals(message, exception.getMessage());
    }

    // Verifies that the custom exception inherits from Exception.
    @Test
    void shouldExtendExceptionClass() {

        RobotSafetyException exception =
                new RobotSafetyException("Robot safety error");

        assertInstanceOf(Exception.class, exception);
    }
}
