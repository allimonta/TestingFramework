package org.example.tests;
import org.example.utils.MongoDBConnection;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MongoConnectionTests {
    private MongoDBConnection dbConnection;

    @BeforeMethod
    public void OpenMongoDBConnection(){
        dbConnection = new MongoDBConnection();
    }

    @AfterTest
    public void CloseMongoDBConnection(){
        dbConnection.closeConnection();
    }

    @Test
    public void PrintingDocuments() {
        //dbConnection.readDocuments("movies", 5);
    }
}
