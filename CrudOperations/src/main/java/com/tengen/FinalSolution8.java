package com.tengen;
import com.mongodb.MongoClient;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.net.UnknownHostException;

/**
 * Created by Venkata on 7/11/2015.
 */
public class FinalSolution8 {



        public static void main(String[] args) throws UnknownHostException{
            MongoClient c =  new MongoClient();
            MongoDatabase db = c.getDatabase("test");
            MongoCollection<Document> animals = db.getCollection("animals");

            Document animal = new Document("animal", "monkey");

            animals.insertOne(animal);
            animal.remove("animal");
            animal.append("animal", "cat");
            animals.insertOne(animal);
            animal.remove("animal");
            animal.append("animal", "lion");
            animals.insertOne(animal);
        }
    }