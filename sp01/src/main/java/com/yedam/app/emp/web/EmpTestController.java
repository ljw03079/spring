package com.yedam.app.emp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpTestController {
	@GetMapping("parameterTest")
	public String getMethodTest (EmpVO empVO) {
		System.out.println("get : ");
		System.out.println(empVO);
		return "";
	}
	
	@PostMapping("parameterTest") 
	public String postMethodTest (EmpVO empVO) {
		System.out.println("post : ");
		System.out.println(empVO);
		return "";
	}
}

// 1) Servlet 생성 -> Servlet-Context.xml
				  // Component-Scan의 Bean 등록
				  // annotation-driven의 GetMapping, PostMapping 읽어들임
// 2) Servlet -> Handler Mapping
   // URL : Handler(method)
   // parameterTest + Get
   // EmpTestController.getMethodTest(EmpVO empVO)를 돌려받음
// 3) Servlet -> HandlerAdqpter
   // EmpTestController.getMethodTest(EmpVO empVO)
   // + Request, Response와 같이 정보를 넘김
// 4) Request에서 데이터를 수집하고 해당 메소드가 가지고 있는 매개변수에 담도록 변환작업

// String parameter1 = (String) request.getParameter("employeeId");
// String parameter2 = (String) request.getParameter("lastName");
// String parameter3 = (String) request.getParameter("jobId");
// empVO empVO = new EmpVO();
// empVO.setEmployeeId();

// field가 넘어온 객체와 일치하는 것만 뽑아서 넘겨줌
// get, post의 parameterTest 경로는 같지만 실행하는 코드는 다름
// => 메소드와 경로 둘다 같아야 같은 것으로 봄
// get : 페이지를 불러올 때, post : 데이터를 조작할 때