package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private int bno;
	private String title;
	private String contents;
	private String writer;
	// DateTimeFormat -> json이면 기본타입이 yyyy-MM-dd이기에 안적어도 되지만 동기방식도 있기때문에 쓸지말지 고려해야함.
	// 무조건 쓰면 서버에서 못받을 수도 있음. 안쓰면 슬러시로 구분
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedate;
	// 서버측에 파일을 저장하고 DB에는 경로저장
	private String image;
}
