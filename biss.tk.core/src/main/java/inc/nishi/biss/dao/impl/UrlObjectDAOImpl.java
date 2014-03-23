package inc.nishi.biss.dao.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import inc.nishi.biss.dao.UrlObjectDAO;
import inc.nishi.biss.dto.UrlObjectRequestDTO;
import inc.nishi.biss.model.UrlObject;
import inc.nishi.biss.util.GlobalConstants;
import inc.nishi.biss.util.GsonUtils;
import org.springframework.stereotype.Repository;

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
                .save(GsonUtils.gson.fromJson(GsonUtils.gson.toJson(urlObject), BasicDBObject.class));
    }

    @Override
    public UrlObject retrieve(long sequence) {
        return null;
    }

    @Override
    public List<UrlObject> search(UrlObjectRequestDTO urlObjectRequestDTO) {
        return null;
    }

    private long getNextSequence() {
        DBObject projection = new BasicDBObject(GlobalConstants.SEQUENCE, true);
        return (Long) this.getDBCollection(UrlObject.class.getSimpleName()).find(new BasicDBObject(), projection)
                .limit(1).next().get(GlobalConstants.SEQUENCE);
    }

}
