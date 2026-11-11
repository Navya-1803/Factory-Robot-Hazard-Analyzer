
package com.factory.robot.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MachineryRiskStrategyTest {

    // Verifies the worn machinery risk strategy.
    @Test
    void shouldReturnWornRiskFactor() {

        MachineryRiskStrategy strategy = new WornRiskStrategy();

        assertEquals(1.3, strategy.getRiskFactor(), 0.001);
    }

    // Verifies the faulty machinery risk strategy.
    @Test
    void shouldReturnFaultyRiskFactor() {

        MachineryRiskStrategy strategy = new FaultyRiskStrategy();

        assertEquals(2.0, strategy.getRiskFactor(), 0.001);
    }

    // Verifies the critical machinery risk strategy.
    @Test
    void shouldReturnCriticalRiskFactor() {

        MachineryRiskStrategy strategy = new CriticalRiskStrategy();

        assertEquals(3.0, strategy.getRiskFactor(), 0.001);
    }
}
