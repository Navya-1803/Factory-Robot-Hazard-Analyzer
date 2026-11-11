
package com.factory.robot.auditor;

import com.factory.robot.exception.RobotSafetyException;
import com.factory.robot.factory.MachineryRiskFactory;
import com.factory.robot.model.RobotHazardInput;
import com.factory.robot.validation.HazardInputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RobotHazardAuditorTest {

    private RobotHazardAuditor auditor;

    // Initializes the auditor before each test.
    @BeforeEach
    void setUp() {

        auditor = new RobotHazardAuditor(
                new HazardInputValidator(),
                new MachineryRiskFactory()
        );
    }

    // Verifies hazard risk calculation for worn machinery.
    @Test
    void shouldCalculateRiskForWornMachinery()
            throws RobotSafetyException {

        RobotHazardInput input =
                new RobotHazardInput(0.5, 10, "Worn");

        assertEquals(20.5, auditor.calculateHazardRisk(input), 0.001);
    }

    // Verifies hazard risk calculation for faulty machinery.
    @Test
    void shouldCalculateRiskForFaultyMachinery()
            throws RobotSafetyException {

        RobotHazardInput input =
                new RobotHazardInput(0.5, 10, "Faulty");

        assertEquals(27.5, auditor.calculateHazardRisk(input), 0.001);
    }

    // Verifies hazard risk calculation for critical machinery.
    @Test
    void shouldCalculateRiskForCriticalMachinery()
            throws RobotSafetyException {

        RobotHazardInput input =
                new RobotHazardInput(0.5, 10, "Critical");

        assertEquals(37.5, auditor.calculateHazardRisk(input), 0.001);
    }

    // Verifies that invalid arm precision throws a custom exception.
    @Test
    void shouldRejectInvalidArmPrecision() {

        RobotHazardInput input =
                new RobotHazardInput(1.3, 10, "Worn");

        RobotSafetyException exception = assertThrows(
                RobotSafetyException.class,
                () -> auditor.calculateHazardRisk(input)
        );

        assertEquals(
                "Error: Arm precision must be 0.0-1.0",
                exception.getMessage()
        );
    }

    // Verifies that invalid worker density throws a custom exception.
    @Test
    void shouldRejectInvalidWorkerDensity() {

        RobotHazardInput input =
                new RobotHazardInput(0.7, 26, "Critical");

        RobotSafetyException exception = assertThrows(
                RobotSafetyException.class,
                () -> auditor.calculateHazardRisk(input)
        );

        assertEquals(
                "Error: Worker density must be 1-20",
                exception.getMessage()
        );
    }

    // Verifies that unsupported machinery states throw a custom exception.
    @Test
    void shouldRejectUnsupportedMachineryState() {

        RobotHazardInput input =
                new RobotHazardInput(0.3, 14, "Optimal");

        RobotSafetyException exception = assertThrows(
                RobotSafetyException.class,
                () -> auditor.calculateHazardRisk(input)
        );

        assertEquals(
                "Error: Unsupported machinery state",
                exception.getMessage()
        );
    }

    // Verifies that null input is rejected.
    @Test
    void shouldRejectNullInput() {

        RobotSafetyException exception = assertThrows(
                RobotSafetyException.class,
                () -> auditor.calculateHazardRisk(null)
        );

        assertEquals(
                "Error: Robot hazard input cannot be null",
                exception.getMessage()
        );
    }

    // Verifies that boundary values are accepted.
    @Test
    void shouldAcceptBoundaryValues() throws RobotSafetyException {

        RobotHazardInput input =
                new RobotHazardInput(1.0, 20, "Critical");

        assertEquals(60.0, auditor.calculateHazardRisk(input), 0.001);
    }

    // Verifies that non-finite arm precision values are rejected.
    @Test
    void shouldRejectNonFiniteArmPrecision() {

        RobotHazardInput input =
                new RobotHazardInput(Double.NaN, 10, "Worn");

        assertThrows(
                RobotSafetyException.class,
                () -> auditor.calculateHazardRisk(input)
        );
    }
}
