package com.mcalvaro.strategy;

import com.mcalvaro.strategy.contract.ShippingCostStrategy;

public class SameDayShipping implements ShippingCostStrategy {

    @Override
    public double calculate(double weight) {
        return weight * 20.0;
    }

}
