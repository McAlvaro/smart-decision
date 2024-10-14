package com.mcalvaro.factory;

import com.mcalvaro.factory.contract.ShippingCostStrategy;

public class OvernightShipping implements ShippingCostStrategy {

    @Override
    public double calculate(double weight) {
        return weight * 30.0;
    }

}
