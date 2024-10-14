package com.mcalvaro.factory;

import com.mcalvaro.factory.contract.ShippingCostStrategy;

public class SameDayShipping implements ShippingCostStrategy {

	@Override
	public double calculate(double weight) {
        return weight * 20.0;
	}
 
}
