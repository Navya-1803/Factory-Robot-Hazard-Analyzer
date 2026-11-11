
package com.factory.robot;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FactoryRobotHazardAnalyzerTest {

    // Verifies the hazard risk calculation for worn machinery.
    @Test
    void shouldCalculateRiskForWornMachinery() {

        String output = executeApplication("0.5\n10\nWorn\n");

        assertTrue(output.contains("Robot Hazard Risk Score: 20.5"));
    }

    // Verifies the hazard risk calculation for faulty machinery.
    @Test
    void shouldCalculateRiskForFaultyMachinery() {

        String output = executeApplication("0.5\n10\nFaulty\n");

        assertTrue(output.contains("Robot Hazard Risk Score: 27.5"));
    }

    // Verifies the hazard risk calculation for critical machinery.
    @Test
    void shouldCalculateRiskForCriticalMachinery() {

        String output = executeApplication("0.5\n10\nCritical\n");

        assertTrue(output.contains("Robot Hazard Risk Score: 37.5"));
    }

    // Executes the application with simulated input and captures its output.
    private String executeApplication(String simulatedInput) {

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        ByteArrayInputStream input = new ByteArrayInputStream(
                simulatedInput.getBytes()
        );

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(input);
            System.setOut(new PrintStream(output));

            FactoryRobotHazardAnalyzer.main(new String[]{});

            return output.toString();

        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }
}
