package inc.nishi.biss.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author shuklaalok7
 * @since 3/23/14
 */
@Getter
@Setter
public class Statistics implements Serializable {

    private List<UrlVisit> hits;

    public long getTotalHits() {
        return this.getHits().size();
    }

}
