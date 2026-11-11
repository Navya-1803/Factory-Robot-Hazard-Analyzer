
package com.factory.robot;

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

        // Displays the values entered by the user.
        System.out.println("\nEntered Robot Details:");
        System.out.println("Arm Precision: " + armPrecision);
        System.out.println("Worker Density: " + workerDensity);
        System.out.println("Machinery State: " + machineryState);

        double machineRiskFactor = getMachineRiskFactor(machineryState);

        // Calculates the hazard risk score using the given formula.
        double hazardRisk = ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);

        // Displays the calculated hazard risk score.
        System.out.println("Robot Hazard Risk Score: " + hazardRisk);
    }

    // Returns the risk factor associated with the machinery state.
    private static double getMachineRiskFactor(String machineryState) {

        if (machineryState.equals("Worn")) {
            return 1.3;
        } else if (machineryState.equals("Faulty")) {
            return 2.0;
        } else {
            return 3.0;
        }
    }
}
