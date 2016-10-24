package org.az.app.confRoomBook.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity(name = "az_crb_employee_conf_room_meeting_entry_details")
public class EmployeeConferenceRoomMeetingEntryDetails implements IPersistable<Long>{

	@Id @GeneratedValue
    @Column(name = "id")	
    private Long id;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="meeting_id", nullable=false)
	private MeetingEntryDetails meetingEntryDetail;	
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="conf_room_id", nullable=false)
	private ConferenceRoom conferenceRoom;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="emp_id", nullable=false)
	private Employee employee; 
    
                   
	public MeetingEntryDetails getMeetingEntryDetail() {
		return meetingEntryDetail;
	}

	public void setMeetingEntryDetail(MeetingEntryDetails meetingEntryDetail) {
		this.meetingEntryDetail = meetingEntryDetail;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ConferenceRoom getConferenceRoom() {
		return conferenceRoom;
	}

	public void setConferenceRoom(ConferenceRoom conferenceRoom) {
		this.conferenceRoom = conferenceRoom;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;		
	}
	
  }
