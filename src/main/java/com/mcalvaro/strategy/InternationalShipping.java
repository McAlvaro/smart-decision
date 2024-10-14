package com.mcalvaro.strategy;

import com.mcalvaro.strategy.contract.ShippingCostStrategy;

public class InternationalShipping implements ShippingCostStrategy {

    @Override
    public double calculate(double weight) {
        return weight * 50.0;
    }

}
