# Smart Decision
En este repositorio, aprenderás cómo optimizar el uso de estructuras `if-else`, evitando una gran cantidad de condiciones anidadas. Esto hará que tu código sea mucho más legible y fácil de mantener.

Para ilustrar esta optimización, partiremos de un ejemplo que utiliza varias condiciones `if-else` y luego lo mejoraremos de tres formas diferentes.

## Ejemplo de cálculo de costo de envío
Imagina que tienes una función que calcula el costo de envío según el tipo de envío y el peso del producto:

```java
// classic/ShippingCostCalculator.java

    public double calcaulateShippingCost(String shippingType, double weight) {

        if (shippingType.equals("STANDARD")) {
            return weight * 5.0;
        } else if (shippingType.equals("EXPRESS")) {
            return weight * 10.0;
        } else if (shippingType.equals("SAME_DAY")) {
            return weight * 20.0;
        } else if (shippingType.equals("INTERNATIONAL")) {
            return weight * 50.0;
        } else if (shippingType.equals("OVERNIGHT")) {
            return weight * 30.0;
        }

        return 0;
    }

```

Como puedes ver, este código utiliza múltiples `if-else`, lo que puede volverse complicado de manejar a medida que crecen las condiciones. A continuación, veremos cómo optimizarlo usando diferentes enfoques.

## 3 Formas de Optimización

### 1. Usando Enum

Una forma de eliminar las múltiples condiciones `if-else` es usando `enum`. Esto nos permite asociar directamente cada tipo de envío con su cálculo de costo.

```java
// enums/ShippingType.java
public enum ShippingType {

    STANDARD {
        @Override
        public double getCost(double weight) {
            return weight * 5.0;
        }
    },
    EXPRESS {
        @Override
        public double getCost(double weight) {
            return weight * 10.0;
        }
    },
    SAME_DAY {
        @Override
        public double getCost(double weight) {
            return weight * 20.0;
        }
    },
    INTERNATIONAL {
        @Override
        public double getCost(double weight) {
            return weight * 50.0;
        }
    },
    OVERNIGHT {
        @Override
        public double getCost(double weight) {
            return weight * 30.0;
        }
    };

    public abstract double getCost(double weight);
}
```

Con esta implementación, la lógica se simplifica:

```java
// enums/ShippingCostCalculator.java
public double calculateShippingCost(ShippingType shippingType, double weight) {
    return shippingType.getCost(weight);
}
```

> Ventaja: Eliminamos las declaraciones if-else y dejamos el código más limpio y fácil de mantener.

### Usando el Patrón Factory

El patrón Factory también nos permite evitar las múltiples condiciones `if-else` creando una estructura más extensible.

1. Primero, creamos una interfaz `ShippingCostStrategy` que define el cálculo de costo de envío:

```java
// factory/contract/ShippingCostStrategy.java
public interface ShippingCostStrategy {

    double calculate(double weight);
}
```

2. Luego, implementamos esta interfaz en clases que representen cada tipo de envío:

```java
// factory/StandardShipping
public class StandardShipping implements ShippingCostStrategy {

	@Override
	public double calculate(double weight) {
        return weight * 5.0;
	}
 
}
```

```java
// factory/ExpressShipping.java
public class ExpressShipping implements ShippingCostStrategy {

    @Override
    public double calculate(double weight) {
        return weight * 10.0;
    }
}
```

```java
// factory/SameDayShipping.java
public class SameDayShipping implements ShippingCostStrategy {

	@Override
	public double calculate(double weight) {
        return weight * 20.0;
	}
}
```

```java
// factory/InternationalShipping.java
public class InternationalShipping implements ShippingCostStrategy {

    @Override
    public double calculate(double weight) {
        return weight * 50.0;
    }
}
```

```java
// factory/OvernightShipping.java
public class OvernightShipping implements ShippingCostStrategy {

    @Override
    public double calculate(double weight) {
        return weight * 30.0;
    }
}
```

Así hacemos lo mismo para `ExpressShipping`, `SameDayShipping`, etc.

3. Ahora, creamos una clase `ShippingCostFactory` que manejará las estrategias:

```java
public class ShippingCostFactory {

    private static final Map<String, ShippingCostStrategy> strategies = new HashMap<>();

    static {
        strategies.put("STANDARD", new StandardShipping());
        strategies.put("EXPRESS", new ExpressShipping());
        strategies.put("SAME_DAY", new SameDayShipping());
        strategies.put("INTERNATIONAL", new InternationalShipping());
        strategies.put("OVERNIGHT", new OvernightShipping());
    }

    public static ShippingCostStrategy getStrategy(String shippingType) {
        ShippingCostStrategy strategy = strategies.get(shippingType);

        if (strategy == null) {
            throw new IllegalArgumentException("Shipping type not supported");
        }

        return strategy;
    }
}
```

4. Finalmente, utilizamos la factory para calcular el costo:

```java
public double calculateShippingCost(String shippingType, double weight) {

    ShippingCostStrategy strategy = ShippingCostFactory.getStrategy(shippingType);

    return strategy.calculate(weight);
}
```

> Ventaja: Este enfoque es más fácil de extender. Si se añaden nuevos tipos de envío, solo necesitamos crear una nueva clase e integrarla en la factory.

### Usando el patron Strategy

El patrón Strategy es muy similar al Factory, pero se centra más en la flexibilidad a la hora de cambiar las estrategias de forma dinámica.

1. Igual que en el Factory, primero creamos la interfaz `ShippingCostStrategy` y las clases específicas para cada tipo de envío.

```java
// strategy/contract/ShippingCostStrategy.java
public interface ShippingCostStrategy {

    double calculate(double weight);
}
```

2. Luego, implementamos esta interfaz en clases que representen cada tipo de envío:


```java
// strategy/StandardShipping.java
public class StandardShipping implements ShippingCostStrategy {

	@Override
	public double calculate(double weight) {
        return weight * 5.0;
	}
}
```

```java
// strategy/ExpressShipping.java
public class ExpressShipping implements ShippingCostStrategy {

    @Override
    public double calculate(double weight) {
        return weight * 10.0;
    }
}
```

```java
// strategy/SameDayShipping.java
public class SameDayShipping implements ShippingCostStrategy {

    @Override
    public double calculate(double weight) {
        return weight * 20.0;
    }
}
```

```java
// strategy/InternationalShipping.java
public class InternationalShipping implements ShippingCostStrategy {

    @Override
    public double calculate(double weight) {
        return weight * 50.0;
    }
}
```

```java
// strategy/OvernightShipping.java
public class OvernightShipping implements ShippingCostStrategy {

    @Override
    public double calculate(double weight) {
        return weight * 30.0;
    }
}
```

3. Luego, creamos una clase `ShippingCostContext` que administrará la estrategia seleccionada:

 ```java
// strategy/context/ShippingCostContext.java
public class ShippingCostContext {

    private ShippingCostStrategy strategy;

    public void setStrategy(ShippingCostStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateShippingCost(int weight) {
        return strategy.calculate(weight);
    }
}
```

3. Por último, lo usamos de esta manera:

```java
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
```

> Ventaja: La estrategia se puede cambiar en tiempo de ejecución, lo que ofrece flexibilidad en escenarios más dinámicos.

Con estas tres optimizaciones, tu código será más fácil de entender, mantener y extender. ¡Elige la que mejor se adapte a tus necesidades!
