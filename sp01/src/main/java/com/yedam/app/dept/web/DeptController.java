package com.yedam.app.dept.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Controller
public class DeptController {
	@Autowired
	DeptService deptService;
	
	// 전체조회
	@GetMapping("deptList")
	public String getDeptList(Model model) {
		List<DeptVO> list = deptService.getDeptAll();
		model.addAttribute("deptList", list);
		return "dept/deptList";
	}
	
	// 단건조회
	@GetMapping("deptInfo")
	public String getDeptInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.getDeptInfo(deptVO);
		model.addAttribute("deptInfo", findVO);
		return "dept/deptInfo";
	}
	
	// 등록 - Form
	@GetMapping("deptInsert")
	public String insertDeptInfoForm() {
		return "dept/deptInsert";
	}
	
	// 등록 - Process
	@PostMapping("deptInsert")
	public String insertDeptInfoProcess(DeptVO deptVO) {
		int deptId = deptService.insertDeptInfo(deptVO);
		
		String path = null;
		if(deptId > -1) {
			path = "redirect:deptInfo?departmentId="+deptId;
		}else {
			path = "redirect:deptList";
		}
		
		return path;
	}
}
