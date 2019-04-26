package backEnd;

import twitter4j.*;
import java.util.*;

public class Test_Call {

	public Test_Call() {
		
	}
	
	public static void main(String[] args) {
		Twitter twitter = TwitterFactory.getSingleton();
		try {
			List<Status> statuses = twitter.getHomeTimeline();
			System.out.println("Showing home timeline");
			int count = 0;
			for (Status status : statuses) {
				System.out.println(status.getUser().getName() + ":" + status.getText());
				count++;
			}
			System.out.println("number of tweets " + count);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
