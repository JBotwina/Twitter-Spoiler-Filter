//can we change teh name of the default package to something else?
// how did we end up with default package vs. a named package?


import spark.Request;
import spark.Response;
import spark.Route;



public class HomePageHandler implements Route {
	String display = "<h1>Hello</h1><p>We are glad you are here.</p>";
	public Object handle(Request request, Response response) throws Exception {
		return display;
	}
	
}
