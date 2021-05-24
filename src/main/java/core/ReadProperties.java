package core;

import java.io.IOException;
import java.util.Properties;

    public class ReadProperties {
        private static Properties properties = null;
        private static String filename = "config.properties";

        static {
            properties = new Properties();
            try {
                properties.load(core.ReadProperties.class.getClassLoader().getResourceAsStream(filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static String getURL() { return properties.getProperty("url");}
    public static String getBrowserName() { return properties.getProperty("browser");}
    public static int getTimeout() { return Integer.parseInt(properties.getProperty("timeout"));}
    public static String getDbUrl(){ return properties.getProperty("db_url");}
    public static String getDbUser(){ return properties.getProperty("db_user");}
    public static String getDbPsw(){ return properties.getProperty("db_psw");}
    public static String getUsername() { return properties.getProperty("username"); }
    public static String getPassword() { return properties.getProperty("password"); }

}
