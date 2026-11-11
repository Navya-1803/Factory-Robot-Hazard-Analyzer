
package com.factory.robot.auditor;

import com.factory.robot.enums.MachineryState;
import com.factory.robot.exception.RobotSafetyException;
import com.factory.robot.factory.MachineryRiskFactory;
import com.factory.robot.model.RobotHazardInput;
import com.factory.robot.strategy.MachineryRiskStrategy;
import com.factory.robot.validation.HazardInputValidator;

public class RobotHazardAuditor {

    private final HazardInputValidator validator;
    private final MachineryRiskFactory riskFactory;

    // Initializes the auditor with its required dependencies.
    public RobotHazardAuditor(
            HazardInputValidator validator,
            MachineryRiskFactory riskFactory) {

        this.validator = validator;
        this.riskFactory = riskFactory;
    }

    // Validates robot inputs and calculates the hazard risk score.
    public double calculateHazardRisk(RobotHazardInput input)
            throws RobotSafetyException {

        MachineryState state = validator.validate(input);

        MachineryRiskStrategy strategy =
                riskFactory.createStrategy(state);

        double machineRiskFactor = strategy.getRiskFactor();

        // Calculates the hazard risk using the given formula.
        return ((1.0 - input.getArmPrecision()) * 15.0)
                + (input.getWorkerDensity() * machineRiskFactor);
    }
}
