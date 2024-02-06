package org.java.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.java.dao.EmployeeDao;
import org.java.dto.EmployeeDto;
import org.junit.jupiter.api.Test;

class JUnitTestEmployeeDao {

	@Test
	void employeeSelectAll() {
		EmployeeDao dao = EmployeeDao.getInstance();

		List<EmployeeDto> list = dao.eSelect();

		if (!list.isEmpty()) {

			for (EmployeeDto lists : list) {
				System.out.print("아이디: " + lists.getEmp_id());
				System.out.print("이름: " + lists.getEmp_name());
				System.out.print("부서: " + lists.getEmp_depart());
				System.out.print("이메일: " + lists.getEmp_email());
				System.out.print("날짜: " + lists.getDate());
				System.out.println();
			}

		} else {
			System.out.println("조회 할 데이터가 없습니다.");
		}
	}

}

	