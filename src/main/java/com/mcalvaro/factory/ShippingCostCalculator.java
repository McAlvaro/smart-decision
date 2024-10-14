package com.mcalvaro.factory;

import com.mcalvaro.factory.contract.ShippingCostStrategy;

public class ShippingCostCalculator {

    public double calculateShippingCost(String shippingType, double weight) {

        ShippingCostStrategy strategy = ShippingCostFactory.getStrategy(shippingType);

        return strategy.calculate(weight);
    }
}
