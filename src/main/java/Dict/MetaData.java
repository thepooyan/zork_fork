package Dict;

import Util.JsonReader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Random;

public class MetaData {
    JsonNode jsonData;
    public MetaData(String sourceFile) {
        try {
            this.jsonData = new JsonReader(sourceFile).getJsonData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] getSceneStarters() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(jsonData.get("sceneStarters"), String[].class);
    }
    public String getRandomSceneStarter() {
        String[] items = getSceneStarters();
        Random random = new Random();
        int randomIndex = random.nextInt(items.length);
        return items[randomIndex];
    }
}
