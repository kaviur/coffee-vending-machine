package vending_machine;

class PhysicalDispenser implements Dispenser {
    @Override
    public void openDispenser(Ingredient ingredient, int amount) {
        // Abre la compuerta del insumo durante el tiempo necesario para dispensar la cantidad indicada
        // ...
        System.out.println("the "+ingredient.getName()+" gate opens for "+amount+" of seconds");
    }
}
