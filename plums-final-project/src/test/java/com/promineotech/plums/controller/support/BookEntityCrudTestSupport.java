package com.promineotech.plums.controller.support;

import java.util.LinkedList;
import java.util.List;

import com.promineotech.plums.entity.Book;
import com.promineotech.plums.entity.Genre;

public class BookEntityCrudTestSupport extends BaseTest {

	protected List<Book> buildProposed() {
		List<Book> list = new LinkedList<>();
		
		// formatter:off
		list.add(Book.builder()
			.isbn("978-0-13-767362-9")
			.genre(Genre.JAVA)
			.title("CORE JAVA: Volume 1: Fundamentals")
			.book_authors("Cay S. Horstmann")
			.notes("12th Edition")
			.build());
		
		list.add(Book.builder()
			.isbn("978-1-1-62315-651-0")
			.genre(Genre.RECIPES)
			.title("Seoul Food Korean Cookbook")
			.book_authors("Naomi Imatome-Yun")
			.notes("12th Edition 2015")
			.build());
		// formatter:on
		
		return list;
	}
}