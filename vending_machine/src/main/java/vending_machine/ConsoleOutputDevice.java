package vending_machine;

import java.util.Scanner;

class ConsoleOutputDevice implements OutputDevice{
    private static Inventory inventory;
    private static final String[] COFFEE_TYPES = {"Normal", "Descafeinado"};
    private static final String[] COFFEE_FORMULAS = {"Capuchino", "Latte", "Mocha", "Tinto", "Cancelar"};
    private static final String[] CUP_SIZES = {"Vaso pequeño", "Vaso grande", "Volver al inicio"};
    private static final String[] PAYMENT_OPTIONS = {"Tarjeta", "Efectivo", "Volver al inicio"};
    private static final String[] SUGAR_OPTIONS = {"1 cucharada", "2 cucharadas","Sin azúcar", "Volver al inicio"};

    public void systemConsumerInteraction() throws InterruptedException {
        boolean shouldContinue = true;
        InputDevice inputDevice = new ConsoleInputDevice();
        Inventory inventory = new VendingMachine().getInventory();

        //pedido del usuario
        Scanner scanner = new Scanner(System.in);
        while (shouldContinue) {
            clearConsole();
            Order order;
            Double price;
            boolean justBlackCoffee = false;
            Ingredient coffeeFormulaInInventory = null;

            // Selección de tipo de café
            showOptions(COFFEE_TYPES,"¿Qué tipo de café quieres?");
            int coffeeTypeOption = inputDevice.getOption();
            String coffeeType = COFFEE_TYPES[coffeeTypeOption - 1].toLowerCase();

            //tomar de la lista de insumos en el inventario
            Ingredient coffeeTypeInInventory = inventory.getIngredient(coffeeType);
            if(coffeeTypeInInventory.getAvailableQuantity() == 1){
                System.out.println("Lo siento, no hay suficiente café descafeinado");
                Thread.sleep(5000);
                continue;
            }

            // Selección de versión de café
            showOptions(COFFEE_FORMULAS, "¿Qué versión de café quieres?");
            int coffeeFormulaOption = inputDevice.getOption();
            String coffeeFormula = COFFEE_FORMULAS[coffeeFormulaOption - 1].toLowerCase();

            if (coffeeFormulaOption == 4) {
                justBlackCoffee = true;
            } else if (coffeeFormulaOption == 5) {
                continue;
            }
            if( !justBlackCoffee ){
                coffeeFormulaInInventory = inventory.getIngredient(coffeeFormula);
                if(coffeeFormulaInInventory.getAvailableQuantity() == 1){
                    System.out.println("Lo siento, no hay suficiente cantidad de "+coffeeFormula);
                    Thread.sleep(5000);
                    continue;
                }
            }

            // Selección de cantidad de azúcar
            showOptions(SUGAR_OPTIONS, "¿Qué cantidad de azúcar quieres?");
            int sugarQuantityOption = inputDevice.getOption();
            Ingredient sugarInInventory = inventory.getIngredient("sugar");
            if(sugarInInventory.getAvailableQuantity() < sugarQuantityOption){
                System.out.println("Lo siento, no hay suficiente cantidad de azúcar");
                Thread.sleep(5000);
                continue;
            }
            if(sugarQuantityOption == 3){
                sugarQuantityOption = 0;
            }
            if (sugarQuantityOption == 4) {
                continue;
            }

            // Selección de tamaño de vaso
            showOptions(CUP_SIZES, "¿Qué tamaño de vaso quieres?");
            int cupSizeOption = inputDevice.getOption();
            String cupSize = CUP_SIZES[cupSizeOption - 1].toLowerCase();

            if (cupSizeOption == 3) {
                continue;
            }

            // crear una orden y preparar el café con las preferencias del usuario
            if( !justBlackCoffee ){
                order = new Order(coffeeTypeInInventory, coffeeFormulaInInventory, sugarInInventory, sugarQuantityOption, cupSize, inventory.getIngredient("water"), inventory);
                price = order.getTotal(true);
            }else{
                order = new Order(coffeeTypeInInventory, sugarInInventory, sugarQuantityOption, cupSize, inventory.getIngredient("water"), inventory);
                price = order.getTotal(false);
            }

            showPrice(price);

            showOptions(PAYMENT_OPTIONS, "¿Cómo prefieres pagar?");
            int paymentMethodOption = inputDevice.getOption();
            if (paymentMethodOption == 3) {
                continue;
            }

            PaymentMethod paymentMethod = null;
            PaymentProcessor paymentProcessor = null;

            if (paymentMethodOption == 1) {
                paymentProcessor = new CardPaymentProcessor();
                paymentMethod = new CardPayment(paymentProcessor, price, price);
            } else if (paymentMethodOption == 2) {
                System.out.println("Por favor ingrese la cantidad de dinero a pagar - Total a pagar $"+price);
                double amountInserted = scanner.nextDouble();
                paymentProcessor = new CashPaymentProcessor();
                paymentMethod = new CashPayment(paymentProcessor, amountInserted, price);
            }

            // Procesar el pago
            paymentMethod.pay();

            if (paymentProcessor.getState() == "aprobado") {
                order.prepare(justBlackCoffee);
                System.out.println("Tu café está listo!");
            } else {
                System.out.println("No se pudo procesar el pago");
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paymentOutputDevice(PaymentProcessor paymentProcessor, double amount, double price) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Procesando pago en efectivo...");

        if (amount < price) {
            System.out.println("No ha ingresado suficiente dinero. ¿Desea ingresar el faltante o cancelar la compra?");
            System.out.println("1. Ingresar $"+paymentProcessor.calculateChange(price,amount)+" faltantes");
            System.out.println("2. Cancelar compra");

            int option = scanner.nextInt();
            if (option == 1) {
                System.out.println("Pago procesado correctamente.");
                paymentProcessor.setState("aprobado");
            } else {
                System.out.println("Compra cancelada. Devolviendo el dinero ingresado");
                paymentProcessor.setState("cancelado");
            }
        } else if (amount > price) {
            double change = paymentProcessor.calculateChange(price, amount);
            System.out.println("Su cambio es: $" + change);
            paymentProcessor.setState("aprobado");
        } else {
            System.out.println("Pago procesado correctamente.");
            paymentProcessor.setState("aprobado");
        }
    }

    public void showOptions(String[] options, String msj) {
        // logica para mostrar las opciones en la consola
        System.out.println(msj);

        for (int i = 0; i < options.length; i++) {
            System.out.println(String.format("%d. %s", i + 1, options[i]));
        }
        System.out.print("Seleccione una opción: ");
    }

    public void showPrice(double price) {
        // logica para mostrar el precio en la consola
        System.out.println("El precio del café es: " + price);
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                //Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }
}