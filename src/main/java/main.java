
import java.io.IOException;
import java.util.Properties;

public class main {
    public static void main(String[] args) {
        String googleAccount = null, googlePassword = null;
        for (int i = 0; i < args.length; i++) {
            if (i == 0) {
                googleAccount = args[0];
            }
            if (i == 1) {
                googlePassword = args[1];
            }
        }
        if (googleAccount == null || googlePassword == null) {
            System.out.println("input google account and password");
            return;
        }
        String configFile = "config.properties";

        try {
            Properties properties = Config.loadConfig(configFile);
            String floatIP = Api.getFloatingIp(properties.getProperty("floatIpUrl"));
            Api.setGoogleDomain(googleAccount, googlePassword,
                    properties.getProperty("domain"), floatIP);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
