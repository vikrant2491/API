package com.vikrant.test.framework.api.pojo;

import java.util.List;

public class Library{
	private List<Book> books;
	
	public Library(){
		
	}

	public Library(List<Book> books) {
		super();
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	@Override
	public String toString(){
		StringBuilder str= new StringBuilder();
		for(Book b: books){
			str.append(b.toString());
		}
		return str.toString();
	}
	
	
}

