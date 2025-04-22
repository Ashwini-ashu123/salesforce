package Demo.utility;




import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class objectProp {
    private static final Properties prop = new Properties();

    static {
        try (InputStream input = objectProp.class.getClassLoader().getResourceAsStream("object.properties");
        ) {
            if (input == null) {
                throw new RuntimeException("object.properties file not found in resources folder!");
            }
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load object.properties", e);
        }
    }

    public static String getObjectID(String key) {
        String value = prop.getProperty(key);
        if (value == null) {
            throw new IllegalArgumentException("Key '" + key + "' not found in object.properties.");
        }
        return value;
    }
}






