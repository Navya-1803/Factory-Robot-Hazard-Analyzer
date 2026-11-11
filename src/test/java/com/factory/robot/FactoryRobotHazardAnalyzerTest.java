
package com.factory.robot;

import com.factory.robot.exception.RobotSafetyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactoryRobotHazardAnalyzerTest {

    // Verifies hazard risk calculation for worn machinery.
    @Test
    void shouldCalculateRiskForWornMachinery() throws RobotSafetyException {

        double risk = FactoryRobotHazardAnalyzer.calculateHazardRisk(
                0.5, 10, "Worn"
        );

        assertEquals(20.5, risk, 0.001);
    }

    // Verifies hazard risk calculation for faulty machinery.
    @Test
    void shouldCalculateRiskForFaultyMachinery() throws RobotSafetyException {

        double risk = FactoryRobotHazardAnalyzer.calculateHazardRisk(
                0.5, 10, "Faulty"
        );

        assertEquals(27.5, risk, 0.001);
    }

    // Verifies hazard risk calculation for critical machinery.
    @Test
    void shouldCalculateRiskForCriticalMachinery() throws RobotSafetyException {

        double risk = FactoryRobotHazardAnalyzer.calculateHazardRisk(
                0.5, 10, "Critical"
        );

        assertEquals(37.5, risk, 0.001);
    }

    // Verifies that invalid arm precision throws a custom exception.
    @Test
    void shouldThrowExceptionForInvalidArmPrecision() {

        RobotSafetyException exception = assertThrows(
                RobotSafetyException.class,
                () -> FactoryRobotHazardAnalyzer.calculateHazardRisk(
                        1.3, 10, "Worn"
                )
        );

        assertEquals(
                "Error: Arm precision must be 0.0-1.0",
                exception.getMessage()
        );
    }

    // Verifies that invalid worker density throws a custom exception.
    @Test
    void shouldThrowExceptionForInvalidWorkerDensity() {

        RobotSafetyException exception = assertThrows(
                RobotSafetyException.class,
                () -> FactoryRobotHazardAnalyzer.calculateHazardRisk(
                        0.7, 26, "Critical"
                )
        );

        assertEquals(
                "Error: Worker density must be 1-20",
                exception.getMessage()
        );
    }

    // Verifies that unsupported machinery states throw a custom exception.
    @Test
    void shouldThrowExceptionForUnsupportedMachineryState() {

        RobotSafetyException exception = assertThrows(
                RobotSafetyException.class,
                () -> FactoryRobotHazardAnalyzer.calculateHazardRisk(
                        0.3, 14, "Optimal"
                )
        );

        assertEquals(
                "Error: Unsupported machinery state",
                exception.getMessage()
        );
    }

    // Verifies that boundary values are accepted.
    @Test
    void shouldAcceptBoundaryValues() throws RobotSafetyException {

        double risk = FactoryRobotHazardAnalyzer.calculateHazardRisk(
                1.0, 20, "Critical"
        );

        assertEquals(60.0, risk, 0.001);
    }
}
