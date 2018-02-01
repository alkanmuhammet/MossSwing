package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * @file PropertyManager.java
 * @date Jan 1, 2018 , 6:41:56 PM
 * @author Muhammet Alkan
 */
public class PropertyManager {

    private Properties defaultProps;
    private Properties userProps;
    private final File userConfigFile;

    public PropertyManager() {
        userConfigFile = new File(getUserDataDirectory(), "userConfig.properties");
        readDefaultProperties();
    }

    public PropertyManager(String userConfigFileName) {
        userConfigFile = new File(getUserDataDirectory(), userConfigFileName + ".properties");
        readDefaultProperties();
    }

    private void readDefaultProperties() {
        defaultProps = new Properties();
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties")) {
            defaultProps.load(inputStream);
            inputStream.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Default config settings could not readed !\n" + ex, "readDefaultProperties", 0);
        }
    }

    protected boolean readUserProperties() {
        userProps = new Properties(defaultProps);

        try (InputStream inputStream = new FileInputStream(userConfigFile)) {
            userProps.load(inputStream);
            inputStream.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static String getUserDataDirectory() {
        return System.getProperty("user.home") + File.separator + "moss" + File.separator;
    }

    public File getUserConfigFile() {
        return userConfigFile;
    }

    public Properties getUserProperties() {
        return userProps;
    }

    public String getDefaultProperty(String key) {
        return defaultProps.getProperty(key);
    }

    public String getUserProperty(String key) {
        return userProps.getProperty(key);
    }

    public String getUserProperty(String key, String defaultValue) {
        if (getUserProperty(key) != null && getUserProperty(key).equals("")) {
            return defaultValue;
        } else {
            return userProps.getProperty(key, defaultValue);
        }
    }

    public void setUserProperty(String key, String value) {
        this.userProps.setProperty(key, value);
    }
}
