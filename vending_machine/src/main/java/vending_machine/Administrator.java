package vending_machine;

class Administrator extends User {
    void addIngredient(Ingredient ingredient, int quantity) {
        // Agregar ingrediente a la máquina
    }

    void setIngredientPrice(Ingredient ingredient, int price) {
        // Configurar el precio del ingrediente
    }

    void checkInventory() {
        // Revisar el inventario
    }

    public static Inventory createAnInventory(){
        //el administrador crea un inventario de insumos o setea los valores a su capacidad máxima despues hacer una recarga
        Ingredient coffeeType1 = new Ingredient("normal", 10, "proveedor1", 2, 20, 5, new PhysicalDispenser());
        Ingredient coffeeType2 = new Ingredient("descafeinado", 8, "proveedor2", 20, 20, 5, new PhysicalDispenser());
        Ingredient coffeeFormula1 = new Ingredient("capuchino", 15, "proveedor3", 3, 20, 5, new PhysicalDispenser());
        Ingredient coffeeFormula2 = new Ingredient("latte", 20, "proveedor4", 20, 20, 5, new PhysicalDispenser());
        Ingredient coffeeFormula3 = new Ingredient("mocha", 23, "proveedor4", 20, 20, 5, new PhysicalDispenser());
        Ingredient sugar = new Ingredient("sugar", 2, "proveedor5", 20, 20, 5, new PhysicalDispenser());
        Ingredient water = new Ingredient("water", 0, "proveedor6", 20, 20, 5, new PhysicalDispenser());

        Inventory inventory = new Inventory(coffeeType1, coffeeType2, coffeeFormula1, coffeeFormula2, coffeeFormula3, sugar, water);
        return  inventory;
    }
}
