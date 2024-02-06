package org.java.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.java.dao.EmployeeDao;
import org.java.dto.EmployeeDto;
import org.junit.jupiter.api.Test;

class JUnitTestEmployeeDao {

	@Test
	void selectAll() {

		EmployeeDao dao = EmployeeDao.getInstance();

		List<EmployeeDto> employees = dao.selectAll();

		if (!employees.isEmpty()) {
			for (EmployeeDto em : employees) {
				System.out.print("id: " + em.getEmp_id());
				System.out.print(" name: " + em.getEmp_name());
				System.out.print(" depart: " + em.getEmp_depart());
				System.out.print(" email: " + em.getEmp_email());
				System.out.println(" date: " + em.getDate());
			}

		} else {
			System.out.println("조회할 데이터가 없습니다.");
		}

	}

	@Test
	void emp_depart() {

		EmployeeDao dao = EmployeeDao.getInstance();

		List<EmployeeDto>  lists = dao.emp_depart();

		System.out.println(" 부서별 직원수 ");
		if (!lists.isEmpty()) {
			for (EmployeeDto em : lists) {
				System.out.print(" 부서: " + em.getEmp_depart());
				System.out.println(" 직원수: " + em.getCount());
			}

		} else {
			System.out.println("조회할 데이터가 없습니다.");
		}

	}

}
