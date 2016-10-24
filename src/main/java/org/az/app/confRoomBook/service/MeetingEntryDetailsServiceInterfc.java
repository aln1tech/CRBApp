package org.az.app.confRoomBook.service;

import java.util.List;

import org.az.app.confRoomBook.dto.MeetingEntryDetailsDto;

public interface MeetingEntryDetailsServiceInterfc {

	public List<MeetingEntryDetailsDto> fetchAllMeetings();
	public MeetingEntryDetailsDto createNewMeetingReq(MeetingEntryDetailsDto meetingEntryDetailsDto);
	public MeetingEntryDetailsDto updateMeetingReq(MeetingEntryDetailsDto meetingEntryDetailsDto);
	public boolean removeMeetingReq(Long meetingId);
//	public MeetingEntryDetailsDto MeetingReq(MeetingEntryDetailsDto meetingEntryDetailsDto);
}
