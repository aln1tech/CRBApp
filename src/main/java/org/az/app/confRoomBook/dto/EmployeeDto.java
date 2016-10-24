package org.az.app.confRoomBook.dto;

public class EmployeeDto {

    private Long empId;
    private String empName;
    private boolean empStatus;
          
	public EmployeeDto() {
		super();
	}
	public EmployeeDto(Long empId, String empName, boolean empStatus) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empStatus = empStatus;
	}
	
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public boolean isEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(boolean empStatus) {
		this.empStatus = empStatus;
	}
	
	
	@Override
	public String toString() {
		return "EmployeeDto [empId=" + empId + ", empName=" + empName
				+ ", empStatus=" + empStatus + "]";
	}
    
    
}
