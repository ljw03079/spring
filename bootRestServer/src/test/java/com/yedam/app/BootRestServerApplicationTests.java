package com.yedam.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.app.emp.service.GreetingVO;
import com.yedam.app.emp.service.MemberVO;

@SpringBootTest
class BootRestServerApplicationTests {

	//@Test
	void jacksonTest() throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		GreetingVO vo = new GreetingVO("hello","철수");
		String str = om.writeValueAsString(vo);
		System.out.println(str);
		assertThat(str.startsWith("{"));
		//@ResponseBody : ��ü(vo = map, List) => json String
	}
	
	//@Test
	void mapTest() throws JsonProcessingException {
		HashMap<String, Object> map = new HashMap<>();
		map.put("firstName", "�浿");
		map.put("dept", 10);
		map.put("hobby", new String[] {"����","����"});
		
		// {firtsName:"�浿", dept:10, hobby:["����","����"]}
		ObjectMapper om = new ObjectMapper();
		String str = om.writeValueAsString(map);
		System.out.println(str);
	}
	
	//@Test
	void jacksonReadTest() throws JsonMappingException, JsonProcessingException {
		String str = "{\"msg\":\"hello\",\"name\":\"철수\"}";
		ObjectMapper om = new ObjectMapper();
		GreetingVO vo = om.readValue(str, GreetingVO.class);
		System.out.println(vo);
		assertThat(vo.getMsg().equals("hello"));
		// @RequestBody json String ==> ��ü({} => vo, map)
		// 									[] => list
	}
	
	@Test
	void readTest() throws JsonMappingException, JsonProcessingException {
		String str = "{\"firstName\":\"�浿\",\"dept\":10,\"hobby\":[\"����\",\"����\"]}";
		ObjectMapper om = new ObjectMapper();
		MemberVO vo = om.readValue(str, MemberVO.class);
		System.out.println(vo);
	}
}
