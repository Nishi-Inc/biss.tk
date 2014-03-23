package inc.nishi.biss.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author shuklaalok7
 * @since 3/23/14
 */
@Getter
@Setter
public abstract class PersistentObject implements Serializable, Comparable {

    private MongoObjectId _id;

    private Long createdOn;
    private Long lastModifiedOn;

}
