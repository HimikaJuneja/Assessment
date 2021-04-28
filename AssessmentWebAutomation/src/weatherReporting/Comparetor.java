package weatherReporting;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Comparetor {
	
	
	
	public static void main(String args[]) throws Exception {
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\himjunej\\eclipse-workspace\\AssessmentWebAutomation\\src\\weatherReporting\\Input.json"));
        JSONObject jsonObject = (JSONObject)obj;
        
        //Variance
        long varianceS = (long) jsonObject.get("Variance");
        
        int variance = (int)varianceS;
        //Cities
        JSONArray city = (JSONArray)jsonObject.get("City");
        Iterator cityIterator = city.iterator();
        while (cityIterator.hasNext()) {
        	String location = (String)cityIterator.next();
        	compareUIAPITemperature(location, variance);
        }

		
	}
	
public static void compareUIAPITemperature(String city,int variance) throws Exception{
		
		
		int temperatureAPI = APITesting.apitesting(city) ;
		int temperatureUI = websiteUIAutomation.uiTesting(city);
		try {
		for(int i=variance;i>=0;i--) {
			
		if(temperatureUI - temperatureAPI == 0) {
			 throw new Exception("Matcher Exception  for "+city+"");
		}
		
		
		if(temperatureUI - temperatureAPI == i || temperatureUI - temperatureAPI == -i) {
			System.out.println("Success for "+city+"");
		}
		}
		}catch(Exception e){
			System.out.println("Caught Matcher Exception  for "+city+"");
		}
		
	

}}
