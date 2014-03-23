package inc.nishi.biss.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

/**
 * @author shuklaalok7
 * @since 3/23/14
 */
public abstract class BissUtils {

    public static String decode(String s) {
        return StringUtils.newStringUtf8(Base64.decodeBase64(s));
    }
    public static String encode(String s) {
        return Base64.encodeBase64String(StringUtils.getBytesUtf8(s));
    }

}
