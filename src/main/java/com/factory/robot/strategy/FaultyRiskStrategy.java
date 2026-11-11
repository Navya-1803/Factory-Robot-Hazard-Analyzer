
package com.factory.robot.strategy;

public class FaultyRiskStrategy implements MachineryRiskStrategy {

    // Returns the risk factor for faulty machinery.
    @Override
    public double getRiskFactor() {
        return 2.0;
    }
}
