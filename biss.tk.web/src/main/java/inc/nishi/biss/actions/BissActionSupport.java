package inc.nishi.biss.actions;


import com.opensymphony.xwork2.Preparable;
import inc.nishi.biss.manager.UrlObjectManager;
import inc.nishi.biss.util.BissWebConfig;
import inc.nishi.biss.util.ServiceLocator;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Getter
@Setter
@Namespace("/")
@ResultPath("/pages")
@ExceptionMappings({
        @ExceptionMapping(exception = "java.lang.Exception", result = "error.jsp")
})
@Result(name = BissActionSupport.ERROR, location = "error.jsp")
public abstract class BissActionSupport extends DefaultActionSupport implements SessionAware, ServletRequestAware,
        ServletResponseAware, ParameterAware, Preparable {

    protected static final String REDIRECT = "redirect";

    private Map<String, Object> session;
    private Map<String, String[]> parameters;
    private HttpServletRequest servletRequest;
    private HttpServletResponse servletResponse;

    private String pageTitle;

    private UrlObjectManager urlObjectManager;

    @Override
    public void prepare() throws Exception {
        this.pageTitle = BissWebConfig.PAGE_TITLE;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void setParameters(Map<String, String[]> parameters) {
        this.parameters = parameters;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.servletRequest = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.servletResponse = response;
    }

    public UrlObjectManager getUrlObjectManager() {
        if(this.urlObjectManager == null) {
            this.urlObjectManager = ServiceLocator.getBean(UrlObjectManager.class);
        }
        return this.urlObjectManager;
    }

}
