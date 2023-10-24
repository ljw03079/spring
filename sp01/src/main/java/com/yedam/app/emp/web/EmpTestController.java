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
	// RequestParam : 명시된 파라미터가 없으면 400번 에러
	
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
	// post방식은 무조건 부메랑 또는 화면으로 데이터 보내기
	
	@PostMapping("ajaxJson")
	@ResponseBody
	public EmpVO ajaxJson(@RequestBody EmpVO empVO) {
		return empVO;
	}
	// @RequestBody는 json포맷이며 get방식 불가, 무조건 post방식 (get은 body가 없음)
	// @ResponseBody는 순수하게 데이터를 보내고 싶을때 사용 (비동기통신일때 대응함, view resolver 작동하지 않음)
	
	// 404에러 => 경로 못찾음
	// forward : 내부에서 재요청, 사용자가 모름
	// -> 은행직원이 상사에게 질의 후 클라이언트에게 넘김
	// sendRedirect : 오직 get방식으로 데이터 전달, 재호출, response와 request 깨짐 전달불가, 사용자에게 한번은 돌아감
	// -> 은행직원이 다른부서의 확인필요하다고 전달하여 클라이언트가 해당부서로 찾아감
	// -> addFlashAttribute : Session에 request,response를 담아 화면까지 뿌려줌. 하지만 일회성임.
	
	// * vo, mapper, service, controller, view 생성순서
	// : controller -> service -> mapper -> vo => 누락 발생 가능
	// [1] Table 기준 VO class
	// [2] Table 기준 Mapper : interface -> xml
	// [3] 기능 기준 Service : interface -> 구현class
	// [4] Controller(경로, 기능, 화면 세가지를 묶어줌 / 통신)
	// [5] View
	// 테이블 기준으로 Service(기능)를 만들면 안됨, mapper는 테이블 기준 
	// 정리: mapper => 테이블 기준 / service => 기능 기준 / controller => 통신 기준
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