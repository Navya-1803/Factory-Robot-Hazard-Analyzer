
package com.factory.robot.model;

public class RobotHazardInput {

    private final double armPrecision;
    private final int workerDensity;
    private final String machineryState;

    // Initializes robot hazard input details.
    public RobotHazardInput(
            double armPrecision,
            int workerDensity,
            String machineryState) {

        this.armPrecision = armPrecision;
        this.workerDensity = workerDensity;
        this.machineryState = machineryState;
    }

    // Returns arm precision.
    public double getArmPrecision() {
        return armPrecision;
    }

    // Returns worker density.
    public int getWorkerDensity() {
        return workerDensity;
    }

    // Returns machinery state.
    public String getMachineryState() {
        return machineryState;
    }
}
