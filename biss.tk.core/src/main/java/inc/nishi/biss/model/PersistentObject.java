package inc.nishi.biss.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shuklaalok7
 * @since 3/23/14
 */
@Getter
@Setter
public abstract class PersistentObject implements Serializable, Comparable {

    private MongoObjectId _id;

    private long createdOn;
    private long lastModifiedOn;
    private long sequence;

    protected PersistentObject() {
        super();
        this.createdOn = new Date().getTime();
        this.lastModifiedOn = this.createdOn;
    }

    protected PersistentObject(MongoObjectId _id) {
        this();
        this._id = _id;
    }
}
