package inc.nishi.biss.manager.impl;

import inc.nishi.biss.dao.UrlObjectDAO;
import inc.nishi.biss.dao.impl.DAOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shuklaalok7
 * @since 3/23/14
 */
@Service
public abstract class BissManagerSupport {

//    DAO

    @Autowired
    protected DAOUtils daoUtils;

    @Autowired
    protected UrlObjectDAO urlObjectDAO;

}
