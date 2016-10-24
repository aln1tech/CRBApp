package org.az.app.confRoomBook.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Query;

@Entity(name = "az_crb_meeting_entry_details")
public class MeetingEntryDetails implements IPersistable<Long>{

	@Id @GeneratedValue
    @Column(name = "meeting_id")	
    private Long meetingId;
	
	@Column(name = "meeting_subject")	
    private String meetingSubject;
	
	@Column(name = "created_by")
	private String createdBy;
	
    @Basic(optional = false)
    @Column(name = "meeting_start_time", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)  
    private Date meetingStartTime;
    
    @Basic(optional = false)
    @Column(name = "meeting_end_time", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)  
    private Date meetingEndTime;    
	
    @Basic(optional = false)
    @Column(name = "created_on", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)  
    private Date createdOn;
    
    @Basic(optional = false)    
    @Column(name = "updated_on", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)     
    private Date updatedOn;

    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="meetingEntryDetail",cascade = CascadeType.ALL)
    private Set<EmployeeConferenceRoomMeetingEntryDetails> employeeConferenceRoomMeetingEntryDetails = new HashSet<>(0);
	
    public MeetingEntryDetails() {
	}

  
	public MeetingEntryDetails(Long conferenceRoomMeetingId,String meetingSubject,
			Date meetingStartTime, Date meetingEndTime) {
		super();
		this.meetingId = conferenceRoomMeetingId;
		this.meetingSubject = meetingSubject;
		this.meetingStartTime = meetingStartTime;
		this.meetingEndTime = meetingEndTime;
	}




	public Long getMeetingId() {
		return meetingId;
	}


	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
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


	public Date getMeetingStartTime() {
		return meetingStartTime;
	}


	public void setMeetingStartTime(Date meetingStartTime) {
		this.meetingStartTime = meetingStartTime;
	}


	public Date getMeetingEndTime() {
		return meetingEndTime;
	}


	public void setMeetingEndTime(Date meetingEndTime) {
		this.meetingEndTime = meetingEndTime;
	}


	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		
		this.createdOn = createdOn != null?createdOn:new Date();
	}


	public Date getUpdatedOn() {
		return updatedOn;
	}


	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn != null?updatedOn:new Date();
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
		return meetingId;
	}
	
	@Override
	public void setId(Long id) {
		setMeetingId(id);
	}
   
	
	
	
}
