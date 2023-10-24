package com.yedam.app.emp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpTestController {
	@GetMapping("parameterTest")
	public String getMethodTest (EmpVO empVO) {
		System.out.print("get : ");
		System.out.println(empVO);
		return "";
	}
	
	@PostMapping("parameterTest") 
	public String postMethodTest (EmpVO empVO) {
		System.out.print("post : ");
		System.out.println(empVO);
		return "";
	}
	
	@GetMapping("reqParamTest")
	public String reqParamGet (String employeeId, String lastName) {
		System.out.print("get : ");
		System.out.printf("%s, %s\n",employeeId, lastName);
		return "";
	}
	
	@PostMapping("reqParamTest")
	public String reqParamPost (@RequestParam String employeeId,
								@RequestParam(defaultValue = "guest") String lastName) {
		System.out.print("post : ");
		System.out.printf("%s, %s\n",employeeId, lastName);
		return "";
	}
	// RequestParam : ��õ� �Ķ���Ͱ� ������ 400�� ����
	
	@GetMapping("pathGet/{employeeId}")
	public String pathGet(@PathVariable String employeeId) {
		System.out.print("get : ");
		System.out.printf("%s\n", employeeId);
		return "";
	}
	
	@PostMapping("pathPost/{id}")
	public String pathPost(@PathVariable(name = "id") String employeeId) {
		System.out.print("post : ");
		System.out.printf("%s\n", employeeId);
		return "";
	}
	// post����� ������ �θ޶� �Ǵ� ȭ������ ������ ������
	
	@PostMapping("ajaxJson")
	@ResponseBody
	public EmpVO ajaxJson(@RequestBody EmpVO empVO) {
		return empVO;
	}
	// @RequestBody�� json�����̸� get��� �Ұ�, ������ post��� (get�� body�� ����)
	// @ResponseBody�� �����ϰ� �����͸� ������ ������ ��� (�񵿱�����϶� ������, view resolver �۵����� ����)
	
	// 404���� => ��� ��ã��
	// forward : ���ο��� ���û, ����ڰ� ��
	// -> ���������� ��翡�� ���� �� Ŭ���̾�Ʈ���� �ѱ�
	// sendRedirect : ���� get������� ������ ����, ��ȣ��, response�� request ���� ���޺Ұ�, ����ڿ��� �ѹ��� ���ư�
	// -> ���������� �ٸ��μ��� Ȯ���ʿ��ϴٰ� �����Ͽ� Ŭ���̾�Ʈ�� �ش�μ��� ã�ư�
	// -> addFlashAttribute : Session�� request,response�� ��� ȭ����� �ѷ���. ������ ��ȸ����.
	
	// * vo, mapper, service, controller, view ��������
	// : controller -> service -> mapper -> vo => ���� �߻� ����
	// [1] Table ���� VO class
	// [2] Table ���� Mapper : interface -> xml
	// [3] ��� ���� Service : interface -> ����class
	// [4] Controller(���, ���, ȭ�� �������� ������ / ���)
	// [5] View
	// ���̺� �������� Service(���)�� ����� �ȵ�, mapper�� ���̺� ���� 
	// ����: mapper => ���̺� ���� / service => ��� ���� / controller => ��� ����
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