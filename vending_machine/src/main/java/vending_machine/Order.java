package vending_machine;

class Order {
    private final Inventory inventoryQuantity;
    Ingredient coffeeType; // Tipo de café (cafeinado o descafeinado)
    Ingredient coffeeFormula; // Fórmula de café (capuchino, latte, etc. - Mezcla de leche, espumantes y saborizantes)
    Ingredient sugar;
    int sugarQuantity; // Cantidad de azúcar elegida por el usuario
    Ingredient water;
    String cupSize;

    public Order(Ingredient coffeeType, Ingredient coffeeFormula, Ingredient sugar, int sugarQuantity, String cupSize, Ingredient water, Inventory inventory) {
        this.coffeeType = coffeeType;
        this.coffeeFormula = coffeeFormula;
        this.sugar = sugar;
        this.sugarQuantity = sugarQuantity;
        this.cupSize = cupSize;
        this.water = water;
        this.inventoryQuantity = inventory;
    }

    public Order(Ingredient coffeeType, Ingredient sugar, int sugarQuantity, String cupSize, Ingredient water, Inventory inventory) {
        this.coffeeType = coffeeType;
        this.sugar = sugar;
        this.sugarQuantity = sugarQuantity;
        this.cupSize = cupSize;
        this.water = water;
        this.inventoryQuantity = inventory;
    }

    public double getTotal(boolean justBlackCoffee) {
        PriceCalculator priceCalculator = new PriceCalculator();
        return priceCalculator.calculatePrice(this,justBlackCoffee);
    }

    public void prepare(boolean justBlackCoffee) {
        // Prepara el café y disminuye la cantidad de cada insumo
        coffeeType.decreaseQuantity(1);
        if(!justBlackCoffee) coffeeFormula.decreaseQuantity(1);
        sugar.decreaseQuantity(sugarQuantity);
        water.decreaseQuantity(1);
        // Abre la compuerta de cada insumo durante el tiempo necesario para dispensar la cantidad indicada
        coffeeType.dispense(coffeeType,1);
        if(!justBlackCoffee) coffeeFormula.dispense(coffeeFormula,1);
        sugar.dispense(sugar,sugarQuantity);
        water.dispense(water,1);
    }
}
