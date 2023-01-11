package vending_machine;

class TouchScreenOutputDevice implements OutputDevice{
    public void showOptions(String[] options,String msj) {
        // logica para mostrar las opciones en una pantalla táctil
    }

    public void showPrice(double price) {
        // logica para mostrar el precio en una pantalla táctil
    }

    public void systemConsumerInteraction() throws InterruptedException {}

    public void paymentOutputDevice(PaymentProcessor paymentProcessor, double amount, double price){}
}