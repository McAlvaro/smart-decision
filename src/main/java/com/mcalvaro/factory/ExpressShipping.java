package com.mcalvaro.factory;

import com.mcalvaro.factory.contract.ShippingCostStrategy;

public class ExpressShipping implements ShippingCostStrategy {

    @Override
    public double calculate(double weight) {
        return weight * 10.0;
    }

}
