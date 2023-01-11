package vending_machine;

interface OutputDevice{
    public void systemConsumerInteraction() throws InterruptedException;
    public void paymentOutputDevice(PaymentProcessor paymentProcessor, double amount, double price);
    public void showOptions(String[] options,String msj);
    public void showPrice(double price);
}
