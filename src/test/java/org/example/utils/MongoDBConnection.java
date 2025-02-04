package org.example.utils;
import static com.mongodb.client.model.Sorts.descending;
import com.mongodb.client.*;
import org.bson.Document;

public class MongoDBConnection {
    private static final String DATABASE_NAME = "video";
    private static final String URI =
            "mongodb+srv://m001-student:m001-mongodb-basics@cluster0.jxeqq.mongodb.net/?retryWrites=true&w=majority";


    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBConnection() {
        try {
            mongoClient = MongoClients.create(URI);
            database = mongoClient.getDatabase(DATABASE_NAME);
            System.out.println("Successful connection to Mongo database: " + DATABASE_NAME);
        } catch (Exception e) {
            System.err.println("Error connecting to Mongo database: " + e.getMessage());
        }
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void insertDocument(String collectionName, Document document) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertOne(document);
        System.out.println("Document inserted into " + collectionName);
    }

    public void readDocuments(String collectionName, int limit) {
        try {
            if (database == null) {
                System.err.println("Error: The database is not connected.");
                return;
            }

            MongoCollection<Document> collection = database.getCollection(collectionName);
            FindIterable<Document> documents = (limit > 0) ? collection.find().limit(limit) : collection.find();

            for (Document doc : documents) {
                System.out.println(doc.toJson());
            }
        } catch (Exception e) {
            System.err.println("Error reading documents: " + e.getMessage());
        }
    }

    public void getLastAddedDocument(String collectionName) {
        try {
            if (database == null) {
                System.err.println("Error: The database is not connected.");
                return;
            }

            MongoCollection<Document> collection = database.getCollection(collectionName);
            FindIterable<Document> documents = collection.find()
                    .sort(descending("_id"))
                    .limit(1);

            Document lastDocument = documents.first();
            if (lastDocument != null) {
                System.out.println("Last added document: " + lastDocument.toJson());
            } else {
                System.out.println("No documents found in collection: " + collectionName);
            }
        } catch (Exception e) {
            System.err.println("Error retrieving last document: " + e.getMessage());
        }
    }

    public void getListOfAttributeValues(String collectionName, String attributeName, int limit) {
        try {
            if (database == null) {
                System.err.println("Error: The database is not connected.");
                return;
            }

            MongoCollection<Document> collection = database.getCollection(collectionName);
            FindIterable<Document> documents = (limit > 0) ? collection.find().limit(limit) : collection.find();

            for (Document doc : documents) {
                Object attributeValue = doc.get(attributeName);
                if (attributeValue != null) {
                    System.out.println(attributeValue);
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading documents: " + e.getMessage());
        }
    }

    public void updateDocument(String collectionName, Document filter, Document update) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.updateOne(filter, new Document("$set", update));
        System.out.println("Document updated in " + collectionName);
    }

    public void deleteDocument(String collectionName, Document filter) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.deleteOne(filter);
        System.out.println("Document deleted from " + collectionName);
    }

    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Connection closed.");
        }
    }
}
