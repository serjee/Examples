package coins.analyzer.jsonCmcModel;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.List;

public class NullCollectionDeserializer implements JsonDeserializer<List> {
    @Override
    public List deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        if (json.isJsonNull()) {
            return null;
        }
        return new Gson().fromJson(json, typeOfT);
    }
}
