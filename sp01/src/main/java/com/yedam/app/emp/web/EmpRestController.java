package com.yedam.app.emp.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

// 페이지 반환 안됨
@RestController
public class EmpRestController {
	
	@Autowired
	EmpService empService;
	
	// 전체조회
	@GetMapping("emps")
	public List<EmpVO> selectEmpAll() {
		return empService.getEmpAll();
	}
	
	// 단건조회
	// Rest 특징 : queryString 쓰지 않음 -> pathVariable 사용
	@GetMapping("emps/{eid}")
	public EmpVO selectEmpInfo(@PathVariable Integer eid) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(eid);
		return empService.getEmpInfo(empVO);
	}
	
	// 등록
	// 데이터 주고받을 때 기본이 json
	@PostMapping("emps")
	public Map<String, Object> insertEmpInfo(@RequestBody EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		
		String msg = null;
		int employeeId = empService.insertEmpInfo(empVO);
		if(employeeId > -1) {
			msg = "success";
		}else {
			msg = "fail";
		}
		
		map.put("result", msg);
		map.put("employee_id", employeeId);
		
		return map;
	}
	
	// 수정
	// PathVariable 쓸 때도 있고 쓰지 않을 때도 있지만 요즘에는 쓰는 추세.
	// Put : 전체데이터 받아서 수정할 부분 변경 후 전체데이터 전송
	@PutMapping("emps/{eid}")
	public Map<String, Object> updateEmpInfo(@PathVariable("eid") Integer employeeId, @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(employeeId);
		return empService.updateEmpInfo(empVO);
	} 
	
	// 삭제
	@DeleteMapping("emps/{eid}")
	public Map<String, Object> deleteEmpInfo(@PathVariable("eid") Integer employeeId) {
		Map<String, Object> map = new HashMap<>();
		map.put("result", empService.deleteEmpInfo(employeeId));
		map.put("target", employeeId);
		return map;
	}
	
	// 경로는 같더라도 Method가 get post put delete 다름.
	// EmpController에서는 경로가 다달랐음.
}