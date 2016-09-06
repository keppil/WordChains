package com.cgi.kata.wordchains;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.cgi.kata.wordchains.exceptions.EmptyFileException;
import com.cgi.kata.wordchains.exceptions.NoFileFoundException;

public class Dictionary {

	private List<String> lines;

	public Dictionary(List<String> lines) {
		this.lines = lines;

	}

	public static Dictionary fromFile(String frequencyFile) {
		List<String> lines = null;
		try {
			URL resource = Dictionary.class.getClassLoader().getResource(frequencyFile);
			if (resource == null) {
				throw new NoFileFoundException();
			}
			Path filePath = Paths.get(resource.toURI());
			lines = Files.readAllLines(filePath, Charset.forName("UTF-8"));
			if (lines.isEmpty()) {
				throw new EmptyFileException();
			}
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
		return new Dictionary(lines);
	}

	public boolean contains(String word) {
		return lines.contains(word);
	}

}
