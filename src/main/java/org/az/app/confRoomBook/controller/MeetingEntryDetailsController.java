package org.az.app.confRoomBook.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletRequest;

import org.az.app.confRoomBook.dto.ConferenceRoomDto;
import org.az.app.confRoomBook.dto.EmployeeDto;
import org.az.app.confRoomBook.dto.MeetingEntryDetailsDto;
import org.az.app.confRoomBook.exception.MeetingEntryDtlServiceException;
import org.az.app.confRoomBook.model.ConferenceRoom;
import org.az.app.confRoomBook.model.Employee;
import org.az.app.confRoomBook.service.AbstractService;
import org.az.app.confRoomBook.service.MeetingEntryDetailsServiceImpl;
import org.az.app.confRoomBook.service.MeetingEntryDetailsServiceInterfc;
import org.az.app.confRoomBook.utils.DateUtil;
import org.az.app.confRoomBook.utils.DateUtil.SimpleDateFormatEnum;
import org.az.app.confRoomBook.utils.enums.ApplicationStatusCode;
import org.az.app.confRoomBook.utils.model.ErrorBean;
import org.az.app.confRoomBook.utils.model.Response;
import org.az.app.confRoomBook.utils.model.Warning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/bookMeeting")
public class MeetingEntryDetailsController {// extends AbstractController<MeetingEntryDetailsDto, Long>{
	
	@Autowired
	MeetingEntryDetailsServiceInterfc meetingEntryDetailsService;
	
/*	public MeetingEntryDetailsController(MeetingEntryDetailsServiceInterfc service) {
        super(service);
        this.meetingEntryDetailsService=service;
	}*/

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/newMeetingReq", method = { RequestMethod.POST, RequestMethod.OPTIONS})
    public Response<MeetingEntryDetailsDto> createNewMeetingRequest(@RequestBody MeetingEntryDetailsDto meetingEntryDetailsDto, ServletRequest request) {

		Response<MeetingEntryDetailsDto> response = new Response<>();
		 
		logger.info("New Meeting Request Received {}",meetingEntryDetailsDto.toString());
		
/*		ConferenceRoomDto conferenceRoom = new ConferenceRoomDto();
		conferenceRoom.setConferenceRoomId(1l);
		
		EmployeeDto employee = new EmployeeDto();
		employee.setEmpId(1l);
		EmployeeDto employee2 = new EmployeeDto();
		employee2.setEmpId(2l);
		
		Set<EmployeeDto> employees  = new HashSet<>();
		employees.add(employee2);
		
		meetingEntryDetailsDto = new MeetingEntryDetailsDto();
		
		meetingEntryDetailsDto.setConferenceRoom(conferenceRoom);
		meetingEntryDetailsDto.setCreatedBy("Admin");
		meetingEntryDetailsDto.setEmployee(employees);
		try {
			meetingEntryDetailsDto.setMeetingStartTime(DateUtil.convertDateFromStr("2016-10-24 13:00", SimpleDateFormatEnum.yyyyMMMdd_HHMM));
			meetingEntryDetailsDto.setMeetingEndTime(DateUtil.convertDateFromStr("2016-10-24 15:00", SimpleDateFormatEnum.yyyyMMMdd_HHMM));
		} catch (ParseException e1) {
			response.setFailure(new ErrorBean(ApplicationStatusCode.APPLICATIONERROR));
			e1.printStackTrace();
		}
		
		meetingEntryDetailsDto.setMeetingStartTime("2016-10-24 13:00");
		meetingEntryDetailsDto.setMeetingEndTime("2016-10-24 15:00");
		
		*/
		
		try
		{
			response.setSuccess(meetingEntryDetailsService.createNewMeetingReq(meetingEntryDetailsDto));
		}
		catch(MeetingEntryDtlServiceException e)
		{
			response.setFailure(new ErrorBean(ApplicationStatusCode.NOTSUPPORTED,e.getMessage()));	
		}
		catch(Exception e)
		{
			response.setFailure(new ErrorBean(ApplicationStatusCode.APPLICATIONERROR));
			e.printStackTrace();
		}
		
		logger.info("Request Controller Response:"+response.toString());
		
		return response; 
    }	
	
	@RequestMapping(value = "/udateMeetingReq", method = { RequestMethod.POST, RequestMethod.OPTIONS})
    public Response<MeetingEntryDetailsDto> udateMeetingReq(@RequestBody MeetingEntryDetailsDto meetingEntryDetailsDto, ServletRequest request) {
		Response<MeetingEntryDetailsDto> response = new Response<>();
		
		logger.info("Update Meeting Request Received {}",meetingEntryDetailsDto.toString());
		
/*		ConferenceRoomDto conferenceRoom = new ConferenceRoomDto();
		conferenceRoom.setConferenceRoomId(1l);
		
		EmployeeDto employee = new EmployeeDto();
		employee.setEmpId(1l);
		EmployeeDto employee2 = new EmployeeDto();
		employee2.setEmpId(2l);
		
		Set<EmployeeDto> employees  = new HashSet<>();
		employees.add(employee);
		employees.add(employee2);
		
		meetingEntryDetailsDto = new MeetingEntryDetailsDto();
		
		meetingEntryDetailsDto.setConferenceRoomMeetingId(1l);
		meetingEntryDetailsDto.setConferenceRoom(conferenceRoom);
		meetingEntryDetailsDto.setCreatedBy("Admin");
		meetingEntryDetailsDto.setMeetingSubject("AngularJS-2 Session");
		meetingEntryDetailsDto.setEmployee(employees);
		
		meetingEntryDetailsDto.setMeetingStartTime("2016-10-24 13:30");
		meetingEntryDetailsDto.setMeetingEndTime("2016-10-24 15:00");*/
		
		try
		{
			response.setSuccess(meetingEntryDetailsService.updateMeetingReq(meetingEntryDetailsDto));
		}
		catch(MeetingEntryDtlServiceException e)
		{
			response.setFailure(new ErrorBean(ApplicationStatusCode.NOTSUPPORTED,e.getMessage()));	
		}
		catch(Exception e)
		{
			response.setFailure(new ErrorBean(ApplicationStatusCode.APPLICATIONERROR));
			e.printStackTrace();
		}
		
		return response;
	}
	
	@RequestMapping(value = "/removeMeetingReq/{meetingId}", method = { RequestMethod.DELETE, RequestMethod.OPTIONS})
    public Response<String> removeMeetingReq(@PathVariable long meetingId,ServletRequest request) {
		Response<String> response = new Response<>();
		
		logger.info("Delete Meeting Request Received {}",meetingId);
		
		try
		{
			response.setSuccess(String.valueOf(meetingEntryDetailsService.removeMeetingReq(meetingId)));
		}
		catch(MeetingEntryDtlServiceException e)
		{
			response.setFailure(new ErrorBean(ApplicationStatusCode.NOTSUPPORTED,e.getMessage()));	
		}
		catch(Exception e)
		{
			response.setFailure(new ErrorBean(ApplicationStatusCode.APPLICATIONERROR));
			e.printStackTrace();
		}
		
		return response;
	}	
	@RequestMapping(value = "/fetchAllMeetings", method = { RequestMethod.GET, RequestMethod.OPTIONS})
    public Response<List<MeetingEntryDetailsDto>> fetchAllMeetings(ServletRequest request)
    {
		Response<List<MeetingEntryDetailsDto>> response = new Response<>();
		logger.info("Fetch All Meeting Requests");
		try
		{
			List<MeetingEntryDetailsDto> detailsDtos = meetingEntryDetailsService.fetchAllMeetings();
			logger.info("response list reeceived {}",detailsDtos);
			if(!detailsDtos.isEmpty())
			response.setSuccess(detailsDtos);
			else{
				
				response.setWarning(new Warning(ApplicationStatusCode.NO_RECORDS,"No Records"));
			}
		}
		catch(Exception e)
		{
			response.setFailure(new ErrorBean(ApplicationStatusCode.APPLICATIONERROR));
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		logger.info("response :{}",response.toString());
		return response;
	}
}
