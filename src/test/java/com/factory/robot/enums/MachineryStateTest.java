
package com.factory.robot.enums;

import com.factory.robot.exception.RobotSafetyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MachineryStateTest {

    // Verifies the risk factor associated with worn machinery.
    @Test
    void shouldReturnRiskFactorForWorn() {

        assertEquals(1.3, MachineryState.Worn.getRiskFactor(), 0.001);
    }

    // Verifies the risk factor associated with faulty machinery.
    @Test
    void shouldReturnRiskFactorForFaulty() {

        assertEquals(2.0, MachineryState.Faulty.getRiskFactor(), 0.001);
    }

    // Verifies the risk factor associated with critical machinery.
    @Test
    void shouldReturnRiskFactorForCritical() {

        assertEquals(3.0, MachineryState.Critical.getRiskFactor(), 0.001);
    }

    // Verifies conversion of a valid String into an enum constant.
    @Test
    void shouldConvertValidStringToMachineryState() throws RobotSafetyException {

        MachineryState state = MachineryState.fromString("Critical");

        assertEquals(MachineryState.Critical, state);
    }

    // Verifies that unsupported machinery states throw a custom exception.
    @Test
    void shouldRejectUnsupportedMachineryState() {

        RobotSafetyException exception = assertThrows(
                RobotSafetyException.class,
                () -> MachineryState.fromString("Optimal")
        );

        assertEquals(
                "Error: Unsupported machinery state",
                exception.getMessage()
        );
    }

    // Verifies that machinery state conversion is case-sensitive.
    @Test
    void shouldRejectLowercaseMachineryState() {

        RobotSafetyException exception = assertThrows(
                RobotSafetyException.class,
                () -> MachineryState.fromString("worn")
        );

        assertEquals(
                "Error: Unsupported machinery state",
                exception.getMessage()
        );
    }

    // Verifies that null machinery state is rejected.
    @Test
    void shouldRejectNullMachineryState() {

        RobotSafetyException exception = assertThrows(
                RobotSafetyException.class,
                () -> MachineryState.fromString(null)
        );

        assertEquals(
                "Error: Unsupported machinery state",
                exception.getMessage()
        );
    }
}
