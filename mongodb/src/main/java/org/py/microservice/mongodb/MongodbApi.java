package org.py.microservice.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.java.Log;
import org.bson.Document;

import java.util.Arrays;

/**
 * @author cqpythagoras
 * @date 2021-03-07
 */
@Log
public class MongodbApi {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            log.info("mongodb connection success.");

            MongoDatabase database = mongoClient.getDatabase("mongo2021");
            MongoCollection<Document> collection = database.getCollection("test");

            Document doc = new Document("name", "MongoDB")
                    .append("type", "database")
                    .append("count", 1)
                    .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"));

            collection.insertOne(doc);

            System.out.println(collection.countDocuments());
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }
}
