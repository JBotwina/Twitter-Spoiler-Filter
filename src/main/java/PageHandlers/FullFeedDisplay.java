package PageHandlers;

import spark.Request;
import spark.Response;
import spark.Route;

public class FullFeedDisplay implements Route{
	private final String header = "<h1>Full Twitter Feed</h1>";
	private final String homeButton = "<button type=\"button\" onclick=\"location.href='/'\">Home</button>";
	public Object handle(Request request, Response response) throws Exception {
		
		return header + homeButton;
	}

}
