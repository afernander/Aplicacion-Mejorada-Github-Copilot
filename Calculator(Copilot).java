import java.util.Scanner;
//codigo mejorado con copilot
interface Operation {
    int execute(int num1, int num2);
}

class Addition implements Operation {
    public int execute(int num1, int num2) {
        return num1 + num2;
    }
}

class Subtraction implements Operation {
    public int execute(int num1, int num2) {
        return num1 - num2;
    }
}

class Multiplication implements Operation {
    public int execute(int num1, int num2) {
        return num1 * num2;
    }
}

class Division implements Operation {
    public int execute(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }
}

public class Calculator {
    private static final int EXIT_OPTION = 5;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 0;
        Operation operation;

        while(option != EXIT_OPTION) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");

            System.out.print("Ingrese su opción: ");
            option = scanner.nextInt();

            if (option == EXIT_OPTION) {
                System.out.println("¡Hasta luego!");
                break;
            }

            System.out.print("Ingrese el primer número: ");
            int num1 = scanner.nextInt();
            System.out.print("Ingrese el segundo número: ");
            int num2 = scanner.nextInt();

            switch(option) {
                case 1:
                    operation = new Addition();
                    break;
                case 2:
                    operation = new Subtraction();
                    break;
                case 3:
                    operation = new Multiplication();
                    break;
                case 4:
                    operation = new Division();
                    break;
                default:
                    System.out.println("Opción no válida");
                    continue;
            }

            try {
                int result = operation.execute(num1, num2);
                System.out.println("El resultado es: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}