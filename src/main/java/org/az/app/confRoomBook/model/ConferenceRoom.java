package org.az.app.confRoomBook.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name = "az_crb_conference_room")
public class ConferenceRoom implements IPersistable<Long>{

	@Id @GeneratedValue
    @Column(name = "conf_room_id")	
    private Long conferenceRoomId;
	@Column(name = "conf_room_name")	
    private String conferenceRoomName;
	@Column(name = "conf_room_location")
    private String conferenceRoomLocation;
	@Column(name = "conf_room_status")	
    private boolean conferenceRoomStatus;
	
    @OneToMany(fetch=FetchType.LAZY, mappedBy="conferenceRoom")
    private Set<EmployeeConferenceRoomMeetingEntryDetails> employeeConferenceRoomMeetingEntryDetails = new HashSet<>(0);
	
    public ConferenceRoom() {
	}

	public ConferenceRoom(Long conferenceRoomId, String conferenceRoomName,
			String conferenceRoomLocation, boolean conferenceRoomStatus) {
		this.conferenceRoomId = conferenceRoomId;
		this.conferenceRoomName = conferenceRoomName;
		this.conferenceRoomLocation = conferenceRoomLocation;
		this.conferenceRoomStatus = conferenceRoomStatus;
	}

	public Long getConferenceRoomId() {
		return conferenceRoomId;
	}

	public void setConferenceRoomId(Long conferenceRoomId) {
		this.conferenceRoomId = conferenceRoomId;
	}

	public String getConferenceRoomName() {
		return conferenceRoomName;
	}

	public void setConferenceRoomName(String conferenceRoomName) {
		this.conferenceRoomName = conferenceRoomName;
	}

		
	public String getConferenceRoomLocation() {
		return conferenceRoomLocation;
	}

	public void setConferenceRoomLocation(String conferenceRoomLocation) {
		this.conferenceRoomLocation = conferenceRoomLocation;
	}

	
	public boolean isConferenceRoomStatus() {
		return conferenceRoomStatus;
	}

	public void setConferenceRoomStatus(boolean conferenceRoomStatus) {
		this.conferenceRoomStatus = conferenceRoomStatus;
	}
	    
	
	public Set<EmployeeConferenceRoomMeetingEntryDetails> getEmployeeConferenceRoomMeetingEntryDetails() {
		return employeeConferenceRoomMeetingEntryDetails;
	}

	public void setEmployeeConferenceRoomMeetingEntryDetails(
			Set<EmployeeConferenceRoomMeetingEntryDetails> employeeConferenceRoomMeetingEntryDetails) {
		this.employeeConferenceRoomMeetingEntryDetails = employeeConferenceRoomMeetingEntryDetails;
	}

	@Override
	public Long getId() {
		return conferenceRoomId;
	}
	
	@Override
	public void setId(Long id) {
		this.conferenceRoomId = id;	
	}
   
}
