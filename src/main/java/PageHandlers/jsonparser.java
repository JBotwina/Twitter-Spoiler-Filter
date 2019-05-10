package PageHandlers;

import java.io.FileReader;
import java.util.ArrayList;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import org.json.JSONStringer;
import org.json.JSONTokener;
//import org.json.simple.parser.*;

import twitter4j.Status; 

@SuppressWarnings("unused")
public class jsonparser {
	
	public static String parseJson(ArrayList<Status> statuses) {
		ArrayList<String> tweetInfoList = new ArrayList<String>();
		ArrayList<Status> tweets = statuses;
		
		StringBuilder tweetInfo = new StringBuilder();
		
		tweetInfo.append("<div><h3>");
		
		for (Status status : tweets) {
			//read in as input stream
			InputStream tweetText = jsonparser.class.getResourceAsStream(status.getText());
			
			if (tweetText == null) {
		        throw new NullPointerException("Cannot find resource file " + status.getText());
			}
			
			try {
				JSONTokener tweetTokener = new JSONTokener(tweetText);
				JSONObject tweetObject = new JSONObject(tweetTokener);
				
				String userName = tweetObject.getString("user");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return "";
	}

}
