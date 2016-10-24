package org.az.app.confRoomBook.dao;

import org.az.app.confRoomBook.model.ConferenceRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "conferenceRoomDao")
public interface ConferenceRoomDao extends JpaRepository<ConferenceRoom, Long> {

/*    @Query("FROM ConferenceRoom where conferenceRoomName like %?1% ")
    List<ConferenceRoom> findByName(String name);
*/}
