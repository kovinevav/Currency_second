package kovynev.bl;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class Request {
    //http://apilayer.net/api/live?access_key=715a14577ae796b0b078ae081a7b3ff5&currencies=RUB&source=USD&format=1
    public static final String BASE_URL = "http://api.currencylayer.com/";
    public static final String ACCESS_KEY = "715a14577ae796b0b078ae081a7b3ff5";
    public static final String ENDPOINT = "live";
    static final CloseableHttpClient httpClient = HttpClients.createDefault();


    public static long id;
    public static long dateTime;
    public static double usd_rub;
    public static double ma1;
    public static double ma2;
    public static double ma3;

    public long getId() {
        return id;
    }

    public  long getDateTime() {
        return dateTime;
    }

    public double getUsd_rub() {
        return usd_rub;
    }


    public Request() {
        sendLiveRequest();
    }


    public void sendLiveRequest() {
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&currencies=RUB&source=USD&format=1");
        try {
            CloseableHttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));
            dateTime = exchangeRates.getLong("timestamp");
            usd_rub = exchangeRates.getJSONObject("quotes").getDouble("USDRUB");
            Main.usdNow = usd_rub;


        } catch (IOException e) {

        }
    }

}
