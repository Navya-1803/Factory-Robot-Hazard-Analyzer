
package com.factory.robot;

import com.factory.robot.auditor.RobotHazardAuditor;
import com.factory.robot.exception.RobotSafetyException;
import com.factory.robot.factory.MachineryRiskFactory;
import com.factory.robot.model.RobotHazardInput;
import com.factory.robot.validation.HazardInputValidator;

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

        RobotHazardInput input = new RobotHazardInput(
                armPrecision,
                workerDensity,
                machineryState
        );

        HazardInputValidator validator = new HazardInputValidator();

        MachineryRiskFactory riskFactory = new MachineryRiskFactory();

        RobotHazardAuditor auditor = new RobotHazardAuditor(
                validator,
                riskFactory
        );

        try {

            // Calculates the hazard risk score.
            double hazardRisk = auditor.calculateHazardRisk(input);

            System.out.println("Robot Hazard Risk Score: " + hazardRisk);

        } catch (RobotSafetyException exception) {

            // Displays the custom exception message.
            System.out.println(exception.getMessage());
        }
    }
}
