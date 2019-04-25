import spark.Request;
import spark.Response;
import spark.Route;

public class WelcomePage implements Route {

	private String hello = "Welcome to the Twitter Filter. /nWhat word(s) do you want to filter out?";
	

	//@Override  what's the deal with this??  
	
	public Object handle(Request request, Response response) throws Exception {
		return hello;
	}
	
}
