package inc.nishi.biss.manager.impl;

import inc.nishi.biss.dao.DAOUtils;
import inc.nishi.biss.dao.UrlObjectDAO;
import inc.nishi.biss.manager.UrlObjectManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shuklaalok7
 * @since 3/23/14
 */
@Service
public abstract class BissManagerSupport {

//    Managers
    @Autowired(required = false)
    protected UrlObjectManager urlObjectManager;

//    DAO

    @Autowired
    protected DAOUtils daoUtils;

    @Autowired
    protected UrlObjectDAO urlObjectDAO;

}
