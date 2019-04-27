package PageHandlers;

import spark.Request;
import spark.Response;
import spark.Route;

public class FullFeedDisplay implements Route{

	private final String homeButton = "<button type=\"button\" onclick=\"location.href='/'\">Home</button>";
	public Object handle(Request request, Response response) throws Exception {
		
		return homeButton;
	}

}
