package org.az.app.confRoomBook.service;

import org.az.app.confRoomBook.dao.EmployeeDao;
import org.az.app.confRoomBook.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends AbstractService<Employee, Long> {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        super(employeeDao);
        this.employeeDao=employeeDao;

    }

}
