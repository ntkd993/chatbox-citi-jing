package com.citi.innovation;

import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.innovation.nlp.NLPProcessor;
import com.citi.innovation.nlp.tools.CBLemmatizer;
import com.citi.innovation.nlp.tools.CBTokenizer;

public class NLPTest {
	@Before
	public void mockup() {

	}

	@Test
	public void test() {
		String input = "Would you please help to grant permission.";
		System.out.println("input: " + input);
		Map<String, String> vn = NLPProcessor.findVBNNpair(input);
		for (Map.Entry<String, String> entry : vn.entrySet()) {
			String verb = entry.getKey();
			String noun = entry.getValue();
			System.out.println("vn set - verb: " + verb + " noun: " + noun);
		}
		Assert.assertTrue(!vn.isEmpty());
	}

	@Test
	public void testTokens() {
		String[] tokens = CBTokenizer.tokens("Would you please help to grant permission.");
		for (String s : tokens) {
			System.out.println(s);
		}
		Assert.assertTrue(true);
	}

	@Test
	public void testLemma() {
		String[] tokens = new String[] { "Would", "you", "please", "help", "to", "grant", "permission", "¡£" };
		String[] tags = CBLemmatizer.tags(tokens);
		String[] lemmas = CBLemmatizer.lemmatize(tokens, tags);
		System.out.println("tags: ");
		for (String s : tags) {
			System.out.println(s);
		}
		System.out.println("\nlemmas: ");
		for (String s : lemmas) {
			System.out.println(s);
		}
		Assert.assertTrue(true);
	}

	@After
	public void cleanup() {

	}
}
