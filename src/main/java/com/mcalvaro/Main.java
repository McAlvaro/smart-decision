package com.mcalvaro;

import com.mcalvaro.classic.ShippingCostCalculator;
import com.mcalvaro.enums.ShippingType;

public class Main {
    public static void main(String[] args) {
        System.out.println("----- Smart Decision -----");

        double cost = 0;

        ShippingCostCalculator shippingCostCalculator = new ShippingCostCalculator();

        cost = shippingCostCalculator.calcaulateShippingCost("STANDARD", 10);

        System.out.println("Classic: cost: " + cost);

        com.mcalvaro.enums.ShippingCostCalculator calculatorEnum = new com.mcalvaro.enums.ShippingCostCalculator();

        cost = calculatorEnum.calculateShippingCost(ShippingType.INTERNATIONAL, 10);

        System.out.println("Enum: cost: " + cost);

        com.mcalvaro.factory.ShippingCostCalculator calculatorFactory = new com.mcalvaro.factory.ShippingCostCalculator();

        cost = calculatorFactory.calculateShippingCost("OVERNIGHT", 10);

        System.out.println("Factory: cost: " + cost);

        com.mcalvaro.strategy.ShippingCostCalculator strategyCalculator = new com.mcalvaro.strategy.ShippingCostCalculator();

        cost = strategyCalculator.calculateShippingCost("SAME_DAY", 20);

        System.out.println("Strategy: cost: " + cost);
    }
}
