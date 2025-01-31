package org.example.utils;

import com.mongodb.client.*;
import org.bson.Document;

public class MongoDBConnection {
    private static final String URI = "mongodb://m001-student:m001-mongodb-basics@cluster0-shard-00-00-jxeqq.mongodb.net/video?retryWrites=true&w=majority";
    private static final String DATABASE_NAME = "video";

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
        MongoCollection<Document> collection = database.getCollection(collectionName);
        FindIterable<Document> documents = collection.find().limit(limit);

        for (Document doc : documents) {
            System.out.println(doc.toJson());
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
