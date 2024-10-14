package com.mcalvaro.enums;

public class ShippingCostCalculator {

    public double calculateShippingCost(ShippingType shippingType, double weight) {
        return shippingType.getCost(weight);
    }
}
