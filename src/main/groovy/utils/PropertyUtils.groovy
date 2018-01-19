package utils

import java.nio.file.Path
import java.nio.file.Paths

/**
 * Created by aniae on 18.01.2018.
 */
public class PropertyUtils {
    
    public static def getProperties() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);
        def properties = new Properties()
        File propertiesFile = new File("setup.properties")
        propertiesFile.withInputStream {
            properties.load(it)
        }
        return properties
    }

    public static String getProp(String property) {
        def prop = getProperties().getProperty(property)
        return prop
    }
}
