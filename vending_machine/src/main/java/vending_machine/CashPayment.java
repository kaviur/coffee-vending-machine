package vending_machine;

class CashPayment implements PaymentMethod {
    private PaymentProcessor paymentProcessor;
    private double amount;
    private double price;

    public CashPayment(PaymentProcessor paymentProcessor, double amount, double price) {
        this.paymentProcessor = paymentProcessor;
        this.amount = amount;
        this.price = price;
    }

    @Override
    public void pay() {
        // Llama al método processPayment() del objeto PaymentProcessor asignado
        paymentProcessor.processPayment(amount,price);
    }

}
