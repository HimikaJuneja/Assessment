package weatherReporting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class APITesting {

    // http://localhost:8080/RESTfulExample/json/product/get
    public static int apitesting(String city) throws Exception {
    	int temperatureAPI = 0;
      try {

    	URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=a35c7e275dfe5b13bc27cc88489d5d1e&units=metric");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        
        String output;
        //System.out.println("Output from Server .... \n");
       
       output = br.readLine();
       
        JSONParser parser = new JSONParser();  
        JSONObject json = (JSONObject) parser.parse(output);  
        JSONObject temp = (JSONObject) json.get("main");
        String temperature = temp.get("temp").toString(); 
        temperatureAPI = (int)(Float.parseFloat(temperature));
        conn.disconnect();

      } catch (MalformedURLException e) {

        e.printStackTrace();

      } catch (IOException e) {

        e.printStackTrace();

      }
	
	return temperatureAPI;

    }
    
    

}