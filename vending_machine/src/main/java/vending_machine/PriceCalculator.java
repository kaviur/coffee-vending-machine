package vending_machine;

class PriceCalculator {

    // Calcula el precio total de la orden teniendo en cuenta el precio de cada insumo y el tamaño del vaso
    public double calculatePrice(Order order,boolean justBlackCoffee) {
        double total = 0;
        double cupSizePrice = 1.0;

        if (order.cupSize.equals("small")) {
            cupSizePrice = 0.8; // Disminuir en un 20% el precio de los ingredientes
        }

        total += order.coffeeType.getPrice()* cupSizePrice;
        if( !justBlackCoffee && order.coffeeFormula != null) {
            total += order.coffeeFormula.getPrice() * cupSizePrice;
        }
        total += order.sugar.getPrice() * order.sugarQuantity; // Se multiplica el precio del azúcar por la cantidad elegida por el usuario
        total += order.water.getPrice()* cupSizePrice;
        return total;
    }
}
