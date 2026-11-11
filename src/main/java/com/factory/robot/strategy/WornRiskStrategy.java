
package com.factory.robot.strategy;

public class WornRiskStrategy implements MachineryRiskStrategy {

    // Returns the risk factor for worn machinery.
    @Override
    public double getRiskFactor() {
        return 1.3;
    }
}
