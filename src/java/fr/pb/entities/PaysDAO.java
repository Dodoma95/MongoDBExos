package fr.pb.entities;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Dodoma
 */
public class PaysDAO {

    private MongoDatabase mongoDatabase;

    /**
     *
     * @param mongoDatabase
     */
    public PaysDAO(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    /***
     * 
     * @return 
     */
    public List<Pays> findAll() {
        List<Pays> list = new ArrayList();

        try {
            // La collection
            MongoCollection collection = mongoDatabase.getCollection("pays");
            /*
             Balayage du curseur
             */
            Document sortOrder = new Document("nom_pays", 1);
            FindIterable<Document> resultat = collection.find().sort(sortOrder);
            MongoCursor<Document> curseur = resultat.iterator();
            while (curseur.hasNext()) {
                Document document = curseur.next();
                Pays pays = new Pays(document.get("_id").toString(), document.get("id_pays").toString(), document.get("nom_pays").toString());
                list.add(pays);
            }
            // Fermeture du curseur
            curseur.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    } /// findAll

    /***
     * 
     * @param id
     * @return  
     */
    public Pays selectOneByID(String id) {
        Pays pays = null;
        try {
            MongoCollection collection = this.mongoDatabase.getCollection("pays");
            /*
             Filtrage
             */
            // Creation d'un objet de type filtre
            ObjectId oid = new ObjectId(id);
            Document critere = new Document("_id", oid);

            // Selection du Document
            FindIterable<Document> curseur = collection.find(critere);

            // Recuperation du premier (et unique) Document
            Document doc = curseur.first();
            pays = new Pays(doc.get("_id").toString(), doc.get("id_pays").toString(), doc.get("nom_pays").toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pays;
    } /// selectOneByID

    /**
     *
     * @param idPays
     * @return
     */
    public Pays selectOneByIdPays(String idPays) {
        Pays pays = null;
        try {
            MongoCollection collection = this.mongoDatabase.getCollection("pays");
            /*
             Filtrage
             */
            // Creation d'un objet de type filtre
            Document critere = new Document("id_pays", idPays);

            // Selection du Document
            FindIterable<Document> curseur = collection.find(critere);

            // Recuperation du premier (et unique) Document
            Document doc = curseur.first();
            pays = new Pays(doc.get("_id").toString(), doc.get("id_pays").toString(), doc.get("nom_pays").toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pays;
    } /// selectOneByIdPays

    /**
     *
     * @param pays
     * @return
     */
    public int insertOne(Pays pays) {
        int liAffected;

        try {
            // La collection
            MongoCollection collection = mongoDatabase.getCollection("pays");

            // Le document à ajouter
            Document doc = new Document();

            // Transformation du POJO en Document BSON
            doc.append("id_pays", pays.getIdPays());
            doc.append("nom_pays", pays.getNomPays());

            // Ajout (void)
            collection.insertOne(doc);
            liAffected = 1;
            System.out.println("Nouveau pays ajouté !");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            liAffected = -1;
        }
        return liAffected;
    } /// insertOne

    /**
     *
     * @param pays
     * @return
     */
    public int deleteOneByIdPays(Pays pays) {
        int liAffected;
        try {
            MongoCollection collection = this.mongoDatabase.getCollection("pays");
            // La suppression : c'est mieux
            Document critere = new Document("id_pays", pays.getIdPays());
            DeleteResult dr = collection.deleteOne(critere);
            liAffected = (int) dr.getDeletedCount();
            System.out.println("Document supprimé : " + liAffected);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            liAffected = -1;
        }
        return liAffected;
    } /// deleteOneByIdPays

    /**
     *
     * @param pays
     * @return
     */
    public int deleteOneByID(Pays pays) {
        int liAffected;
        try {
            MongoCollection collection = this.mongoDatabase.getCollection("pays");
            // La suppression : c'est mieux
            Document critere = new Document("id", pays.getId());
            DeleteResult dr = collection.deleteOne(critere);
            liAffected = (int) dr.getDeletedCount();
            System.out.println("Document supprimé : " + liAffected);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            liAffected = -1;
        }
        return liAffected;
    } /// deleteOneById

    /**
     *
     * @param pays
     * @return
     */
    public int updateOne(Pays pays) {
        int liAffected = 0;
        try {
            MongoCollection collection = this.mongoDatabase.getCollection("pays");

            // Le filtre
            ObjectId oid = new ObjectId(pays.getId());
            Document filtre = new Document("_id", oid);
            // Le nouveau document
            Document newDoc = new Document();
            newDoc.append("id_pays", pays.getIdPays());
            newDoc.append("nom_pays", pays.getNomPays());
            // La modification (du contenu et de la structure)
            UpdateResult ur = collection.replaceOne(filtre, newDoc);

            liAffected = (int) ur.getModifiedCount();
            System.out.println("Document modifié : " + liAffected);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            liAffected = -1;
        }
        return liAffected;
    } /// updateOne

} /// class
