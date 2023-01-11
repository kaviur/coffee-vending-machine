package vending_machine;

public class VendingMachine
{
    private static Inventory inventory;

    public static void main(String[] args) throws InterruptedException {
        //todo: hacer la interacción con el administrador
        inventory = new Administrator().createAnInventory();
        OutputDevice outputDevice = new ConsoleOutputDevice();

        //interacción con el consumidor
        outputDevice.systemConsumerInteraction();
    }

    public static Inventory getInventory() {
        return inventory;
    }
}
