package org.az.app.confRoomBook.dao;

import org.az.app.confRoomBook.model.ConferenceRoom;
import org.az.app.confRoomBook.model.EmployeeConferenceRoomMeetingEntryDetails;
import org.az.app.confRoomBook.model.MeetingEntryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "employeeConferenceRoomMeetingEntryDtlDao")
public interface EmployeeConferenceRoomMeetingEntryDtlDao extends JpaRepository<EmployeeConferenceRoomMeetingEntryDetails, Long> {

    @Query("select a from az_crb_employee_conf_room_meeting_entry_details a where a.meetingEntryDetail=:meetingEntryDetails")
    List<EmployeeConferenceRoomMeetingEntryDetails> findAllMeetingsByMeetingId(@Param("meetingEntryDetails")MeetingEntryDetails meetingId);
}
