package inc.nishi.biss.model;

import org.bson.types.ObjectId;

/**
 * @author shuklaalok7
 * @since 3/23/14
 */
public class MongoObjectId extends ObjectId {

    private String $oid;

    public MongoObjectId() {
        super();
    }

    public MongoObjectId(String $oid) {
        this();
        this.$oid = $oid;
    }

    public static ObjectId getObjectId(Object t) {
        if(t instanceof PersistentObject) {
            return ((PersistentObject) t).get_id();
        }

        if(t instanceof ObjectId) {
            return (ObjectId) t;
        }

        if(t instanceof String) {
            return new MongoObjectId((String) t);
        }

        throw new IllegalArgumentException();
    }

    public String get$oid() {
        return $oid;
    }

    public void set$oid(String $oid) {
        this.$oid = $oid;
    }
}
