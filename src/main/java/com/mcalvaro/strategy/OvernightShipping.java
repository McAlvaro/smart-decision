package com.mcalvaro.strategy;

import com.mcalvaro.strategy.contract.ShippingCostStrategy;

public class OvernightShipping implements ShippingCostStrategy {

    @Override
    public double calculate(double weight) {
        return weight * 30.0;
    }

}
