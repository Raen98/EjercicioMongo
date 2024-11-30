package dao;

import model.Alumno;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import database.DBConnection;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class AlumnoDao {
    MongoCollection<Alumno> alumnosCollection = DBConnection.getDbConnection().getAlumnoCollection();
    Bson filtro;

    // Inserta un alumno en la base de datos
    public void insertarAlumno(Alumno alumno){
        alumnosCollection.insertOne(alumno);
    }

    // Devuelve una lista con todos los alumnos de la base de datos
    public List<Alumno> listarAlumnos(){
        List<Alumno> listaAlumnos = new ArrayList<>();
        try (MongoCursor<Alumno> mongoCursor = alumnosCollection.find(Alumno.class).cursor()) {
            while (mongoCursor.hasNext()) {
                listaAlumnos.add(mongoCursor.next());
            }
        }
        return listaAlumnos;
    }

    // Devuelve un alumno por su email
    public Alumno buscarPorEmail(String mail){
        filtro = Filters.eq("email", mail);
        return alumnosCollection.find(filtro).first();
    }

    // Elimina los alumnos con una nota mayor o igual a la indicada

    public void borrarAlumnosPorCalificacion(String criterio, double valor){
        filtro = Filters.gte(criterio, valor);
        alumnosCollection.deleteMany(filtro);
    }

}
