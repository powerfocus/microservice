package org.py.microservice.mongodb;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.java.Log;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Consumer;

@Log
public class MongodbApiTest {
    private MongoClient mongoClient;
    private String databaseName = "mongo2021";
    private MongoDatabase database;

    @Before
    public void before() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        log.info("mongodb connection");
        database = mongoClient.getDatabase(databaseName);
    }

    @After
    public void after() {
        if (null != mongoClient)
            mongoClient.close();
        log.info("mongodb close");
    }

    @Test
    public void insert() {

    }

    @Test
    public void insertMulti() {
        ArrayList<Document> documents = new ArrayList<>();
        for (int i = 0; i < 100; ++i)
            documents.add(new Document("i", i));
        MongoCollection<Document> collection = database.getCollection("test");
        collection.insertMany(documents);
        log.info("insert a multiple document.");
    }

    @Test
    public void count() {
        MongoCollection<Document> test = database.getCollection("test");
        long len = test.countDocuments();
        System.out.println(len);
    }

    @Test
    public void find() {
        MongoCollection<Document> collection = database.getCollection("test");
        collection.find()
                .forEach((Consumer<? super Document>) (Document doc) -> System.out.println(doc.toJson()));
    }

    @Test
    public void findAll() {
        MongoCollection<Document> collection = database.getCollection("test");
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext())
                System.out.println(cursor.next().toJson());
        } finally {
            cursor.close();
        }
    }

    @Test
    public void queryFilter() {
        MongoCollection<Document> collection = database.getCollection("test");
        Document doc = collection.find(Filters.eq("i", 71)).first();
        if (null != doc)
            System.out.println(doc.toJson());
        else
            System.out.println("result is null.");
    }

    @Test
    public void update() {
        MongoCollection<Document> collection = database.getCollection("test");
        collection.updateOne(Filters.eq("i", 10), Updates.set("i", 110));
    }
}