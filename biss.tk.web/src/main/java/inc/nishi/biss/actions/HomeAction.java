package inc.nishi.biss.actions;

import inc.nishi.biss.model.UrlObject;
import inc.nishi.biss.util.BissWebConfig;
import inc.nishi.biss.util.GlobalConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.*;

/**
 * @author Nishi Inc.
 * @since v0.0.1
 */
@Data
@Namespace("/")
@ResultPath("/pages")
@EqualsAndHashCode(callSuper = false)
@Result(name = BissActionSupport.SUCCESS, location = "home.jsp")
public class HomeAction extends BissActionSupport {

    private String longUrl;
    private String shortUrl;

    @Actions({
            @Action("/"),
            @Action("home")
    })
    public String execute() {
        return BissActionSupport.SUCCESS;
    }

    @Action(value = "shorten/{longUrl}", results = {
            @Result(name = BissActionSupport.SUCCESS, location = "ajax/_url_shorten_response.jsp")
    })
    public String shortenLongUrl() {
        if(StringUtils.isNotBlank(this.getLongUrl())) {
            UrlObject urlObject = new UrlObject(this.getLongUrl());
            this.shortUrl = BissWebConfig.DOMAIN + this.getUrlObjectManager().save(urlObject);
        }

        return BissActionSupport.SUCCESS;
    }

    @Action(value = "{shortUrl}", results = {
            @Result(name = BissActionSupport.SUCCESS, location = "ajax/_redirect.jsp")
    })
    public String retrieveUrl() {
        if(StringUtils.isNotBlank(this.getShortUrl())) {
            String hash = this.shortUrl.replace(BissWebConfig.DOMAIN, GlobalConstants.BLANK);
            this.longUrl = this.getUrlObjectManager().retrieve(hash).getUrl();
        }

        return BissActionSupport.SUCCESS;
    }

}
