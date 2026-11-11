
package com.factory.robot.strategy;

public class CriticalRiskStrategy implements MachineryRiskStrategy {

    // Returns the risk factor for critical machinery.
    @Override
    public double getRiskFactor() {
        return 3.0;
    }
}
