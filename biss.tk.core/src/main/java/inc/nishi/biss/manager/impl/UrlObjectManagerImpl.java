package inc.nishi.biss.manager.impl;

import inc.nishi.biss.dto.UrlObjectRequestDTO;
import inc.nishi.biss.manager.UrlObjectManager;
import inc.nishi.biss.model.UrlObject;
import inc.nishi.biss.util.BissUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shuklaalok7
 * @since 3/23/14
 */
@Service("UrlObjectManager")
public class UrlObjectManagerImpl extends BissManagerSupport implements UrlObjectManager {

    @Override
    public String save(UrlObject urlObject) {
//        this.urlObjectDAO.save(urlObject);
        return this.getHash(urlObject);
    }

    @Override
    public UrlObject retrieve(String hash) {
        return this.urlObjectDAO.retrieve(this.getSequence(hash));
    }

    @Override
    public List<UrlObject> search(UrlObjectRequestDTO requestDTO) {
        return this.urlObjectDAO.search(requestDTO);
    }

    private String getHash(UrlObject urlObject) {
        return this.getHash(urlObject.getSequence());
    }

    private String getHash(long sequence) {
        return BissUtils.encode(((Long) sequence).toString());
    }

    private long getSequence(String hash) {
        return Long.parseLong(BissUtils.decode(hash));
    }

}
