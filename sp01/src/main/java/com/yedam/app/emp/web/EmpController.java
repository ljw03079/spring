package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	// GET  : 조회, 페이지 호출
	// POST : 데이터 조작관련 기능(등록, 수정, 삭제)
	
	// 전체조회
	@GetMapping("empList")
	public String getEmpList(Model model) {
		List<EmpVO> list = empService.getEmpAll();
		model.addAttribute("empList", list);
		return "emp/empList";
	}
	
	// 사원조회
	@GetMapping("empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.getEmpInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "emp/empInfo";
	}
	
	// 등록 - Form
	@GetMapping("empInsert")
	public String insertEmpInfoForm() {
		return "emp/empInsert";
	}
	
	// 등록 - Process
	@PostMapping("empInsert")
	public String insertEmpInfoProcess(EmpVO empVO) {
		int empId = empService.insertEmpInfo(empVO);
		
		String path = null;
		if(empId > -1) {
			path = "redirect:empInfo?employeeId="+empId;
		}else {
			path = "redirect:empList";
		}
		
		return path;
	}
	
	// Page를 호출할 때 Model 필요 Ajax는 직접 데이터 변경시키기 때문에 Model 불필요
	// 수정 - Process => Ajax : @ResponseBody(데이터 전송 시 사용)
	// 객체, 리스트 타입을 돌려줄때 제이슨으로 변환
	// 1)					+ QueryString => 커맨드 객체
	@PostMapping("empUpdate")
	@ResponseBody
	public Map<String, Object> empUpdateProcess(EmpVO empVO){
		return empService.updateEmpInfo(empVO);
	}
	
	// 2)					+ JSON => @RequestBody
	@PostMapping("empUpdateAjax")
	@ResponseBody
	public Map<String, Object> empUpdateAjaxProcess(@RequestBody EmpVO empVO){
		return empService.updateEmpInfo(empVO);
	}
	
	// 삭제
	@GetMapping("empDelete")
	// 매개변수 타입 int -> 오류나는 경우가 있어서 Integer 사용
	public String empDeletePreocess(@RequestParam Integer employeeId,
									RedirectAttributes ratt) {
		boolean result = empService.deleteEmpInfo(employeeId);
		String msg = null;
		if(result) {
			msg = "정상적으로 삭제되었습니다.\n삭제대상 : "+employeeId;
		}else {
			msg = "정상적으로 삭제되지않았습니다.\n정보를 확인해주시기바랍니다.\n삭제요청 : "+employeeId;
		}
		// 새로고침 시 사라짐, 1회성
		ratt.addFlashAttribute("result", msg);
		return "redirect:empList";
	}
	
}

// Same Origin Policy, CORS -> 화면과 관련, 브라우저 정책
// <CORS>
// [1] Server => Spring Security
// [2] client => Server끼리 통신
// --> java의 HTTP 서버 통신
// javascript에서 ajax로 서버 통신하는 방법뿐만 아니라 java에서도 서버 통신 가능