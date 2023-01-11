package vending_machine;

import java.util.Scanner;

class CashPaymentProcessor implements PaymentProcessor {
    private String state = "espera";
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void processPayment(double amount, double price) {
        // Simula el proceso de realizar un pago en efectivo, como por ejemplo
        // contar el dinero ingresado y devolver el cambio si es necesario
        OutputDevice paymentOutputDevice = new ConsoleOutputDevice();
        paymentOutputDevice.paymentOutputDevice(this, amount, price );
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double calculateChange(double amountToPay, double amountInserted) {
        return Math.abs(amountInserted - amountToPay);
    }
}