package inc.nishi.biss.dao;

import inc.nishi.biss.dto.UrlObjectRequestDTO;
import inc.nishi.biss.model.UrlObject;

import java.util.List;

/**
 * @author shuklaalok7
 * @since 3/23/14
 */
public interface UrlObjectDAO {

    /**
     * Saves a new URLObject
     * @param urlObject    urlObject to save
     */
    public void save(UrlObject urlObject);

    /**
     * @param sequence    sequence of the URL stored
     * @return UrlObject containing longUrl
     */
    public UrlObject retrieve(long sequence);

    /**
     * @param urlObjectRequestDTO    requestDTO object
     * @return List of UrlObjects
     */
    public List<UrlObject> search(UrlObjectRequestDTO urlObjectRequestDTO);

}
