package inc.nishi.biss.util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * @author Nishi Inc.
 * @since v0.0.1
 */
public abstract class GsonUtils {

    public static class DateSerializer implements JsonSerializer<Date> {
        @Override
        public JsonElement serialize(Date date, Type type,
                                     JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(date.getTime());
        }
    }

    public static class DateDeserializer implements JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonElement jsonElement, Type type
                , JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return jsonElement.toString().contains("NumberLong") ?
                    new Date(Long.parseLong(jsonElement.toString().replace("NumberLong", GlobalConstants.BLANK))):
                    new Date(jsonElement.getAsLong());
        }
    }

}
