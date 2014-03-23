package inc.nishi.biss.manager;

import inc.nishi.biss.dto.UrlObjectRequestDTO;
import inc.nishi.biss.model.UrlObject;
import inc.nishi.biss.model.UrlVisit;

import java.util.List;

/**
 * @author shuklaalok7
 * @since 3/23/14
 */
public interface UrlObjectManager {

    /**
     * Saves a new URLObject
     * @param urlObject    urlObject to save
     * @return String hash of the URL to create short URL
     */
    public String save(UrlObject urlObject);

    /**
     * @param hash    short URL identifier
     * @param urlVisit     urlVisit object to update statistics
     * @return UrlObject containing longUrl
     */
    public UrlObject retrieve(String hash, UrlVisit urlVisit);

    /**
     * @param requestDTO    requestDTO object
     * @return List of UrlObjects
     */
    public List<UrlObject> search(UrlObjectRequestDTO requestDTO);

}
