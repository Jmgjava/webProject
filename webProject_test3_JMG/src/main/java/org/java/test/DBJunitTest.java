package org.java.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.java.dao.EmployeeDao;
import org.java.dao.Test_tb2Dao;
import org.java.dto.EmployeeDto;
import org.junit.jupiter.api.Test;

class DBJunitTest {

	@Test
	void selectDepart() {

		Test_tb2Dao dao = Test_tb2Dao.getInstnace();

		List<EmployeeDto> list = dao.selectDepart();

		if (list.isEmpty()) {
			System.out.println("조회할 데이터 없음");
		} else {
			for (EmployeeDto lists : list) {
				System.out.println("부서: " + lists.getEmp_depart());
				System.out.println("직원수: " + lists.getCount());
			}
		}
	}

}
