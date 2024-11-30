package dao;

import model.Profesor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import database.DBConnection;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class ProfesorDao {

        MongoCollection<Profesor> profesoresCollection = DBConnection.getDbConnection().getProfesoresCollection();
        Bson filtro;
        Document Actualizar;


        // Insertar profesor
        public void insertarProfesor(Profesor profesor) {
            profesoresCollection.insertOne(profesor);
        }

        // Devuelve una lista de todos los profesores de la base de datos
        public List<Profesor> listarProfesores() {
            List<Profesor> listaProfesores = new ArrayList<>();
            try (MongoCursor<Profesor> mongoCursor = profesoresCollection.find(Profesor.class).cursor()) {
                while (mongoCursor.hasNext()) {
                    listaProfesores.add(mongoCursor.next());
                }
            }
            return listaProfesores;
        }

        // Devuelve una lista de profesores con una edad dentro de un rango especificado
        public List<Profesor> buscarRangoEdad(int gt, int lt) {
            List<Profesor> listaProfesores = new ArrayList<>();
            Bson filtro = Filters.and(
                    Filters.lt("age", lt),
                    Filters.gt("age", gt));
            for (Profesor p: profesoresCollection.find(filtro)){
                listaProfesores.add(p);
            }
            return listaProfesores;

        }

        // Actualiza calificacion de profesor por email

        public void actualizarCalificacion(String email, double rating) {
            filtro = Filters.eq("email", email);
            Actualizar = new Document("$set",new Document("rating", rating));
            profesoresCollection.updateOne(filtro,Actualizar);
        }
}
