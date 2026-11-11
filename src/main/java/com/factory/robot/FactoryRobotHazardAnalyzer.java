
package com.factory.robot;

import com.factory.robot.enums.MachineryState;
import com.factory.robot.exception.RobotSafetyException;

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    // Starts the factory robot hazard analyzer application.
    public static void main(String[] args) {

        System.out.println("Factory Robot Hazard Analyzer");

        Scanner scanner = new Scanner(System.in);

        // Accepts arm precision from the user.
        System.out.println("Enter Arm Precision:");
        double armPrecision = scanner.nextDouble();

        // Accepts worker density from the user.
        System.out.println("Enter Worker Density:");
        int workerDensity = scanner.nextInt();

        scanner.nextLine();

        // Accepts machinery state from the user.
        System.out.println("Enter Machinery State:");
        String machineryState = scanner.nextLine();

        try {

            // Calculates the hazard risk score.
            double hazardRisk = calculateHazardRisk(
                    armPrecision,
                    workerDensity,
                    machineryState
            );

            System.out.println("Robot Hazard Risk Score: " + hazardRisk);

        } catch (RobotSafetyException exception) {

            // Displays the custom exception message.
            System.out.println(exception.getMessage());
        }
    }

    // Validates inputs and calculates the hazard risk score.
    public static double calculateHazardRisk(
            double armPrecision,
            int workerDensity,
            String machineryState)
            throws RobotSafetyException {

        // Validates arm precision.
        if (armPrecision < 0.0 || armPrecision > 1.0) {

            throw new RobotSafetyException(
                    "Error: Arm precision must be 0.0-1.0"
            );
        }

        // Validates worker density.
        if (workerDensity < 1 || workerDensity > 20) {

            throw new RobotSafetyException(
                    "Error: Worker density must be 1-20"
            );
        }

        // Converts the machinery state into an enum.
        MachineryState state = MachineryState.fromString(machineryState);

        double machineRiskFactor = state.getRiskFactor();

        // Calculates the hazard risk using the given formula.
        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }
}
