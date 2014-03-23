package inc.nishi.biss.dao.impl;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import inc.nishi.biss.util.BissCoreConfig;

import java.net.UnknownHostException;

/**
 * @author shuklaalok7
 * @author 3/23/14
 */
public abstract class BissDAOSupport {

    private MongoClient mongoClient;
    private DB db;

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

    protected DBCollection getDBCollection(String collectionName) {
        return this.getDb().getCollection(collectionName);
    }
}
