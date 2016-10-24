package org.az.app.confRoomBook.dto;

import java.util.HashSet;
import java.util.Set;

import org.az.app.confRoomBook.dao.EmployeeDao;
import org.az.app.confRoomBook.model.Employee;
import org.az.app.confRoomBook.model.MeetingEntryDetails;
import org.az.app.confRoomBook.utils.SuperConverter;

public class EmployeeDtoToDaoConverter implements SuperConverter<EmployeeDto, Employee> {

	@Override
	public Employee apply(EmployeeDto t) {
		final Employee a = new Employee();
		a.setEmpId(t.getEmpId());
		a.setEmpName(t.getEmpName());
		a.setEmpStatus(t.isEmpStatus());
		return a;
	}

}
