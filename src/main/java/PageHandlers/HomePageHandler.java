package PageHandlers;


import java.util.ArrayList;

import spark.Request;
import spark.Response;
import spark.Route;


public class HomePageHandler implements Route {
	private String display = "<h1>Hello</h1><p>We are glad you are here.</p>";
	
	public Object handle(Request request, Response response) throws Exception {
		return display;
	}	
}
