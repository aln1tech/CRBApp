package org.az.app.confRoomBook.dao;


import org.az.app.confRoomBook.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "employeeDao")
public interface EmployeeDao extends JpaRepository<Employee, Long> {
}
