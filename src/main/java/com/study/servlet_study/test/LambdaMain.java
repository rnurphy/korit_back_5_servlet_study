package com.study.servlet_study.test;

import java.util.function.Consumer;

import com.study.servlet_study.entity.Author;

class Print<T> implements Consumer<T> {
	@Override
	public void accept(T t) {
		System.out.println(t);
	}
}

public class LambdaMain {
	public static void main(String[] args) {
		Consumer<Author> print0 = new Print<>();
		
		Consumer<Author> print1 = new Consumer<Author>() {
			
			@Override
			public void accept(Author author) {
				System.out.println(author);
			}
		};
		Consumer<Author> print2 = (author) -> System.out.println(author);
		
		print0.accept(Author.builder().authorId(1).authorName("김준일").build());
		print1.accept(Author.builder().authorId(2).authorName("김준이").build());
		print2.accept(Author.builder().authorId(3).authorName("김준삼").build());
		
		forEach(print2);
		forEach(author -> {
			System.out.println("<<< test >>>");
			System.out.println(author);
		});
	}
	
	public static void forEach(Consumer<Author> action) {
		action.accept(Author.builder().authorId(4).authorName("김준사").build());
	}
}
