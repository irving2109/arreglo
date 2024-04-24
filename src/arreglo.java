import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class arreglo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> resultados = new ArrayList<>();

        while (true) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            System.out.println("6. Salir");
            System.out.print("Seleccione una figura geométrica o presione 6 para salir: ");

            int opcionFigura = obtenerEntero(scanner);

            if (opcionFigura == 6) {
                System.out.println("Saliendo del programa.");
                break;
            }

            System.out.println("\nSeleccione la operación:");
            System.out.println("1. Calcular área");
            System.out.println("2. Calcular perímetro");
            System.out.print("Seleccione una operación: ");

            int opcionOperacion = obtenerEntero(scanner);

            double resultado = 0;

            switch (opcionFigura) {
                case 1: // Círculo
                    double radioCirculo = obtenerDoble(scanner, "Ingrese el radio del círculo: ");
                    if (opcionOperacion == 1) {
                        resultado = Circulo.calcularArea(radioCirculo);
                    } else {
                        resultado = Circulo.calcularPerimetro(radioCirculo);
                    }
                    break;
                case 2: // Cuadrado
                    double ladoCuadrado = obtenerDoble(scanner, "Ingrese el lado del cuadrado: ");
                    if (opcionOperacion == 1) {
                        resultado = Cuadrado.calcularArea(ladoCuadrado);
                    } else {
                        resultado = Cuadrado.calcularPerimetro(ladoCuadrado);
                    }
                    break;
                case 3: // Triángulo
                    double baseTriangulo = obtenerDoble(scanner, "Ingrese la base del triángulo: ");
                    double alturaTriangulo = obtenerDoble(scanner, "Ingrese la altura del triángulo: ");
                    if (opcionOperacion == 1) {
                        resultado = Triangulo.calcularArea(baseTriangulo, alturaTriangulo);
                    } else {
                        resultado = Triangulo.calcularPerimetro(baseTriangulo, alturaTriangulo);
                    }
                    break;
                case 4: // Rectángulo
                    double baseRectangulo = obtenerDoble(scanner, "Ingrese la base del rectángulo: ");
                    double alturaRectangulo = obtenerDoble(scanner, "Ingrese la altura del rectángulo: ");
                    if (opcionOperacion == 1) {
                        resultado = Rectangulo.calcularArea(baseRectangulo, alturaRectangulo);
                    } else {
                        resultado = Rectangulo.calcularPerimetro(baseRectangulo, alturaRectangulo);
                    }
                    break;
                case 5: // Pentágono
                    double ladoPentagono = obtenerDoble(scanner, "Ingrese el lado del pentágono: ");
                    if (opcionOperacion == 1) {
                        resultado = Pentagono.calcularArea(ladoPentagono);
                    } else {
                        resultado = Pentagono.calcularPerimetro(ladoPentagono);
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    continue; // Saltar al siguiente ciclo del bucle while
            }

            resultados.add(resultado);
            System.out.println("Resultado: " + resultado);
        }

        scanner.close();

        // Mostrar los resultados almacenados
        System.out.println("\nResultados almacenados:");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println("Operación " + (i + 1) + ": " + resultados.get(i));
        }
    }

    private static int obtenerEntero(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un número entero válido.");
                scanner.next(); // Consumir la entrada no válida
            }
        }
    }

    private static double obtenerDoble(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un número decimal válido.");
                scanner.next(); // Consumir la entrada no válida
            }
        }
    }
}

class Circulo {
    public static double calcularArea(double radio) {
        return Math.PI * radio * radio;
    }

    public static double calcularPerimetro(double radio) {
        return 2 * Math.PI * radio;
    }
}

class Cuadrado {
    public static double calcularArea(double lado) {
        return lado * lado;
    }

    public static double calcularPerimetro(double lado) {
        return 4 * lado;
    }
}

class Triangulo {
    public static double calcularArea(double base, double altura) {
        return (base * altura) / 2;
    }

    public static double calcularPerimetro(double base, double altura) {
        // No se puede calcular el perímetro con solo la base y la altura
        return -1;
    }
}

class Rectangulo {
    public static double calcularArea(double base, double altura) {
        return base * altura;
    }

    public static double calcularPerimetro(double base, double altura) {
        return 2 * (base + altura);
    }
}

class Pentagono {
    public static double calcularArea(double lado) {
        return (5.0 / 4.0) * Math.pow(lado, 2) / Math.tan(Math.PI / 5);
    }

    public static double calcularPerimetro(double lado) {
        return 5 * lado;
    }
}
