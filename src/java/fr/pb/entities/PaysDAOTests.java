package fr.pb.entities;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.List;

/**
 *
 * @author Dodoma
 */
public class PaysDAOTests {

    public static void main(String[] args) {

        try (MongoClient mc = DBMongoDB.getServerConnection("127.0.0.1", 27017)) {
            MongoDatabase mdb = DBMongoDB.getDB(mc, "cours");
            //MongoDatabase mdb = DBMongoDB.getDB("127.0.0.1", 27017, "cours");
            PaysDAO dao = new PaysDAO(mdb);

            /*
            INSERT
             */
//            Pays p = new Pays("355", "Albanie");
//            int liAffected = dao.insertOne(p);
//            System.out.println("Ajout : " + liAffected);
            /*
DELETE
             */
//            Pays p = new Pays("045", "Danemark");
//            int liAffected = dao.deleteOneByIdPays(p);
//            System.out.println("Suppression : " + liAffected);
//            Pays p = new Pays("5d77960461e2992c2806306d","045","DANEMARK");
//            int liAffected = dao.updateOneByID(p);
//            System.out.println("Modification : " + liAffected);
            /*
            FINDALL
             */
            List<Pays> list = dao.findAll();
            list.forEach((pays) -> {
                System.out.println(pays.getIdPays() + ":" + pays.getNomPays());
            });

            /*
            SELECTONEBYID
             */
//            System.out.println("***** SELECT ONE BY idPays *****");
//            String idPays = "033";
//            Pays p = dao.selectOneByIdPays(idPays);
//            System.out.println(p);
            /*
            SELECTONEBYIDPAYS
             */
            System.out.println("***** SELECT ONE BY _id *****");
            String id = "5cae0ed4af9b081f90d84ba4";
            Pays p = dao.selectOneByID(id);
            System.out.println(p);
            
            
            p = new Pays("5d78ad8161e299312c2f5e96","045","DAN");
            System.out.println(dao.updateOne(p));
        }
    } /// main
} /// class
