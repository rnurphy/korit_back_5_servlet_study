package com.study.servlet_study.entity;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class Author {
	private int authorId;
	private String authorName;
}
