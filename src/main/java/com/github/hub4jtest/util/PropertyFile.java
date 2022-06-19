package com.github.hub4jtest.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
    public static Properties getPropertiesFromFile(String filepath) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
