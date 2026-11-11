
package com.factory.robot;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FactoryRobotHazardAnalyzerTest {

    // Verifies that the application displays its name and accepts robot inputs.
    @Test
    void shouldAcceptAndDisplayRobotInputs() {

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        ByteArrayInputStream input = new ByteArrayInputStream(
                "0.5\n10\nCritical\n".getBytes()
        );

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(input);
            System.setOut(new PrintStream(output));

            FactoryRobotHazardAnalyzer.main(new String[]{});

            String actualOutput = output.toString();

            assertTrue(actualOutput.contains(
                    "Factory Robot Hazard Analyzer"
            ));

            assertTrue(actualOutput.contains("Arm Precision: 0.5"));

            assertTrue(actualOutput.contains("Worker Density: 10"));

            assertTrue(actualOutput.contains("Machinery State: Critical"));

        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }
}
