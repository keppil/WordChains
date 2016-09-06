package com.cgi.kata.wordchains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordFinder {

	private Dictionary dictionary;

	public WordFinder(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public List<String> findNext(String word) {
		List<String> nextWords = new ArrayList<>();
		for (int index = 0; index < word.length(); index++) {
			for (char letter = 'a'; letter <= 'z'; letter++) {
				if (letter == word.charAt(index)) {
					continue;
				}
				String newWord = createNewWord(word, index, letter);
				if (dictionary.contains(newWord)) {
					nextWords.add(newWord);
				}
			}
		}
		return nextWords;
	}

	private String createNewWord(String word, int index, char letter) {
		return new StringBuilder(word.substring(0, index)).append(letter).append(word.substring(index + 1, word.length())).toString();
	}

}
