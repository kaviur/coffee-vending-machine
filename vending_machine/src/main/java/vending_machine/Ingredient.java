package vending_machine;

class Ingredient {
    private String name;
    private double price;
    private String supplier;
    private int availableQuantity; // Cantidad disponible del ingrediente
    private int maxCapacity; // Capacidad máxima del ingrediente
    private int alertThreshold; // Umbral de alerta del ingrediente
    private Dispenser dispenser; // Dispensador de insumos

    public Ingredient(String name, double price, String supplier, int availableQuantity, int maxCapacity, int alertThreshold, Dispenser dispenser) {
        this.name = name;
        this.price = price;
        this.supplier = supplier;
        this.availableQuantity = availableQuantity;
        this.maxCapacity = maxCapacity;
        this.alertThreshold = alertThreshold;
        this.dispenser = dispenser;
    }

    public void decreaseQuantity(int amount) {
        availableQuantity -= amount;
        if (availableQuantity <= alertThreshold) {
            sendAlert();
        }
    }

    public void sendAlert() {
        // Envía una alerta al administrador
        // ...
    }

    public void dispense(Ingredient ingredient, int amount) {
        if (amount > 0) {
            dispenser.openDispenser(ingredient,amount);
        }
    }

    public double getPrice() {
        return price;
    }

    public String getSupplier() {
        return supplier;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getAlertThreshold() {
        return alertThreshold;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
}
