package com.mcalvaro.factory;

import com.mcalvaro.factory.contract.ShippingCostStrategy;

public class InternationalShipping implements ShippingCostStrategy {

    @Override
    public double calculate(double weight) {
        return weight * 50.0;
    }

}
