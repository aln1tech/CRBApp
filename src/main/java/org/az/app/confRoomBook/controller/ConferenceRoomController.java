package org.az.app.confRoomBook.controller;

import org.az.app.confRoomBook.model.ConferenceRoom;
import org.az.app.confRoomBook.service.ConferenceRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conferenceRoom")
public class ConferenceRoomController extends AbstractController<ConferenceRoom, Long> {

    private ConferenceRoomService service;

    @Autowired
    public ConferenceRoomController(ConferenceRoomService service) {
        super(service);
        this.service=service;
    }

/*    @RequestMapping(value="findByName/{name}", method = RequestMethod.GET)
    public List<ConferenceRoom> findByName(@PathVariable String name) {
        return service.findByName(name);
    }*/
}
