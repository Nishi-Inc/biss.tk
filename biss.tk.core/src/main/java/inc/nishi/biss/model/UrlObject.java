package inc.nishi.biss.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author shuklaalok7
 * @since 3/23/14
 */
@Getter
@Setter
public class UrlObject extends PersistentObject {

    private String url;
    private Date expiryDate;
    private Statistics statistics;
    private int maxHits;

    public UrlObject() {
        super();
    }

    public UrlObject(String url) {
        this();
        this.url = url;
    }

    public UrlObject(String url, Date expiryDate) {
        this(url);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object object) {
        return false;
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public long getMaxHits() {
        return maxHits;
    }
}
