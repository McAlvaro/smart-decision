package com.mcalvaro.strategy;

import com.mcalvaro.strategy.contract.ShippingCostStrategy;

public class ExpressShipping implements ShippingCostStrategy {

    @Override
    public double calculate(double weight) {
        return weight * 10.0;
    }

}
