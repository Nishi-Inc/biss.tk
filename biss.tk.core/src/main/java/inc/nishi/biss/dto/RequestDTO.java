package inc.nishi.biss.dto;

import inc.nishi.biss.model.MongoObjectId;
import inc.nishi.biss.model.PersistentObject;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author shuklaalok7
 * @since 3/23/14
 */
@Getter
@Setter
public class RequestDTO<T extends PersistentObject> {

    private MongoObjectId _id;
    private Date from;
    private Date to;

}
