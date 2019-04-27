package PageHandlers;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * 
 * @author mamaya
 *	handles front end view for user.
 */
public class WelcomePage implements Route {
// why is /n not working??
	private String hello = "Welcome to the Twitter Filter. \n What word(s) do you want to filter out?";
	
	String button = "<button>Show full feed</button>";
	public Object handle(Request request, Response response) throws Exception {
		return button;
	}
	
}
