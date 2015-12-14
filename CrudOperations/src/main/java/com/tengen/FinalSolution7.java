package com.tengen;

import com.mongodb.*;

import java.io.IOException;

/**
 * Created by Venkata on 7/11/2015.
 */
public class FinalSolution7 {
    public static void main(String[] args) throws IOException {
        MongoClient c =  new MongoClient();
        DB db = c.getDB("test");
        int i =0;
        DBCollection album = db.getCollection("albums");
        DBCollection image = db.getCollection("images");

        DBCursor cur = image.find();
        cur.next();

        while (cur.hasNext()){
            Object id = cur.curr().get("_id");
            DBCursor curalbum = album.find(new BasicDBObject("images", id));
            if(!curalbum.hasNext()){
                image.remove(new BasicDBObject("_id", id));
            }
            cur.next();
        }
    }
}
