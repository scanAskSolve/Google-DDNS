import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static Properties loadConfig(String fileName) throws IOException {
        Properties properties = new Properties();

        properties.load(new FileInputStream(fileName));

        return properties;
    }
}
