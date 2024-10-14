package com.mcalvaro.strategy.context;

import com.mcalvaro.strategy.contract.ShippingCostStrategy;

public class ShippingCostContext {

    private ShippingCostStrategy strategy;

    public void setStrategy(ShippingCostStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateShippingCost(int weight) {
        return strategy.calculate(weight);
    }
}
