package model;

import lombok.*;

import java.util.ArrayList;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter


public class Profesor {
    private double rating;
    private int age;
    private String name;
    private String gender;
    private String email;
    private String phone;
    private ArrayList<String> subjects;
    private String title;

    //sobreescribo el metodo toString a mano para darle formatp
    @Override
    public String toString() {
        return "Nombre: " + name + ", Edad: " + age + ", Calificación: " + rating + ", Género: " + gender + ", Email: " + email + ", Teléfono: " + phone + ", Asignaturas: " + subjects + ", Título: " + title;
    }
}

