package com.cgi.kata.wordchains;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import com.cgi.kata.wordchains.exceptions.EmptyFileException;
import com.cgi.kata.wordchains.exceptions.NoFileFoundException;

public class DictionaryTest {
	@Test
	public void test_file_contains_cat() throws Exception {
		Dictionary dict = Dictionary.fromFile("test.txt");
		Assert.assertTrue(dict.contains("cat"));
	}

	@Test
	public void test_file_does_not_contain_beer() throws Exception {
		Dictionary dict = Dictionary.fromFile("test.txt");
		Assert.assertFalse(dict.contains("beer"));
	}

	@Test(expected=EmptyFileException.class)
	public void fromFile_throws_exception_if_file_is_empty() throws Exception {
		Dictionary.fromFile("empty.txt");
	}
	
	@Test(expected=NoFileFoundException.class)
	public void fromFile_throws_file_not_found_exception_if_file_is_not_found() throws Exception {
		Dictionary.fromFile("blabla.txy");
	}
}
