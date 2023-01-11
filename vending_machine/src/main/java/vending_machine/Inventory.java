package vending_machine;

import java.util.ArrayList;
import java.util.List;

class Inventory {
    private List<Ingredient> inventory;

    public Inventory(Ingredient coffeeType1, Ingredient coffeeType2, Ingredient coffeeFormula1, Ingredient coffeeFormula2, Ingredient coffeeFormula3, Ingredient sugar,Ingredient water) {
        this.inventory = new ArrayList<>();
        this.inventory.add(coffeeType1);
        this.inventory.add(coffeeType2);
        this.inventory.add(coffeeFormula1);
        this.inventory.add(coffeeFormula2);
        this.inventory.add(coffeeFormula3);
        this.inventory.add(sugar);
        this.inventory.add(water);
    }

    public void addIngredient(Ingredient ingredient) {
        inventory.add(ingredient);
    }
    public void removeIngredient(Ingredient ingredient) {
        inventory.remove(ingredient);
    }

    public Ingredient getIngredient(String name) {
        for (Ingredient ingredient : inventory) {
            if (ingredient.getName().equals(name)) {
                return ingredient;
            }
        }
        return null;
    }

    public void updateIngredientPrice(Ingredient ingredient, double price) {
        ingredient.setPrice(price);
    }

    public List<Ingredient> getInventory() {
        return inventory;
    }

}
