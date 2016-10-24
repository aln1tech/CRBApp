package org.az.app.confRoomBook.dto;

import java.util.HashSet;
import java.util.Set;

import org.az.app.confRoomBook.dao.EmployeeDao;
import org.az.app.confRoomBook.model.ConferenceRoom;
import org.az.app.confRoomBook.model.Employee;
import org.az.app.confRoomBook.model.MeetingEntryDetails;
import org.az.app.confRoomBook.utils.SuperConverter;

public class ConferenceDaoToDtoConverter implements SuperConverter<ConferenceRoom, ConferenceRoomDto> {

	@Override
	public ConferenceRoomDto apply(ConferenceRoom t) {
		final ConferenceRoomDto a = new ConferenceRoomDto();
		a.setConferenceRoomId(t.getConferenceRoomId());
		a.setConferenceRoomLocation(t.getConferenceRoomLocation());
		a.setConferenceRoomName(t.getConferenceRoomName());
		a.setConferenceRoomStatus(t.isConferenceRoomStatus());
		return a;
	}

}
