package inc.nishi.biss.actions;

import inc.nishi.biss.model.UrlObject;
import inc.nishi.biss.model.UrlVisit;
import inc.nishi.biss.util.BissWebConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

/**
 * @author Nishi Inc.
 * @since v0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Result(name = BissActionSupport.SUCCESS, location = "home.jsp")
public class HomeAction extends BissActionSupport {

    private static final String SHORTEN = "shorten";
    private String longUrl;
    private String shortUrl;
    private UrlObject urlObject;

    private boolean error;
    private String errorMessage;

    @Actions({
            @Action("/"),
    })
    public String execute() {
        return BissActionSupport.SUCCESS;
    }

    @Action(value = "{shortUrl}", results = {
            @Result(name= BissActionSupport.SUCCESS, location = "ajax/_long_url_page.jsp"),
            @Result(name = HomeAction.SHORTEN, location = "ajax/_url_shorten_response.jsp"),
            @Result(name = BissActionSupport.REDIRECT, location = "ajax/_redirect.jsp")
    })
    public String retrieveUrl() {
        if(StringUtils.isNotBlank(this.getShortUrl())) {
            if(this.shortUrl.equals(HomeAction.SHORTEN)) {
                return this.shortenLongUrl();
            }

//            String hash = this.shortUrl.replace(BissWebConfig.DOMAIN, GlobalConstants.BLANK);
            UrlVisit urlVisit = new UrlVisit();
            try {
                this.urlObject = this.getUrlObjectManager().retrieve(this.shortUrl, urlVisit);
            } catch (NumberFormatException e) {
//                This URL is either invalid or expired.
                e.printStackTrace();
                this.error = true;
                this.errorMessage = "The URL (" + BissWebConfig.DOMAIN + this.shortUrl + ") is either not correct or has already expired.";
                return BissActionSupport.ERROR;
            }
        }

        if(this.urlObject.getExpiryDate() == null || this.urlObject.getMaxHits() == 0) {
            if(!this.urlObject.getUrl().contains(BissWebConfig.HTTP_PROTOCOL)) {
                this.urlObject.setUrl(BissWebConfig.HTTP_PROTOCOL + this.urlObject.getUrl());
            }
            return BissActionSupport.SUCCESS;
        } else {
            return BissActionSupport.REDIRECT;
        }
    }

    private String shortenLongUrl() {
        if(StringUtils.isNotBlank(this.longUrl)) {
            UrlObject urlObject = new UrlObject(this.longUrl);
            this.shortUrl = BissWebConfig.DOMAIN + this.getUrlObjectManager().save(urlObject);
        }

        return HomeAction.SHORTEN;
    }

}
