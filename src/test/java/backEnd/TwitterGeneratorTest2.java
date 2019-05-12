package backEnd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwitterGeneratorTest2 {
	
	TwitterGenerator tg = new TwitterGenerator();

	
	@Test
	void testGetUnfilteredStatuses() {
		assertNotNull(tg.getUnfilteredStatuses());
	}

	@Test
	void testGetSpoilerTweets() {
		assertNotNull(tg.getSpoilerTweets());
	}

	@Test
	void testGetGoodStatuses() {
		assertNotNull(tg.getGoodStatuses());
	}

	@Test
	void testParseTweets() {
		tg.parseTweets("xxxxxxxxx");
		assertNotNull(tg.getGoodStatuses());
	}

	@Test
	void testCheckIfKeywordsMatchTweetedWord() {
		String[] names = {"james", "melissa", "jhon"};
		assertTrue(tg.checkIfKeywordsMatchTweetedWord("james",names));
	}
	
	@Test
	void testCheckIfKeywordsMatchTweetedWord2() {
		String[] names = {"james", "melissa", "jhon"};
		assertTrue(!(tg.checkIfKeywordsMatchTweetedWord("steven",names)));
	}
	
	@Test
	void testCheckIfKeywordsMatchTweetedWord3() {
		String[] name = {"Steven"};
		assertTrue(tg.checkIfKeywordsMatchTweetedWord("steven",name));
	}

}
