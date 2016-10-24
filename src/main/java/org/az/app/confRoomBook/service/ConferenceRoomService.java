package org.az.app.confRoomBook.service;

import org.az.app.confRoomBook.dao.ConferenceRoomDao;
import org.az.app.confRoomBook.model.ConferenceRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceRoomService extends AbstractService<ConferenceRoom, Long> {

    private ConferenceRoomDao repository;


    @Autowired
    public ConferenceRoomService(ConferenceRoomDao repository) {
        super(repository);
        this.repository=repository;
    }

/*    public List<ConferenceRoom> findByName(String name) {
        return conferenceRoomDao.findByName(name);
    }*/
}
