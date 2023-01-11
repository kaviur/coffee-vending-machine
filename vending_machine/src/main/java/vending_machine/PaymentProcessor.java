package vending_machine;

interface PaymentProcessor {
    public String state = "in process";
    void processPayment(double amount,double price);

    String getState();
    public void setState(String state);
    double calculateChange(double amountToPay, double amountInserted);
}