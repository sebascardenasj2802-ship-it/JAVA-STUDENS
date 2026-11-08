import java.util.ArrayList;

public class Curso {
    // Relación entre clases: Curso contiene una lista de Estudiantes
    private ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

    public void registrarEstudiante(Estudiante e) {
        listaEstudiantes.add(e);
        System.out.println("¡Estudiante registrado correctamente!");
    }

    public void mostrarTodos() {
        // Requisito del arreglo simple (4 líneas)
        String[] materias = {"Tecnoogia", "Lectura", "Matematicas"};
        System.out.print("Materias del curso: ");
        for (int i = 0; i < materias.length; i++) {
            System.out.print(materias[i] + " ");
        }
        System.out.println("\n===================================");

        if (listaEstudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        // Recorrido de la lista
        for (Estudiante e : listaEstudiantes) {
            e.mostrarInformacion();
        }
    }

    public Estudiante buscarPorCodigo(String codigo) throws EstudianteNoEncontradoException {
        for (Estudiante e : listaEstudiantes) {
            if (e.getCodigo().equals(codigo)) {
                return e; // Lo encontró y lo devuelve
            }
        }
        // Si termina el ciclo y no lo encuentra, lanza tu error personalizado
        throw new EstudianteNoEncontradoException("El estudiante con código " + codigo + " no fue encontrado.");
    }
}