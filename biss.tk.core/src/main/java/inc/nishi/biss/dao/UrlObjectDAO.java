package inc.nishi.biss.dao;

import inc.nishi.biss.dto.UrlObjectRequestDTO;
import inc.nishi.biss.model.UrlObject;

import java.util.List;

/**
 * @author shuklaalok7
 * @since 3/23/14
 */
public interface UrlObjectDAO {

    public void save(UrlObject urlObject);

    public UrlObject retrieve(long sequence);

    public List<UrlObject> search(UrlObjectRequestDTO urlObjectRequestDTO);

}
