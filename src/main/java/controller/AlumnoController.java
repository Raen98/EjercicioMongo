package controller;

import dao.AlumnoDao;
import model.Alumno;

import java.util.Scanner;

public class AlumnoController {
    AlumnoDao alumnoDao = new AlumnoDao();
    Scanner scanner = new Scanner(System.in);

    public void insertarAlumno() {
        Alumno aux = new Alumno();
        System.out.println("Nombre: ");
        aux.setName(scanner.nextLine());
        System.out.println("Edad: ");
        aux.setAge(scanner.nextInt());
        System.out.println("Género: ");
        aux.setGender(scanner.nextLine());
        System.out.println("Email: ");
        aux.setEmail(scanner.nextLine());
        System.out.println("Telefono: ");
        aux.setPhone(scanner.nextLine());
        System.out.println("Curso: ");
        aux.setHigherGrade(scanner.nextLine());
        System.out.println("Nota: ");
        aux.setCalification(scanner.nextDouble());
        System.out.println("Rating: ");
        aux.setRating(scanner.nextDouble());
        alumnoDao.insertarAlumno(aux);

    }

    public void listarAlumnos() {
        System.out.println("--------------LISTA DE ALUMNOS-------------");
        if (!alumnoDao.listarAlumnos().isEmpty()) {
            for (Alumno a : alumnoDao.listarAlumnos()) {
                System.out.println(a);
            }
        } else {
            System.out.println("No hay alumnos que mostrar");
        }
        System.out.println("-----------------------------------------");
    }

    public void buscarPorEmail() {
        System.out.println("Email a buscar: ");
        String email = scanner.nextLine();
        if (alumnoDao.buscarPorEmail(email)==null){
            System.out.println("No hay alumno con el correo " + email);
        } else {
            System.out.println(alumnoDao.buscarPorEmail(email));
        }
    }
    public void borrarAlumnosPorNota() {
        System.out.println("Nota a partir de la cual se eliminarán los alumnos: ");
        double nota = scanner.nextDouble();
        alumnoDao.borrarAlumnosPorCalificacion("calification", nota);

    }


}
