
package com.factory.robot.enums;

import com.factory.robot.exception.RobotSafetyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MachineryStateTest {

    // Verifies conversion of the worn machinery state.
    @Test
    void shouldConvertWornState() throws RobotSafetyException {

        assertEquals(
                MachineryState.Worn,
                MachineryState.fromString("Worn")
        );
    }

    // Verifies conversion of the faulty machinery state.
    @Test
    void shouldConvertFaultyState() throws RobotSafetyException {

        assertEquals(
                MachineryState.Faulty,
                MachineryState.fromString("Faulty")
        );
    }

    // Verifies conversion of the critical machinery state.
    @Test
    void shouldConvertCriticalState() throws RobotSafetyException {

        assertEquals(
                MachineryState.Critical,
                MachineryState.fromString("Critical")
        );
    }

    // Verifies that unsupported machinery states are rejected.
    @Test
    void shouldRejectUnsupportedState() {

        assertThrows(
                RobotSafetyException.class,
                () -> MachineryState.fromString("Optimal")
        );
    }

    // Verifies that machinery state conversion is case-sensitive.
    @Test
    void shouldRejectLowercaseState() {

        assertThrows(
                RobotSafetyException.class,
                () -> MachineryState.fromString("worn")
        );
    }

    // Verifies that null machinery state is rejected.
    @Test
    void shouldRejectNullState() {

        assertThrows(
                RobotSafetyException.class,
                () -> MachineryState.fromString(null)
        );
    }
}
