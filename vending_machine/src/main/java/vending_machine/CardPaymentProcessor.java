package vending_machine;

class CardPaymentProcessor implements PaymentProcessor {
    private String state = "no iniciado";

    @Override
    public void processPayment(double amount,double price) {
        // Simula el proceso de realizar un pago con tarjeta, como por ejemplo
        // enviar una solicitud al banco y recibir una respuesta de aprobado o rechazado
        System.out.println("Simulando transacción con tarjeta con random...");
        double randomNumber = Math.random();
        if (randomNumber < 0.5) {
            System.out.println("Transacción aprobada");
            state = "aprobado";
        } else {
            System.out.println("Transacción rechazada");
            state = "rechazado";
        }
    }

    public String getState() {
        return state;
    }
    public void setState(String state){}
    public double calculateChange(double amountToPay, double amountInserted){
        return 0;
    }
}
