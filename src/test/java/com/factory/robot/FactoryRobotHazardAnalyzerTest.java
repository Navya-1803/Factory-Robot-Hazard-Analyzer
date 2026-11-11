
package com.factory.robot;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactoryRobotHazardAnalyzerTest {

    // Verifies that the application displays the correct message.
    @Test
    void shouldDisplayApplicationName() {

        PrintStream originalOutput = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));

            FactoryRobotHazardAnalyzer.main(new String[]{});

            assertEquals(
                    "Factory Robot Hazard Analyzer"
                            + System.lineSeparator(),
                    output.toString()
            );

        } finally {
            System.setOut(originalOutput);
        }
    }
}
