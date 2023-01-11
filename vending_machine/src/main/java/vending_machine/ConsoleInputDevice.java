package vending_machine;

import java.util.Scanner;

class ConsoleInputDevice implements InputDevice{
    public int getOption() {
        // lógica para obtener la selección de opciones a través de la consola
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        return option;
    }
}

