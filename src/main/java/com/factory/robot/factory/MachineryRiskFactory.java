
package com.factory.robot.factory;

import com.factory.robot.enums.MachineryState;
import com.factory.robot.exception.RobotSafetyException;
import com.factory.robot.strategy.CriticalRiskStrategy;
import com.factory.robot.strategy.FaultyRiskStrategy;
import com.factory.robot.strategy.MachineryRiskStrategy;
import com.factory.robot.strategy.WornRiskStrategy;

public class MachineryRiskFactory {

    // Creates the appropriate strategy for the machinery state.
    public MachineryRiskStrategy createStrategy(MachineryState state)
            throws RobotSafetyException {

        if (state == null) {
            throw new RobotSafetyException(
                    "Error: Unsupported machinery state"
            );
        }

        return switch (state) {
            case Worn -> new WornRiskStrategy();
            case Faulty -> new FaultyRiskStrategy();
            case Critical -> new CriticalRiskStrategy();
        };
    }
}
