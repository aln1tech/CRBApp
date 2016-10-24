package org.az.app.confRoomBook.dto;

import java.util.HashSet;
import java.util.Set;

import org.az.app.confRoomBook.dao.EmployeeDao;
import org.az.app.confRoomBook.model.Employee;
import org.az.app.confRoomBook.model.MeetingEntryDetails;
import org.az.app.confRoomBook.utils.SuperConverter;

public class EmployeeDaoToDtoConverter implements SuperConverter<Employee, EmployeeDto> {

	@Override
	public EmployeeDto apply(Employee t) {
		final EmployeeDto dto = new EmployeeDto();
		dto.setEmpId(t.getEmpId());
		dto.setEmpName(t.getEmpName());
		dto.setEmpStatus(t.isEmpStatus());
		return dto;
	}

}
