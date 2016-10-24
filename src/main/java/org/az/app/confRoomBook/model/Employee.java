package org.az.app.confRoomBook.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name = "az_crb_employee")
public class Employee implements IPersistable<Long>{

    private Long empId;
    private String empName;
    private boolean empStatus;
    
    private Set<EmployeeConferenceRoomMeetingEntryDetails> employeeConferenceRoomMeetingEntryDetails = new HashSet<>(0);
    
	public Employee() {
	}

	public Employee(Long empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}
	
	public Employee(Long empId, String empName, boolean empStatus) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empStatus = empStatus;
	}

	@Id @GeneratedValue
    @Column(name = "emp_id")	
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	@Column(name="emp_name")
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Column(name="emp_status")
	public boolean isEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(boolean empStatus) {
		this.empStatus = empStatus;
	}
	
	 @OneToMany(fetch=FetchType.LAZY, mappedBy="employee")
	public Set<EmployeeConferenceRoomMeetingEntryDetails> getEmployeeConferenceRoomMeetingEntryDetails() {
		return employeeConferenceRoomMeetingEntryDetails;
	}

	public void setEmployeeConferenceRoomMeetingEntryDetails(
			Set<EmployeeConferenceRoomMeetingEntryDetails> employeeConferenceRoomMeetingEntryDetails) {
		this.employeeConferenceRoomMeetingEntryDetails = employeeConferenceRoomMeetingEntryDetails;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empStatus=" + empStatus + "]";
	}

	@Override
	public Long getId() {
		return empId;
	}

	@Override
	public void setId(Long id) {
		this.empId = id;	
	}
   
}
