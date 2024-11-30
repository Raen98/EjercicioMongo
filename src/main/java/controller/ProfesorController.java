package controller;

import model.Profesor;
import dao.ProfesorDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ProfesorController {

    ProfesorDao profesorDao = new ProfesorDao();
    Scanner scanner = new Scanner(System.in);

    public void insertarProfesor() {
        Profesor aux = new Profesor();
        System.out.println("Nombre: ");
        aux.setName(scanner.nextLine());
        System.out.println("Edad: ");
        aux.setAge(Integer.parseInt(scanner.nextLine()));
        System.out.println("Género: ");
        aux.setGender(scanner.nextLine());
        System.out.println("Email: ");
        aux.setEmail(scanner.nextLine());
        System.out.println("Telefono: ");
        aux.setPhone(scanner.nextLine());
        System.out.println("Titulo: ");
        aux.setTitle(scanner.nextLine());
        System.out.println("Asignaturas: (introduce las asignaturas separadas por comas) ");
        String asignaturas = scanner.nextLine();
        String[] listaAsignaturas = asignaturas.split(",");
        aux.setSubjects(new ArrayList<>(Arrays.asList(listaAsignaturas)));
        System.out.println("Puntuacion: ");
        aux.setRating(Double.parseDouble(scanner.nextLine()));
        profesorDao.insertarProfesor(aux);
    }

    public void listarProfesores() {
        System.out.println("--------------LISTA DE PROFESORES-------------");
        if (!profesorDao.listarProfesores().isEmpty()) {
            for (Profesor p : profesorDao.listarProfesores()) {
                System.out.println(p);
            }
        } else {
            System.out.println("No hay profesores que mostrar");
        }
        System.out.println("-----------------------------------------");
    }

    public void buscarRangoEdad() {
        System.out.println("Mayor que: ");
        int gt = Integer.parseInt(scanner.nextLine());
        System.out.println("Menor que: ");
        int lt = Integer.parseInt(scanner.nextLine());
        if (!profesorDao.buscarRangoEdad(gt, lt).isEmpty()) {
            System.out.println("--------------LISTA DE PROFESORES-------------");
            for (Profesor p : profesorDao.buscarRangoEdad(gt, lt)) {
                System.out.println(p);
            }
            System.out.println("-----------------------------------------");
        } else {
            System.out.println("No hay profesores en ese rango de edad");
        }
    }

    public void editarCalificacion() {
        System.out.println("Email del profesor: ");
        String email = scanner.nextLine();
        System.out.println("Nueva calificacion: ");
        double calificacion = Double.parseDouble(scanner.nextLine());
        profesorDao.actualizarCalificacion(email, calificacion);
        System.out.println("Calificacion actualizada");
    }



}
