package org.az.app.confRoomBook.dto;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import org.az.app.confRoomBook.model.Employee;
import org.az.app.confRoomBook.model.MeetingEntryDetails;
import org.az.app.confRoomBook.utils.DateUtil;
import org.az.app.confRoomBook.utils.SuperConverter;
import org.az.app.confRoomBook.utils.DateUtil.SimpleDateFormatEnum;

public class MeetingEntryDtlsDaoToDtoConverter implements SuperConverter<MeetingEntryDetails, MeetingEntryDetailsDto> {

	@Override
	public MeetingEntryDetailsDto apply(MeetingEntryDetails t) {
		final MeetingEntryDetailsDto detailsDto = new MeetingEntryDetailsDto();
		
		detailsDto.setConferenceRoomMeetingId(t.getId());
		Set<Employee> employees = new HashSet<>();
		t.getEmployeeConferenceRoomMeetingEntryDetails().forEach(k->{
			
			detailsDto.setConferenceRoom(new ConferenceDaoToDtoConverter().apply(k.getConferenceRoom()));
			employees.add(k.getEmployee());			
		});
		
		detailsDto.setMeetingSubject(t.getMeetingSubject());
		try {
			detailsDto.setMeetingStartTime(DateUtil.convertStrFromDate(t.getMeetingStartTime(), SimpleDateFormatEnum.yyyyMMMdd_HHMM));
			detailsDto.setMeetingEndTime(DateUtil.convertStrFromDate(t.getMeetingEndTime(), SimpleDateFormatEnum.yyyyMMMdd_HHMM));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return detailsDto;
	}

}
