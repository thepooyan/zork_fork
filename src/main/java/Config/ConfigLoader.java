package Config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    Properties properties = new Properties();
    public ConfigLoader() {
        try (FileInputStream input = new FileInputStream("src/main/java/Config/Config.properties")) {
            this.properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getProperty(String pr) {
        return this.properties.getProperty(pr);
    }
}