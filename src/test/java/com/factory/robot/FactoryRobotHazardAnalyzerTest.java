
package com.factory.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactoryRobotHazardAnalyzerTest {

    // Verifies hazard risk calculation for worn machinery.
    @Test
    void shouldCalculateRiskForWornMachinery() {

        double risk = FactoryRobotHazardAnalyzer.calculateHazardRisk(
                0.5, 10, "Worn"
        );

        assertEquals(20.5, risk, 0.001);
    }

    // Verifies hazard risk calculation for faulty machinery.
    @Test
    void shouldCalculateRiskForFaultyMachinery() {

        double risk = FactoryRobotHazardAnalyzer.calculateHazardRisk(
                0.5, 10, "Faulty"
        );

        assertEquals(27.5, risk, 0.001);
    }

    // Verifies hazard risk calculation for critical machinery.
    @Test
    void shouldCalculateRiskForCriticalMachinery() {

        double risk = FactoryRobotHazardAnalyzer.calculateHazardRisk(
                0.5, 10, "Critical"
        );

        assertEquals(37.5, risk, 0.001);
    }

    // Verifies that invalid arm precision is rejected.
    @Test
    void shouldRejectInvalidArmPrecision() {

        double risk = FactoryRobotHazardAnalyzer.calculateHazardRisk(
                1.3, 10, "Worn"
        );

        assertEquals(-1.0, risk);
    }

    // Verifies that invalid worker density is rejected.
    @Test
    void shouldRejectInvalidWorkerDensity() {

        double risk = FactoryRobotHazardAnalyzer.calculateHazardRisk(
                0.7, 26, "Critical"
        );

        assertEquals(-1.0, risk);
    }

    // Verifies that unsupported machinery states are rejected.
    @Test
    void shouldRejectUnsupportedMachineryState() {

        double risk = FactoryRobotHazardAnalyzer.calculateHazardRisk(
                0.3, 14, "Optimal"
        );

        assertEquals(-1.0, risk);
    }

    // Verifies that boundary values are accepted.
    @Test
    void shouldAcceptBoundaryValues() {

        double risk = FactoryRobotHazardAnalyzer.calculateHazardRisk(
                1.0, 20, "Critical"
        );

        assertEquals(60.0, risk, 0.001);
    }
}
