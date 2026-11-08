import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        Curso curso = new Curso();
        int opcion = 0;

        do {
            System.out.println("\n=================================");
            System.out.println("      SISTEMA DE ESTUDIANTES");
            System.out.println("=================================");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Buscar estudiante");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            // Requisito: Manejo de errores - Error 1 (entrada inválida en el menú)
            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el código: ");
                        String codigo = scanner.nextLine();
                        System.out.print("Ingrese el nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese la nota 1: ");
                        double nota1 = Double.parseDouble(scanner.nextLine());
                        System.out.print("Ingrese la nota 2: ");
                        double nota2 = Double.parseDouble(scanner.nextLine());

                        Estudiante nuevoEstudiante = new Estudiante(codigo, nombre, nota1, nota2);
                        curso.registrarEstudiante(nuevoEstudiante);
                        break;

                    case 2:
                        System.out.println("\n----- LISTA DE ESTUDIANTES -----");
                        curso.mostrarTodos();
                        break;

                    case 3:
                        System.out.print("Ingrese el código a buscar: ");
                        String codigoBuscar = scanner.nextLine();
                        
                        // Requisito: Manejo de errores - Error 2 (buscar algo que no existe)
                        try {
                            Estudiante e = curso.buscarPorCodigo(codigoBuscar);
                            System.out.println("\n--- ESTUDIANTE ENCONTRADO ---");
                            e.mostrarInformacion();
                        } catch (EstudianteNoEncontradoException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}