import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class Api {
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();;
    final static String googleDomainUrl = "https://<account>:<password>@domains.google.com/nic/update?hostname=<domain>&myip=<floatIP>";

    public static String getFloatingIp(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        String result = null;
        CloseableHttpResponse response = httpClient.execute(request);
        // Get HttpResponse Status
        System.out.println(response.getStatusLine().toString());

        HttpEntity entity = response.getEntity();

        if (entity != null) {
            // return it as a String
            result = EntityUtils.toString(entity);
            System.out.println(result);
        }

        return result;
    }

    public static void setGoogleDomain(String account, String password, String domain, String floatIp) throws IOException {
        String url = googleDomainUrl.replace("<account>", account);
        url = url.replace("<password>", password);
        url = url.replace("<domain>", domain);
        url = url.replace("<floatIP>", floatIp);
        System.out.println(url);
        CloseableHttpResponse response = httpClient.execute(new HttpGet(url));
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            System.out.println(EntityUtils.toString(entity));
        }
    }
}
