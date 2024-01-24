package com.study.servlet_study.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
	private int bookId;
	private String bookName;
	private Author author;
	private Publisher publisher;
}
