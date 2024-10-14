package com.mcalvaro.strategy;

import com.mcalvaro.strategy.contract.ShippingCostStrategy;

public class StandardShipping implements ShippingCostStrategy {

	@Override
	public double calculate(double weight) {
        return weight * 5.0;
	}
 
}
