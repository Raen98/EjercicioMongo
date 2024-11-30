import controller.AlumnoController;
import controller.ProfesorController;

import java.util.Scanner;

public class Ejecutable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProfesorController profesorController = new ProfesorController();
        AlumnoController alumnoController = new AlumnoController();


        boolean salir = false;
        do {
            mostrarMenu();
            int opcion = 0;
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1 -> profesorController.insertarProfesor();
                case 2 -> alumnoController.insertarAlumno();
                case 3 -> {
                    profesorController.listarProfesores();
                    alumnoController.listarAlumnos();
                }
                case 4 -> profesorController.listarProfesores();
                case 5 -> alumnoController.listarAlumnos();
                case 6 -> alumnoController.buscarPorEmail();
                case 7 -> profesorController.buscarRangoEdad();
                case 8 -> profesorController.editarCalificacion();
                case 9 -> alumnoController.borrarAlumnosPorNota();
                case 10 -> salir = true;
                default -> System.out.println("Opción no válida");
            }
        } while (!salir);
    }

    private static void mostrarMenu() {
        System.out.println("""
                Elija una opcion:
                
                1-Insertar profesor
                2-Insertar alumno
                3-Mostrar todos los datos
                4-Mostrar profesores
                5-Mostrar alumnos
                6-Buscar alumno por email
                7-Buscar profesor por rango de edad
                8-Actualizar calificacion de profesor
                9-Dar de baja alumno con nota superior a numero dado
                10-Salir
                """);
    }
}
