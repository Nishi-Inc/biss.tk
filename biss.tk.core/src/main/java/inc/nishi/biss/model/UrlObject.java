package inc.nishi.biss.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shuklaalok7
 * @since 3/23/14
 */
@Getter
@Setter
public class UrlObject extends PersistentObject {

    private String url;
    private Statistics statistics;

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

}
