
package com.factory.robot.enums;

import com.factory.robot.exception.RobotSafetyException;

public enum MachineryState {

    Worn(1.3),
    Faulty(2.0),
    Critical(3.0);

    private final double riskFactor;

    // Initializes each machinery state with its risk factor.
    MachineryState(double riskFactor) {
        this.riskFactor = riskFactor;
    }

    // Returns the risk factor associated with the machinery state.
    public double getRiskFactor() {
        return riskFactor;
    }

    // Converts a String into a supported machinery state.
    public static MachineryState fromString(String state)
            throws RobotSafetyException {

        try {
            return MachineryState.valueOf(state);

        } catch (IllegalArgumentException | NullPointerException exception) {

            throw new RobotSafetyException(
                    "Error: Unsupported machinery state"
            );
        }
    }
}
