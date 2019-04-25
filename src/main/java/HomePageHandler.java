//can we change teh name of the default package to something else?
// how did we end up with default package vs. a named package?


import spark.Request;
import spark.Response;
import spark.Route;



public class HomePageHandler implements Route {

	@Override
	public Object handle(Request request, Response response) throws Exception {
		return "welcome";
	}
	
}
