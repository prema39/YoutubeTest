package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    Properties prop;
    public ConfigReader(String configFilePath){
        File f = new File(configFilePath);
        InputStream is = null;
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public ConfigReader(){
        File f = new File("/Users/premalathaeddyam/eclipse-workspace/YouTubeProject/src/main/resources/Config.properties");
        InputStream is = null;
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getProperty(String propertyName){
        return prop.getProperty(propertyName);
    }
	
}
