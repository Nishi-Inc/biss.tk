package inc.nishi.biss.dao.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import com.mongodb.*;
import inc.nishi.biss.util.BissCoreConfig;
import inc.nishi.biss.util.GsonUtils;

import java.net.UnknownHostException;
import java.util.Date;

/**
 * @author shuklaalok7
 * @author 3/23/14
 */
public abstract class BissDAOSupport {

    private MongoClient mongoClient;
    private DB db;
    public Gson gson;

    public void setupGson() {
        GsonBuilder gsonBuilder = new GsonBuilder().enableComplexMapKeySerialization();
        gsonBuilder.setLongSerializationPolicy(LongSerializationPolicy.DEFAULT);
        gsonBuilder.registerTypeAdapter(Date.class, new GsonUtils.DateSerializer());
        gsonBuilder.registerTypeAdapter(Date.class, new GsonUtils.DateDeserializer());

        this.gson = gsonBuilder.create();
    }

    private DB getDb() {
        if(this.db == null) {
            this.db = this.getMongoClient().getDB(BissCoreConfig.DB_NAME);
        }
        return db;
    }

    private MongoClient getMongoClient() {
        if(this.mongoClient == null) {
            try {
                this.mongoClient = new MongoClient(BissCoreConfig.HOST, BissCoreConfig.PORT);
            } catch (UnknownHostException e) {
                e.printStackTrace();
                throw new IllegalStateException();
            }
        }
        return this.mongoClient;
    }

    protected Gson getGson() {
        if(this.gson == null) {
            this.setupGson();
        }

        return this.gson;
    }

    protected DBCollection getDBCollection(String collectionName) {
        return this.getDb().getCollection(collectionName);
    }

    public DBObject convertToDBObject(Object object) {
        return this.convert(object, BasicDBObject.class);
    }

    public <T extends Object> T convert(Object source, Class<T> toClass) {
        return this.getGson().fromJson(this.getGson().toJson(source), toClass);
    }
}
