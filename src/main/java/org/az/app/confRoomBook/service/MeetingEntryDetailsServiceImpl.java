package org.az.app.confRoomBook.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;









import org.az.app.confRoomBook.dao.ConferenceRoomDao;
import org.az.app.confRoomBook.dao.EmployeeConferenceRoomMeetingEntryDtlDao;
import org.az.app.confRoomBook.dao.EmployeeDao;
import org.az.app.confRoomBook.dao.MeetingEntryDetailsDao;
import org.az.app.confRoomBook.dto.EmployeeDto;
import org.az.app.confRoomBook.dto.EmployeeDtoToDaoConverter;
import org.az.app.confRoomBook.dto.ConferenceDaoToDtoConverter;
import org.az.app.confRoomBook.dto.ConferenceDtoToDaoConverter;
import org.az.app.confRoomBook.dto.MeetingEntryDetailsDto;
import org.az.app.confRoomBook.dto.MeetingEntryDtlsDaoToDtoConverter;
import org.az.app.confRoomBook.exception.MeetingEntryDtlServiceException;
import org.az.app.confRoomBook.model.ConferenceRoom;
import org.az.app.confRoomBook.model.Employee;
import org.az.app.confRoomBook.model.EmployeeConferenceRoomMeetingEntryDetails;
import org.az.app.confRoomBook.model.MeetingEntryDetails;
import org.az.app.confRoomBook.utils.DateUtil;
import org.az.app.confRoomBook.utils.DateUtil.SimpleDateFormatEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingEntryDetailsServiceImpl implements MeetingEntryDetailsServiceInterfc{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeeConferenceRoomMeetingEntryDtlDao employeeConfMettingEntryDtlDao;
	
	@Autowired
	EmployeeConferenceRoomMeetingEntryDtlDao employeeConferenceRoomMeetingEntryDtlDao;
	
	@Autowired
	MeetingEntryDetailsDao meetingEntryDetailsDao;
	
	@Autowired
	ConferenceRoomDao conferenceRoomDao;
	
	@Autowired
	EmployeeDao employeeDao;
	
	
	@Override
	public MeetingEntryDetailsDto createNewMeetingReq(
			MeetingEntryDetailsDto meetingEntryDetailsDto) throws MeetingEntryDtlServiceException{
		
		ConferenceRoom conferenceRoom = conferenceRoomDao.findOne(meetingEntryDetailsDto.getConferenceRoom().getConferenceRoomId());
		
		meetingEntryDetailsDto.setConferenceRoom(new ConferenceDaoToDtoConverter().apply(conferenceRoom));
		
		MeetingEntryDetails meetingEntryDetails = new MeetingEntryDetails();
		meetingEntryDetails.setMeetingSubject(meetingEntryDetailsDto.getMeetingSubject());
		meetingEntryDetails.setCreatedBy(meetingEntryDetailsDto.getCreatedBy());
		try {
			meetingEntryDetails.setMeetingStartTime(DateUtil.convertDateFromStr(meetingEntryDetailsDto.getMeetingStartTime(), SimpleDateFormatEnum.yyyyMMMdd_HHMM));
			meetingEntryDetails.setMeetingEndTime(DateUtil.convertDateFromStr(meetingEntryDetailsDto.getMeetingEndTime(), SimpleDateFormatEnum.yyyyMMMdd_HHMM));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		meetingEntryDetails.setCreatedOn(new Date());
		meetingEntryDetails.setUpdatedOn(new Date());
		
	
		try {
			if(!checkRoomAvailablity(meetingEntryDetailsDto.getMeetingStartTime(),meetingEntryDetailsDto.getMeetingEndTime(),new ConferenceDtoToDaoConverter().apply(meetingEntryDetailsDto.getConferenceRoom())))
			{
				logger.info("Room Already Booked in between time {} - {}",meetingEntryDetailsDto.getMeetingStartTime(),meetingEntryDetailsDto.getMeetingEndTime());
				throw new MeetingEntryDtlServiceException("Room Already Booked in between time "+meetingEntryDetailsDto.getMeetingStartTime()+" - "+meetingEntryDetailsDto.getMeetingEndTime());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		meetingEntryDetails.setMeetingId(meetingEntryDetailsDao.save(meetingEntryDetails).getId());
					
		Set<EmployeeDto> employeeList =meetingEntryDetailsDto.getEmployee();
		employeeList.forEach(k->{
			
			EmployeeConferenceRoomMeetingEntryDetails roomMeetingEntryDetails = new EmployeeConferenceRoomMeetingEntryDetails();
			
			roomMeetingEntryDetails.setConferenceRoom(conferenceRoom);
			
			Employee employee = employeeDao.findOne(k.getEmpId());
			roomMeetingEntryDetails.setEmployee(employee);	
			roomMeetingEntryDetails.setMeetingEntryDetail(meetingEntryDetails);
			
			employeeConfMettingEntryDtlDao.save(roomMeetingEntryDetails);
			
		});

		return meetingEntryDetailsDto;
	}


	@Override
	public List<MeetingEntryDetailsDto> fetchAllMeetings() {
		
		List<MeetingEntryDetails> list = meetingEntryDetailsDao.findAll();
		
		List<MeetingEntryDetailsDto> meetingEntryDetailsDtos = new ArrayList<>();
		
		logger.info("List Size :{}",list.size());
		
		list.forEach(t->{
			final MeetingEntryDetailsDto detailsDto = new MeetingEntryDetailsDto();
			
			detailsDto.setConferenceRoomMeetingId(t.getId());
			Set<Employee> employees = new HashSet<>();
			logger.info("MeetingEntryDetails ID {} - Employee List Size {}",t.getId(),t.getEmployeeConferenceRoomMeetingEntryDetails().size());
			t.getEmployeeConferenceRoomMeetingEntryDetails().forEach(k->{
				
				detailsDto.setConferenceRoom( new ConferenceDaoToDtoConverter().apply(k.getConferenceRoom()));
				employees.add(k.getEmployee());			
			});
			
			detailsDto.setMeetingSubject(t.getMeetingSubject());
			try {
				detailsDto.setMeetingStartTime(convertStrFromDate(t.getMeetingStartTime()));
				detailsDto.setMeetingEndTime(convertStrFromDate(t.getMeetingEndTime()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			meetingEntryDetailsDtos.add(detailsDto);
		});


		logger.info("meetingEntryDetailsDtos :size {} - meetingEntryDetailsDtos {}",meetingEntryDetailsDtos.size(),meetingEntryDetailsDtos);
		
		return meetingEntryDetailsDtos;
	}

	private String convertStrFromDate(Date date) throws ParseException
	{
		return DateUtil.convertStrFromDate(date, SimpleDateFormatEnum.yyyyMMMdd_HHMM);
	}
	
	private Date convertDateFromStr(String date) throws ParseException
	{
		return DateUtil.convertDateFromStr(date, SimpleDateFormatEnum.yyyyMMMdd_HHMM);
	}
	private boolean checkRoomAvailablity(String meetingStartTime,String meetingEndTime,ConferenceRoom conferenceRoom,Long meetingId) throws ParseException
	{
		List<MeetingEntryDetails> meetingEntryDetails = meetingEntryDetailsDao.findRoomAvailablityExceptMeetingId(conferenceRoom,convertDateFromStr(meetingStartTime),convertDateFromStr(meetingEndTime),meetingId);
		logger.info("meetingEntryDetails :{}",meetingEntryDetails.size());
		return meetingEntryDetails.size()>0?false:true;
	}

	private boolean checkRoomAvailablity(String meetingStartTime,String meetingEndTime,ConferenceRoom conferenceRoom) throws ParseException
	{
		List<MeetingEntryDetails> meetingEntryDetails = meetingEntryDetailsDao.findRoomAvailablity(conferenceRoom,convertDateFromStr(meetingStartTime),convertDateFromStr(meetingEndTime));
		logger.info("meetingEntryDetails :{}",meetingEntryDetails.size());
		return meetingEntryDetails.size()>0?false:true;
	}

	@Override
	public MeetingEntryDetailsDto updateMeetingReq(
			MeetingEntryDetailsDto meetingEntryDetailsDto) {
		
		MeetingEntryDetails meetingEntryDetails = meetingEntryDetailsDao.findOne(meetingEntryDetailsDto.getConferenceRoomMeetingId());
		
		List<EmployeeConferenceRoomMeetingEntryDetails> details = employeeConferenceRoomMeetingEntryDtlDao.findAllMeetingsByMeetingId(meetingEntryDetails);
		ConferenceRoom conferenceRoom = conferenceRoomDao.findOne(meetingEntryDetailsDto.getConferenceRoomMeetingId());
		
		
		logger.info("Employee Meeting Room Details List Size {}",details.size());
		details.forEach(k->{
			employeeConferenceRoomMeetingEntryDtlDao.delete(k);
			});
				
		if(meetingEntryDetailsDto.getMeetingSubject()!=null)
		meetingEntryDetails.setMeetingSubject(meetingEntryDetailsDto.getMeetingSubject());
		
		if(meetingEntryDetailsDto.getCreatedBy()!=null)
		meetingEntryDetails.setCreatedBy(meetingEntryDetailsDto.getCreatedBy());
		
		
			try {
				if(meetingEntryDetailsDto.getMeetingStartTime()!=null)
				meetingEntryDetails.setMeetingStartTime(convertDateFromStr(meetingEntryDetailsDto.getMeetingStartTime()));
				if(meetingEntryDetailsDto.getMeetingEndTime()!=null)
					meetingEntryDetails.setMeetingEndTime(convertDateFromStr(meetingEntryDetailsDto.getMeetingEndTime()));
					
			} catch (ParseException e) {
				e.printStackTrace();
			}
		

		meetingEntryDetails.setUpdatedOn(new Date());
		meetingEntryDetails.setEmployeeConferenceRoomMeetingEntryDetails(null);
		
	
		try {
			if(!checkRoomAvailablity(meetingEntryDetailsDto.getMeetingStartTime(),meetingEntryDetailsDto.getMeetingEndTime(),new ConferenceDtoToDaoConverter().apply(meetingEntryDetailsDto.getConferenceRoom()),meetingEntryDetailsDto.getConferenceRoomMeetingId()))
			{
				logger.info("Room Already Booked in between time {} - {}",meetingEntryDetailsDto.getMeetingStartTime(),meetingEntryDetailsDto.getMeetingEndTime());
				throw new MeetingEntryDtlServiceException("Room Already Booked in between time "+meetingEntryDetailsDto.getMeetingStartTime()+" - "+meetingEntryDetailsDto.getMeetingEndTime());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		meetingEntryDetails.setMeetingId(meetingEntryDetailsDao.save(meetingEntryDetails).getId());
					
		Set<EmployeeDto> employeeList =meetingEntryDetailsDto.getEmployee();	
		
		employeeList.forEach(k->{
			
			EmployeeConferenceRoomMeetingEntryDetails roomMeetingEntryDetails = new EmployeeConferenceRoomMeetingEntryDetails();
			roomMeetingEntryDetails.setConferenceRoom(conferenceRoom);
			roomMeetingEntryDetails.setEmployee(new EmployeeDtoToDaoConverter().apply(k));	
			roomMeetingEntryDetails.setMeetingEntryDetail(meetingEntryDetails);
			
			employeeConfMettingEntryDtlDao.save(roomMeetingEntryDetails);
			
		});

		return meetingEntryDetailsDto;
	}


	@Override
	public boolean removeMeetingReq(Long meetingId) {
		MeetingEntryDetails meetingEntryDetails = meetingEntryDetailsDao.findOne(meetingId);
		meetingEntryDetailsDao.delete(meetingEntryDetails);
		return true;
	}
}
