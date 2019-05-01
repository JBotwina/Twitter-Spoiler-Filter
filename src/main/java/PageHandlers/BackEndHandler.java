package PageHandlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import backEnd.TwitterExample;
import twitter4j.Status;

public class BackEndHandler {
	private static TwitterExample te;


	public BackEndHandler() {
		te = new TwitterExample();
	}

	public static ArrayList<Status> getBadStatuses() {
		return te.getSpoilerTweets();	
	}
	
	// Melissa (notation so that I don't forget which method I'm working on and don't change Jhon's code -- which I think I already did, but don't quite remember!!)
	public static String fullFeed() {
		String fullStatuses = tweetToString(te.getUnfilteredStatuses());
		return fullStatuses;
	}
	
	public static ArrayList<Status> filteredFeed(String keyword) {
		te.parseTweets(keyword);
		return te.getGoodStatuses();
	}
	
	public static String tweetToString(ArrayList<Status> tweets) {
		StringBuilder tweetData = new StringBuilder();
		
//		tweetData.append("<div><ul>");
		tweetData.append("<div class=\"container\">\r\n" + 
				"  <div class=\"page-header\">\r\n" + 
				"    <h1 id=\"timeline\">Timeline</h1>\r\n" + 
				"  </div>\r\n" + 
				"  <ul class=\"timeline\">");
		for (Status status : tweets) {

//			tweetData.append("<li>User: " + status.getUser().getName() + "</li>");
//			tweetData.append("<li>Created At: " + status.getCreatedAt() + "</li>");
//			tweetData.append("<li>Tweet: " + status.getText() + "<br/><br/></li>");
			
			tweetData.append("<li><div class=\"timeline-badge\"><i class=\"glyphicon glyphicon-check\"></i></div>\r\n" + 
					"      <div class=\"timeline-panel\">\r\n" + 
					"        <div class=\"timeline-heading\">");
			tweetData.append("<h4 class=\"timeline-title\">" + status.getUser().getName() + "</h4>");
			tweetData.append("<p><small class=\"text-muted\"><i class=\"glyphicon glyphicon-time\"></i>" + status.getCreatedAt() + "</small></p>\r\n" + 
					"        </div>");
			tweetData.append("<div class=\"timeline-body\">\r\n" + 
					"          <p>" + status.getText() + "</p>\r\n" + 
							"        </div>\r\n" + 
							"      </div>\r\n" + 
							"    </li>");
			
		}
		tweetData.append("</ul></div>");		
		return tweetData.toString();
	}
	
	public String readHTMLCode(String filename) {
		File myFile = new File("Timeline_Bootstrap_HTML_Code.txt");
		try {
			Scanner s = new Scanner(myFile);
			s.nextLine();
			s.nextLine();
			StringBuilder htmlLine = new StringBuilder();
			while(s.hasNextLine()) {
				htmlLine.append(s.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "";
	}
}
