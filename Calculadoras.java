import java.util.Scanner;
//Codigo mejroado con Github Copilot
public class Calculadoras {

    // Usar una única instancia de Scanner como constante.
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        do {
            mostrarMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    sumar();
                    break;
                case 2:
                    restar();
                    break;
                case 3:
                    multiplicar();
                    break;
                case 4:
                    dividir();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

            System.out.println(); // Línea en blanco entre operaciones
        } while (opcion != 5);

        // No cerramos SCANNER porque cierra System.in; el programa termina aquí.
    }

    // Muestra el menú de opciones al usuario.
    private static void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Salir");
    }

    // Lee la opción del usuario y la valida (1-5).
    private static int leerOpcion() {
        while (true) {
            int opt = leerEntero("Ingrese su opción: ");
            if (opt >= 1 && opt <= 5) {
                return opt;
            }
            System.out.println("Opción inválida. Debe ser un número entre 1 y 5.");
        }
    }

    // Lee un entero desde la entrada estándar con manejo de errores.
    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = SCANNER.nextLine();
            try {
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
            }
        }
    }

    private static void sumar() {
        int a = leerEntero("Ingrese el primer número: ");
        int b = leerEntero("Ingrese el segundo número: ");
        int resultado = a + b;
        System.out.println("El resultado de la suma es: " + resultado);
    }

    private static void restar() {
        int a = leerEntero("Ingrese el primer número: ");
        int b = leerEntero("Ingrese el segundo número: ");
        int resultado = a - b;
        System.out.println("El resultado de la resta es: " + resultado);
    }

    private static void multiplicar() {
        int a = leerEntero("Ingrese el primer número: ");
        int b = leerEntero("Ingrese el segundo número: ");
        int resultado = a * b;
        System.out.println("El resultado de la multiplicación es: " + resultado);
    }

    private static void dividir() {
        int a = leerEntero("Ingrese el primer número: ");
        int b = leerEntero("Ingrese el segundo número: ");

        if (b == 0) {
            System.out.println("Error: División por cero. Ingrese un divisor distinto de cero.");
            return;
        }

        double resultado = (double) a / b;
        System.out.printf("El resultado de la división es: %.2f%n", resultado);
    }
}
