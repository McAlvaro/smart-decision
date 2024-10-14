package com.mcalvaro.strategy;

import java.util.HashMap;
import java.util.Map;

import com.mcalvaro.strategy.context.ShippingCostContext;
import com.mcalvaro.strategy.contract.ShippingCostStrategy;

public class ShippingCostCalculator {

    private static final Map<String, ShippingCostStrategy> strategies = new HashMap<>();

    static {
        strategies.put("STANDARD", new StandardShipping());
        strategies.put("EXPRESS", new ExpressShipping());
        strategies.put("SAME_DAY", new SameDayShipping());
        strategies.put("INTERNATIONAL", new InternationalShipping());
        strategies.put("OVERNIGHT", new OvernightShipping());
    }

    private final ShippingCostContext context = new ShippingCostContext();

    public double calculateShippingCost(String shippingType, int weight) {
        ShippingCostStrategy strategy = strategies.get(shippingType);

        if (strategy == null) {
            throw new IllegalArgumentException("Invalid shipping type: " + shippingType);
        }

        context.setStrategy(strategy);

        return context.calculateShippingCost(weight);
    }
}
