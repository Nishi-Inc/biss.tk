package inc.nishi.biss.dao.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import inc.nishi.biss.dao.UrlObjectDAO;
import inc.nishi.biss.dto.UrlObjectRequestDTO;
import inc.nishi.biss.model.UrlObject;
import inc.nishi.biss.model.UrlVisit;
import inc.nishi.biss.util.BissCoreConfig;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author shuklaalok7
 * @since 3/23/14
 */
@Repository("UrlObjectDAO")
public class UrlObjectDAOImpl extends BissDAOSupport implements UrlObjectDAO {

    @Override
    public void save(UrlObject urlObject) {
        urlObject.setSequence(this.getNextSequence());
        this.getDBCollection(UrlObject.class.getSimpleName())
                .save(this.convertToDBObject(urlObject));
    }

    @Override
    public UrlObject retrieve(long sequence, UrlVisit urlVisit) {
        DBObject queryObject = new BasicDBObject("sequence", sequence);
        DBObject updateObject = new BasicDBObject("$push", new BasicDBObject("statistics.hits",
                this.convertToDBObject(urlVisit)));

        updateObject.put("$set", new BasicDBObject("lastModifiedOn", this.getGson().toJson(new Date())));

        DBObject fetchedUrlObject = this.getDBCollection(UrlObject.class.getSimpleName())
                .findAndModify(queryObject, null, null, false, updateObject, true, true);
        return this.convert(fetchedUrlObject, UrlObject.class);
    }

    @Override
    public List<UrlObject> search(UrlObjectRequestDTO urlObjectRequestDTO) {
        return null;
    }

    private long getNextSequence() {
//        DBObject projection = new BasicDBObject(GlobalConstants.SEQUENCE, true);
//        try {
//            return (Long) this.getDBCollection(UrlObject.class.getSimpleName()).find(new BasicDBObject(), projection)
//                    .limit(1).next().get(GlobalConstants.SEQUENCE);
//        } catch (NoSuchElementException e) {
//            return 0;
//        }

        return ((long) this.getDBCollection(BissCoreConfig.COUNTER_COLLECTION_NAME).findAndModify(new BasicDBObject(),
                null, null, false, new BasicDBObject("$inc", new BasicDBObject("value", 1)), true, false).get("value"));
    }

}
