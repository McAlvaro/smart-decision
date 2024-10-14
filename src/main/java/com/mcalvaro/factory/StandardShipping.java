package com.mcalvaro.factory;

import com.mcalvaro.factory.contract.ShippingCostStrategy;

public class StandardShipping implements ShippingCostStrategy {

	@Override
	public double calculate(double weight) {
        return weight * 5.0;
	}
 
}
