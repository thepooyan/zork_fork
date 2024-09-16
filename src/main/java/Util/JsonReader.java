package Util;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    private final JsonNode jsonData;

    public JsonReader(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        jsonData = objectMapper.readTree(file);
    }

    public JsonNode getJsonData() {
        return jsonData;
    }
}