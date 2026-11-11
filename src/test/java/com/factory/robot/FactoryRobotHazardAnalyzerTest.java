
package com.factory.robot;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FactoryRobotHazardAnalyzerTest {

    // Verifies that the application displays the calculated risk score.
    @Test
    void shouldDisplayHazardRiskScore() {

        String output = executeApplication("0.5\n10\nCritical\n");

        assertTrue(output.contains("Robot Hazard Risk Score: 37.5"));
    }

    // Verifies that the application displays custom exception messages.
    @Test
    void shouldDisplayValidationError() {

        String output = executeApplication("1.3\n10\nWorn\n");

        assertTrue(output.contains(
                "Error: Arm precision must be 0.0-1.0"
        ));
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
