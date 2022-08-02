package com.korea.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO2 {
	private String title;
	
	@DateTimeFormat(pattern="yyyy/MM/dd/hh/mm/ss")
	private Date date;
}
