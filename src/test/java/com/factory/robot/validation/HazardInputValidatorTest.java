
package com.factory.robot.validation;

import com.factory.robot.enums.MachineryState;
import com.factory.robot.exception.RobotSafetyException;
import com.factory.robot.model.RobotHazardInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HazardInputValidatorTest {

    private final HazardInputValidator validator =
            new HazardInputValidator();

    // Verifies that valid inputs return the correct machinery state.
    @Test
    void shouldValidateAndReturnMachineryState()
            throws RobotSafetyException {

        RobotHazardInput input =
                new RobotHazardInput(0.5, 10, "Critical");

        assertEquals(MachineryState.Critical, validator.validate(input));
    }

    // Verifies that null input is rejected.
    @Test
    void shouldRejectNullInput() {

        assertThrows(
                RobotSafetyException.class,
                () -> validator.validate(null)
        );
    }

    // Verifies that invalid arm precision is rejected.
    @Test
    void shouldRejectInvalidArmPrecision() {

        RobotHazardInput input =
                new RobotHazardInput(-0.5, 10, "Worn");

        assertThrows(
                RobotSafetyException.class,
                () -> validator.validate(input)
        );
    }

    // Verifies that invalid worker density is rejected.
    @Test
    void shouldRejectInvalidWorkerDensity() {

        RobotHazardInput input =
                new RobotHazardInput(0.5, 25, "Worn");

        assertThrows(
                RobotSafetyException.class,
                () -> validator.validate(input)
        );
    }

    // Verifies that unsupported machinery state is rejected.
    @Test
    void shouldRejectUnsupportedMachineryState() {

        RobotHazardInput input =
                new RobotHazardInput(0.5, 10, "Optimal");

        assertThrows(
                RobotSafetyException.class,
                () -> validator.validate(input)
        );
    }

    // Verifies that NaN arm precision is rejected.
    @Test
    void shouldRejectNaNArmPrecision() {

        RobotHazardInput input =
                new RobotHazardInput(Double.NaN, 10, "Worn");

        assertThrows(
                RobotSafetyException.class,
                () -> validator.validate(input)
        );
    }

    // Verifies that infinite arm precision is rejected.
    @Test
    void shouldRejectInfiniteArmPrecision() {

        RobotHazardInput input =
                new RobotHazardInput(Double.POSITIVE_INFINITY, 10, "Worn");

        assertThrows(
                RobotSafetyException.class,
                () -> validator.validate(input)
        );
    }
}
