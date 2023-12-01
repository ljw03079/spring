package com.yedam.app.emp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.yedam.app.emp.service.EmpVO;

@Mapper
public interface EmpMapper {
	public EmpVO getEmp(EmpVO empVO);
	public List<EmpVO> findEmp(EmpVO empVO);
	public void empInsert(EmpVO empVO);
}