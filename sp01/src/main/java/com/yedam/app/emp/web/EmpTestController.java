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

// 1) Servlet ���� -> Servlet-Context.xml
				  // Component-Scan�� Bean ���
				  // annotation-driven�� GetMapping, PostMapping �о����
// 2) Servlet -> Handler Mapping
   // URL : Handler(method)
   // parameterTest + Get
   // EmpTestController.getMethodTest(EmpVO empVO)�� ��������
// 3) Servlet -> HandlerAdqpter
   // EmpTestController.getMethodTest(EmpVO empVO)
   // + Request, Response�� ���� ������ �ѱ�
// 4) Request���� �����͸� �����ϰ� �ش� �޼ҵ尡 ������ �ִ� �Ű������� �㵵�� ��ȯ�۾�

// String parameter1 = (String) request.getParameter("employeeId");
// String parameter2 = (String) request.getParameter("lastName");
// String parameter3 = (String) request.getParameter("jobId");
// empVO empVO = new EmpVO();
// empVO.setEmployeeId();

// field�� �Ѿ�� ��ü�� ��ġ�ϴ� �͸� �̾Ƽ� �Ѱ���
// get, post�� parameterTest ��δ� ������ �����ϴ� �ڵ�� �ٸ�
// => �޼ҵ�� ��� �Ѵ� ���ƾ� ���� ������ ��
// get : �������� �ҷ��� ��, post : �����͸� ������ ��