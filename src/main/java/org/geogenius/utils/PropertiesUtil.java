package org.geogenius.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();
    private static String PROPERTIES_FILE = "application.properties";

    static {
        loadProperties();
    }

    private static void loadProperties() {
        System.out.println(PROPERTIES_FILE);
        try {
            InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(PropertiesUtil.PROPERTIES_FILE);
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

    public static String getPropertiesFile() {
        return PROPERTIES_FILE;
    }

    public static void setPropertiesFile(String propertiesFile) {
        PROPERTIES_FILE = propertiesFile;
        loadProperties();
    }
}
