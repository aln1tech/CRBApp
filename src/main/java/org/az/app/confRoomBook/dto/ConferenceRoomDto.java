package org.az.app.confRoomBook.dto;

public class ConferenceRoomDto {

	
    private Long conferenceRoomId;
    private String conferenceRoomName;
    private String conferenceRoomLocation;
    private boolean conferenceRoomStatus;
    
   
	public ConferenceRoomDto() {
		super();
	}
	
	
	public ConferenceRoomDto(Long conferenceRoomId, String conferenceRoomName,
			String conferenceRoomLocation, boolean conferenceRoomStatus) {
		super();
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


	@Override
	public String toString() {
		return "ConferenceRoomDto [conferenceRoomId=" + conferenceRoomId
				+ ", conferenceRoomName=" + conferenceRoomName
				+ ", conferenceRoomLocation=" + conferenceRoomLocation
				+ ", conferenceRoomStatus=" + conferenceRoomStatus + "]";
	}
    
    
	
	
}
