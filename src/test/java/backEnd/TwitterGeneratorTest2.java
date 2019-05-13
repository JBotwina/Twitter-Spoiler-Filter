package backEnd;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TwitterGeneratorTest2 {
	
	TwitterGenerator tg = new TwitterGenerator();

	
	@Test
	public void testGetUnfilteredStatuses() {
		assertNotNull(tg.getUnfilteredStatuses());
	}

	@Test
	public void testGetSpoilerTweets() {
		assertNotNull(tg.getSpoilerTweets());
	}

	@Test
	public void testGetGoodStatuses() {
		assertNotNull(tg.getGoodStatuses());
	}

	@Test
	public void testParseTweets() {
		tg.parseTweets("xxxxxxxxx");
		assertNotNull(tg.getGoodStatuses());
	}

	@Test
	public void testCheckIfKeywordsMatchTweetedWord() {
		String[] names = {"james", "melissa", "jhon"};
		assertTrue(tg.checkIfKeywordsMatchTweetedWord("james",names));
	}
	
	@Test
	public void testCheckIfKeywordsMatchTweetedWord2() {
		String[] names = {"james", "melissa", "jhon"};
		assertTrue(!(tg.checkIfKeywordsMatchTweetedWord("steven",names)));
	}
	
	@Test
	public void testCheckIfKeywordsMatchTweetedWord3() {
		String[] name = {"Steven"};
		assertTrue(tg.checkIfKeywordsMatchTweetedWord("steven",name));
	}

}
