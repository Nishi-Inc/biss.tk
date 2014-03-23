package inc.nishi.biss.dao.impl;

import inc.nishi.biss.dao.UrlObjectDAO;
import inc.nishi.biss.dto.UrlObjectRequestDTO;
import inc.nishi.biss.model.UrlObject;
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

    }

    @Override
    public UrlObject retrieve(long sequence) {
        return null;
    }

    @Override
    public List<UrlObject> search(UrlObjectRequestDTO urlObjectRequestDTO) {
        return null;
    }

}
