package org.az.app.confRoomBook.controller;

import org.az.app.confRoomBook.model.Employee;
import org.az.app.confRoomBook.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends AbstractController<Employee, Long> {

    @Autowired
    public EmployeeController(EmployeeService service) {
        super(service);
    }
}
