package org.az.app.confRoomBook.dto;

import java.util.Date;
import java.util.Set;

import org.az.app.confRoomBook.model.ConferenceRoom;
import org.az.app.confRoomBook.model.Employee;

public class MeetingEntryDetailsDto {

    private Long conferenceRoomMeetingId;
	private String meetingSubject;
	private String createdBy;
    private ConferenceRoomDto conferenceRoom;
    private Set<EmployeeDto> employee;
    private String meetingStartTime;
    private String meetingEndTime;
	
    public MeetingEntryDetailsDto() {
	}

  
	public MeetingEntryDetailsDto(Long conferenceRoomMeetingId,
			String meetingSubject, String createdBy,
			ConferenceRoomDto conferenceRoom, Set<EmployeeDto> employee,
			String meetingStartTime, String meetingEndTime) {
		super();
		this.conferenceRoomMeetingId = conferenceRoomMeetingId;
		this.meetingSubject = meetingSubject;
		this.createdBy = createdBy;
		this.conferenceRoom = conferenceRoom;
		this.employee = employee;
		this.meetingStartTime = meetingStartTime;
		this.meetingEndTime = meetingEndTime;
	}

	public Long getConferenceRoomMeetingId() {
		return conferenceRoomMeetingId;
	}


	public void setConferenceRoomMeetingId(Long conferenceRoomMeetingId) {
		this.conferenceRoomMeetingId = conferenceRoomMeetingId;
	}


	public String getMeetingSubject() {
		return meetingSubject;
	}


	public void setMeetingSubject(String meetingSubject) {
		this.meetingSubject = meetingSubject;
	}

	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getMeetingStartTime() {
		return meetingStartTime;
	}


	public void setMeetingStartTime(String meetingStartTime) {
		this.meetingStartTime = meetingStartTime;
	}


	public String getMeetingEndTime() {
		return meetingEndTime;
	}


	public void setMeetingEndTime(String meetingEndTime) {
		this.meetingEndTime = meetingEndTime;
	}


	public ConferenceRoomDto getConferenceRoom() {
		return conferenceRoom;
	}


	public void setConferenceRoom(ConferenceRoomDto conferenceRoom) {
		this.conferenceRoom = conferenceRoom;
	}


	public Set<EmployeeDto> getEmployee() {
		return employee;
	}


	public void setEmployee(Set<EmployeeDto> employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "MeetingEntryDetailsDto [conferenceRoomMeetingId="
				+ conferenceRoomMeetingId + ", meetingSubject="
				+ meetingSubject + ", createdBy=" + createdBy
				+ ", conferenceRoom=" + conferenceRoom + ", employee="
				+ employee + ", meetingStartTime=" + meetingStartTime
				+ ", meetingEndTime=" + meetingEndTime + "]";
	}
	
	

}
