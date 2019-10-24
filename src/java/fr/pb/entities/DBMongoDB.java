package fr.pb.entities;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import java.util.ArrayList;
import java.util.List;

public class DBMongoDB {

    /**
     *
     * @param ip
     * @param port
     * @return
     */
    public static MongoClient getServerConnection(String ip, int port) {

        MongoClient mdbClient = null;

        try {
            mdbClient = new MongoClient(ip, port);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return mdbClient;
    } /// getConnexion

    /**
     *
     * @param user
     * @param pwd
     * @param ip
     * @param port
     * @param dbName
     * @return
     */
    public static MongoClient getServerConnection(String user, String pwd, String ip, int port, String dbName) {

        MongoClient mdbClient = null;
        String lsURL = "mongodb://" + user + ":" + pwd + "@" + ip + ":" + port + "/" + dbName;
        MongoClientURI uri;

        try {
            uri = new MongoClientURI(lsURL);
            mdbClient = new MongoClient(uri);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return mdbClient;
    } /// getConnexion

    /**
     *
     * @param mongoClient
     * @param dbName
     * @return
     */
    public static MongoDatabase getDB(MongoClient mongoClient, String dbName) {
        MongoDatabase db = null;
        try {
            // La BD
            db = mongoClient.getDatabase(dbName);
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        return db;
    } /// getDB

    /**
     *
     * @param ip
     * @param port
     * @param dbName
     * @return
     */
    public static MongoDatabase getDB(String ip, int port, String dbName) {

        MongoClient mongoClient;
        MongoDatabase db = null;

        try {
            mongoClient = new MongoClient(ip, port);
            db = mongoClient.getDatabase(dbName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return db;
    } /// getDB

    /**
     *
     * @param mongoClient
     * @return
     */
    public static boolean closeConnection(MongoClient mongoClient) {
        boolean lbOK = true;

        try {
            mongoClient.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            lbOK = false;
        }
        return lbOK;
    } /// closeConnexion

    /**
     *
     * @param mongoClient
     * @param dbName
     * @return
     */
    public static MongoDatabase dbCreate(MongoClient mongoClient, String dbName) {
        MongoDatabase db = null;
        try {
            db = mongoClient.getDatabase(dbName);
        } catch (Exception e) {
        }
        return db;
    } /// dbCreate

    /**
     *
     * @param db
     * @return
     */
    public static boolean dbDrop(MongoDatabase db) {
        boolean ok = false;
        try {
            db.drop();
            ok = true;
        } catch (Exception e) {
        }
        return ok;
    } /// dbCreate

    /**
     *
     * @param mongoClient
     * @return
     */
    public static String[] getDBSNames(MongoClient mongoClient) {
        List<String> list = new ArrayList();
        try {

            /*
             Les BD
             */
            MongoIterable<String> dbList = mongoClient.listDatabaseNames();

//            MongoCursor<String> it = dbList.iterator();
//            while (it.hasNext()) {
//                String lsDB = it.next();
//                System.out.println(lsDB);
//            }
            // ALTERNATIVE ...
            for (String lsDB : dbList) {
                list.add(lsDB);
            }
        } catch (Exception e) {
            list.add(e.getMessage());
        }

        return list.toArray(new String[list.size()]);

    } /// getDBSNames

    /**
     *
     * @param mongoClient
     * @param dbName
     * @return
     */
    public static String[] getCollectionsNamesFromDB(MongoClient mongoClient, String dbName) {

        List<String> list = new ArrayList();

        MongoDatabase db = DBMongoDB.getDB(mongoClient, dbName);
        try {
            MongoIterable<String> collectionIterable = db.listCollectionNames();
            for (String collectionName : collectionIterable) {
                list.add(collectionName);
            }
        } catch (Exception e) {
            list.add(e.getMessage());
        }
        return list.toArray(new String[list.size()]);

    } /// getCollectionsNamesFromDB

    /**
     *
     * @param db
     * @param collectionName
     * @return
     */
    public static MongoCollection createCollection(MongoDatabase db, String collectionName) {
        MongoCollection collection = null;
        try {
            db.createCollection(collectionName);
            collection = db.getCollection(collectionName);
        } catch (Exception e) {
        }
        return collection;
    } /// createCollection

    /**
     *
     * @param db
     * @param collectionName
     * @return
     */
    public static boolean dropCollection(MongoDatabase db, String collectionName) {
        boolean ok = true;
        try {
//            MongoCollection collection = db.getCollection(collectionName);
//            collection.drop();
            db.getCollection("collectionName").drop();
        } catch (Exception e) {
            ok = false;
        }
        return ok;
    }

} /// class
