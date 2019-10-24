package fr.pb.entities;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Dodoma
 */
public class DBMongoDBTests {

    public static void main(String[] args) {
        //
        MongoClient mc = DBMongoDB.getServerConnection("127.0.0.1", 27017);
        System.out.println("MongoClient : " + mc);
        System.out.println(DBMongoDB.closeConnection(mc));

        //
        MongoDatabase db = DBMongoDB.getDB(mc, "cours");
        System.out.println("db : " + db);

        /*
        Closes
         */
        mc.close();

    } /// main
} /// class
