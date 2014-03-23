package inc.nishi.biss.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author Nishi Inc.
 * @since v0.0.1
 */
@Data
public class UrlVisit implements Serializable {

    private Date timeStamp;
    private String location;
    private Map<String, Object> metadata;

    public UrlVisit() {
        super();
        this.timeStamp = new Date();
    }

}
