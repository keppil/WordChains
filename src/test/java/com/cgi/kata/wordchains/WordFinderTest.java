package com.cgi.kata.wordchains;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WordFinderTest {
	@Test
	public void only_neighboring_words_are_returned() throws Exception {
		Dictionary dictionary = Dictionary.fromFile("test.txt");
		WordFinder wordFinder = new WordFinder(dictionary);
		List<String> nextWords = wordFinder.findNext("car");
		Assert.assertEquals(Arrays.asList("bar", "cat"), nextWords);
	}

	@Test
	public void empty_list_is_returned_if_no_next_word_exists() throws Exception {
		Dictionary dictionary = Dictionary.fromFile("test.txt");
		WordFinder wordFinder = new WordFinder(dictionary);
		List<String> nextWords = wordFinder.findNext("card");
		Assert.assertEquals(Collections.emptyList(), nextWords);
	}
}
