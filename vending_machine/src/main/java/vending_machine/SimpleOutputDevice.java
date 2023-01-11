package vending_machine;

class SimpleOutputDevice implements OutputDevice{
    public void showOptions(String[] options,String msj) {
        // lógica para mostrar las opciones en una pantalla LCD no touch
    }

    public void showPrice(double price) {
        // lógica para mostrar el precio en una pantalla LCD no touch
    }

    public void systemConsumerInteraction() throws InterruptedException {}

    public void paymentOutputDevice(PaymentProcessor paymentProcessor, double amount, double price){}
}