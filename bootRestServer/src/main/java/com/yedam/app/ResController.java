package com.yedam.app;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;
import com.yedam.app.emp.service.GreetingVO;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class ResController {

	@ResponseBody
	@GetMapping("resStr")
	public String resStr() throws InterruptedException {
		Thread.sleep(2000);
		return "str hello!";
	}
	
	@ResponseBody
	@GetMapping("resMap")
	public Map<String, Object> resMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "map hello!");
		return map;
		//return Collections.singletonMap("greeting", "hi!!!");
	}
	
	@ResponseBody
	@GetMapping("resVO")
	public GreetingVO resVO() {
		GreetingVO vo = new GreetingVO();
		vo.setMsg("vo hello!");
		return vo;
	}
	
	//결과 데이터와 상태 코드를 직접 제어( HttpStatus, HttpHeader, HttpBody)
	@GetMapping("resEntity")
	//@ResponseBody
	public ResponseEntity<GreetingVO> resEntity() {
		GreetingVO vo = new GreetingVO();
		vo.setMsg("entity hello!");
		
		ResponseEntity<GreetingVO> entity = new ResponseEntity<>(vo, HttpStatus.BAD_REQUEST);
		return entity;
	}
		
}
