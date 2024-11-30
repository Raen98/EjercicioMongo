package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter



public class Alumno {
    private double rating;
    private int age;
    private String name;
    private String gender;
    private String email;
    private String phone;
    private double calification;
    private String higherGrade;
    private boolean FCTs;


    //metodo toString soobrescrito a mano

        @Override
    public String toString() {
    return "Nombre: " + name + ", Edad: " + age + ", Email: " + email + ", Nota: " + calification + ", Género: " + gender + ", Teléfono: " + phone  + ", Título: " + higherGrade + ", FCTs: " + FCTs;
}

}





