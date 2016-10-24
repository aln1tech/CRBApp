package org.az.app.confRoomBook.dao;

import org.az.app.confRoomBook.model.ConferenceRoom;
import org.az.app.confRoomBook.model.EmployeeConferenceRoomMeetingEntryDetails;
import org.az.app.confRoomBook.model.MeetingEntryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository(value = "meetingEntryDetailsDao")
public interface MeetingEntryDetailsDao extends JpaRepository<MeetingEntryDetails, Long> {


/*	@Query("select a from MeetingEntryDetails a , EmployeeConferenceRoomMeetingEntryDetails b where a.meetingId = b.meetingEntryDetail and b.conferenceRoom=:conferenceRoom "
			+ "			and (a.meetingStartTime <= :meetingStartTime or a.meetingstarttime between :meetingStartTime and :meetingEndTime)"
			+ "			and (a.meetingendtime >= :meetingEndTime or a.meetingendtime between :meetingStartTime and :meetingEndTime)")
			public List<MeetingEntryDetails> findRoomAvailablity(@Param("conferenceRoom") ConferenceRoom conferenceRoom,@Param("meetingStartTime")Date meetingStartTime,@Param("meetingEndTime")Date meetingEndTime);
*/
	@Query("select a from az_crb_meeting_entry_details a , az_crb_employee_conf_room_meeting_entry_details b where a.meetingId = b.meetingEntryDetail and b.conferenceRoom=:conferenceRoom "
			+ "			and (a.meetingStartTime <= :meetingStartTime or a.meetingStartTime between :meetingStartTime and :meetingEndTime)"
			+ "			and (a.meetingEndTime >= :meetingEndTime or a.meetingEndTime between :meetingStartTime and :meetingEndTime)")
			public List<MeetingEntryDetails> findRoomAvailablity(@Param("conferenceRoom") ConferenceRoom conferenceRoom,@Param("meetingStartTime")Date meetingStartTime,@Param("meetingEndTime")Date meetingEndTime);

	@Query("select a from az_crb_meeting_entry_details a , az_crb_employee_conf_room_meeting_entry_details b where a.meetingId = b.meetingEntryDetail and b.conferenceRoom=:conferenceRoom "
			+ "			and (a.meetingStartTime <= :meetingStartTime or a.meetingStartTime between :meetingStartTime and :meetingEndTime)"
			+ "			and (a.meetingEndTime >= :meetingEndTime or a.meetingEndTime between :meetingStartTime and :meetingEndTime) and a.meetingId not in (:meetingId)")
			public List<MeetingEntryDetails> findRoomAvailablityExceptMeetingId(@Param("conferenceRoom") ConferenceRoom conferenceRoom,@Param("meetingStartTime")Date meetingStartTime,@Param("meetingEndTime")Date meetingEndTime,@Param("meetingId")long meetingId);
}
