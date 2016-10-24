package org.az.test.it;

import org.az.app.confRoomBook.model.ConferenceRoom;
import org.az.app.confRoomBook.model.Employee;
import org.az.app.confRoomBook.model.EmployeeConferenceRoomMeetingEntryDetails;
import org.az.app.confRoomBook.utils.DateUtil;
import org.az.app.confRoomBook.utils.DateUtil.SimpleDateFormatEnum;
import org.az.app.confRoomBook.utils.enums.ApplicationStatusCode;
import org.az.app.confRoomBook.utils.enums.ResponseStatus;
import org.az.app.confRoomBook.utils.model.ErrorBean;
import org.az.app.confRoomBook.utils.model.Response;
import org.az.app.confRoomBook.dao.EmployeeConferenceRoomMeetingEntryDtlDao;
import org.az.app.confRoomBook.dto.ConferenceRoomDto;
import org.az.app.confRoomBook.dto.EmployeeDto;
import org.az.app.confRoomBook.dto.MeetingEntryDetailsDto;
import org.az.app.confRoomBook.controller.*;

import junit.framework.Assert;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@FixMethodOrder
public class BookMeetingTest extends AbstractIT<Response<MeetingEntryDetailsDto>> {

	

	public BookMeetingTest() {
		super();
	}


	private MeetingEntryDetailsController controller;
    private EmployeeConferenceRoomMeetingEntryDtlDao repository;

    @Autowired
    public void setCategoryController(MeetingEntryDetailsController controller) {
        this.controller=controller;
       // super.setController(controller);
    }

    @Autowired
    public void setCategoryRepository(EmployeeConferenceRoomMeetingEntryDtlDao repository) {
        this.repository=repository;
    }

    @Test
    public void addConferenceRoom() throws Exception
    {
    	ConferenceRoomDto conferenceRoom = new ConferenceRoomDto();
    	conferenceRoom.setConferenceRoomName("Room 1");
    	conferenceRoom.setConferenceRoomLocation("AZ-CHENNAI-BLOCK-5-FLOOR-1");
    	conferenceRoom.setConferenceRoomStatus(true);
    	
        String json= templatePostRequest("/conferenceRoom/save",jsonToObject(conferenceRoom));  
        
    	conferenceRoom = new ConferenceRoomDto();
    	conferenceRoom.setConferenceRoomName("Room 2");
    	conferenceRoom.setConferenceRoomLocation("AZ-CHENNAI-BLOCK-5-FLOOR-2");
    	conferenceRoom.setConferenceRoomStatus(true);
       
    	json= templatePostRequest("/conferenceRoom/save",jsonToObject(conferenceRoom));  
      
    }
    
    @Test
    public void addEmployeeRoom() throws Exception
    {
    	
    	Employee employee = new Employee();
    	employee.setEmpName("Employee -1 ");
    	employee.setEmpStatus(true);
    	
    	String json= templatePostRequest("/employee/save",jsonToObject(employee));  
    	
    	employee = new Employee();
    	employee.setEmpName("Employee -2 ");
    	employee.setEmpStatus(true);
       
    	json= templatePostRequest("/employee/save",jsonToObject(employee));  
    	
      
    }

//newMeetingRequest - Create Meeting between  2016-10-24 13:00 to 2016-10-24 15:00  -> Case Success // Already Loaded in Memory
 // @Test
    public void Test1() throws Exception {

		Response<MeetingEntryDetailsDto> response = new Response<>();
		
		ConferenceRoomDto conferenceRoom = new ConferenceRoomDto();
		conferenceRoom.setConferenceRoomId(1l);
		
		EmployeeDto employee = new EmployeeDto();
		employee.setEmpId(1l);
		EmployeeDto employee2 = new EmployeeDto();
		employee2.setEmpId(2l);
		
		Set<EmployeeDto> employees  = new HashSet<>();
		employees.add(employee2);
		
		MeetingEntryDetailsDto meetingEntryDetailsDto = new MeetingEntryDetailsDto();
		
		meetingEntryDetailsDto.setConferenceRoom(conferenceRoom);
		meetingEntryDetailsDto.setCreatedBy("Admin");
		meetingEntryDetailsDto.setEmployee(employees);	
		meetingEntryDetailsDto.setMeetingStartTime("2016-10-24 13:00");
		meetingEntryDetailsDto.setMeetingEndTime("2016-10-24 15:00");
		
        String json= templatePostRequest("/bookMeeting/newMeetingReq",jsonToObject(meetingEntryDetailsDto));
        System.out.println("New Req Creation Response :"+jsonToObject(json));
        response =(Response<MeetingEntryDetailsDto>)jsonToObject(json);
        Assert.assertTrue("", response.getStatus().equals(ResponseStatus.SUCCESS));

    }
//newMeetingRequest - Create Meeting between  2016-10-24 13:30 to 2016-10-24 14:00  -> Case Failure
@Test
  public void Test2() throws Exception {

		Response<MeetingEntryDetailsDto> response = new Response<>();
		
		ConferenceRoomDto conferenceRoom = new ConferenceRoomDto();
		conferenceRoom.setConferenceRoomId(1l);
		
		EmployeeDto employee = new EmployeeDto();
		employee.setEmpId(1l);
		EmployeeDto employee2 = new EmployeeDto();
		employee2.setEmpId(2l);
		
		Set<EmployeeDto> employees  = new HashSet<>();
		employees.add(employee2);
		
		MeetingEntryDetailsDto meetingEntryDetailsDto = new MeetingEntryDetailsDto();
		
		meetingEntryDetailsDto.setConferenceRoom(conferenceRoom);
		meetingEntryDetailsDto.setCreatedBy("Admin");
		meetingEntryDetailsDto.setEmployee(employees);	
		meetingEntryDetailsDto.setMeetingStartTime("2016-10-24 13:30");
		meetingEntryDetailsDto.setMeetingEndTime("2016-10-24 14:00");
		
      String json= templatePostRequest("/bookMeeting/newMeetingReq",jsonToObject(meetingEntryDetailsDto));
      System.out.println("New Req Creation Response :"+jsonToObject(json));
      response =(Response<MeetingEntryDetailsDto>)jsonToObject(json);
      Assert.assertTrue("", response.getStatus().equals(ResponseStatus.SUCCESS));

  }   

//newMeetingRequest - Create Meeting between  2016-10-24 12:30 to 2016-10-24 16:00  -> Case Failure
@Test
public void Test3() throws Exception {

		Response<MeetingEntryDetailsDto> response = new Response<>();
		
		ConferenceRoomDto conferenceRoom = new ConferenceRoomDto();
		conferenceRoom.setConferenceRoomId(1l);
		
		EmployeeDto employee = new EmployeeDto();
		employee.setEmpId(1l);
		EmployeeDto employee2 = new EmployeeDto();
		employee2.setEmpId(2l);
		
		Set<EmployeeDto> employees  = new HashSet<>();
		employees.add(employee2);
		
		MeetingEntryDetailsDto meetingEntryDetailsDto = new MeetingEntryDetailsDto();
		
		meetingEntryDetailsDto.setConferenceRoom(conferenceRoom);
		meetingEntryDetailsDto.setCreatedBy("Admin");
		meetingEntryDetailsDto.setEmployee(employees);	
		meetingEntryDetailsDto.setMeetingStartTime("2016-10-24 12:30");
		meetingEntryDetailsDto.setMeetingEndTime("2016-10-24 16:00");
		
    String json= templatePostRequest("/bookMeeting/newMeetingReq",jsonToObject(meetingEntryDetailsDto));
    System.out.println("New Req Creation Response :"+jsonToObject(json));
    response =(Response<MeetingEntryDetailsDto>)jsonToObject(json);
    Assert.assertTrue("", response.getStatus().equals(ResponseStatus.SUCCESS));

} 

//newMeetingRequest - Create Meeting between  2016-10-24 13:00 to 2016-10-24 15:00  -> Case Failure
@Test
public void Test4() throws Exception {

		Response<MeetingEntryDetailsDto> response = new Response<>();
		
		ConferenceRoomDto conferenceRoom = new ConferenceRoomDto();
		conferenceRoom.setConferenceRoomId(1l);
		
		EmployeeDto employee = new EmployeeDto();
		employee.setEmpId(1l);
		EmployeeDto employee2 = new EmployeeDto();
		employee2.setEmpId(2l);
		
		Set<EmployeeDto> employees  = new HashSet<>();
		employees.add(employee2);
		
		MeetingEntryDetailsDto meetingEntryDetailsDto = new MeetingEntryDetailsDto();
		
		meetingEntryDetailsDto.setConferenceRoom(conferenceRoom);
		meetingEntryDetailsDto.setCreatedBy("Admin");
		meetingEntryDetailsDto.setEmployee(employees);	
		meetingEntryDetailsDto.setMeetingStartTime("2016-10-24 13:00");
		meetingEntryDetailsDto.setMeetingEndTime("2016-10-24 15:00");
		
  String json= templatePostRequest("/bookMeeting/newMeetingReq",jsonToObject(meetingEntryDetailsDto));
  System.out.println("New Req Creation Response :"+jsonToObject(json));
  response =(Response<MeetingEntryDetailsDto>)jsonToObject(json);
  Assert.assertTrue("", response.getStatus().equals(ResponseStatus.SUCCESS));

} 

//newMeetingRequest - Create Meeting between  2016-10-24 12:30 to 2016-10-24 13:30  -> Case Failure
@Test
public void Test5() throws Exception {

		Response<MeetingEntryDetailsDto> response = new Response<>();
		
		ConferenceRoomDto conferenceRoom = new ConferenceRoomDto();
		conferenceRoom.setConferenceRoomId(1l);
		
		EmployeeDto employee = new EmployeeDto();
		employee.setEmpId(1l);
		EmployeeDto employee2 = new EmployeeDto();
		employee2.setEmpId(2l);
		
		Set<EmployeeDto> employees  = new HashSet<>();
		employees.add(employee2);
		
		MeetingEntryDetailsDto meetingEntryDetailsDto = new MeetingEntryDetailsDto();
		
		meetingEntryDetailsDto.setConferenceRoom(conferenceRoom);
		meetingEntryDetailsDto.setCreatedBy("Admin");
		meetingEntryDetailsDto.setEmployee(employees);	
		meetingEntryDetailsDto.setMeetingStartTime("2016-10-24 12:30");
		meetingEntryDetailsDto.setMeetingEndTime("2016-10-24 13:30");
		
String json= templatePostRequest("/bookMeeting/newMeetingReq",jsonToObject(meetingEntryDetailsDto));
System.out.println("New Req Creation Response :"+jsonToObject(json));
response =(Response<MeetingEntryDetailsDto>)jsonToObject(json);
Assert.assertTrue("", response.getStatus().equals(ResponseStatus.SUCCESS));

} 

//newMeetingRequest - Create Meeting between  2016-10-24 13:30 to 2016-10-24 15:30  -> Case Failure
@Test
public void Test6() throws Exception {

		Response<MeetingEntryDetailsDto> response = new Response<>();
		
		ConferenceRoomDto conferenceRoom = new ConferenceRoomDto();
		conferenceRoom.setConferenceRoomId(1l);
		
		EmployeeDto employee = new EmployeeDto();
		employee.setEmpId(1l);
		EmployeeDto employee2 = new EmployeeDto();
		employee2.setEmpId(2l);
		
		Set<EmployeeDto> employees  = new HashSet<>();
		employees.add(employee2);
		
		MeetingEntryDetailsDto meetingEntryDetailsDto = new MeetingEntryDetailsDto();
		
		meetingEntryDetailsDto.setConferenceRoom(conferenceRoom);
		meetingEntryDetailsDto.setCreatedBy("Admin");
		meetingEntryDetailsDto.setEmployee(employees);	
		meetingEntryDetailsDto.setMeetingStartTime("2016-10-24 13:30");
		meetingEntryDetailsDto.setMeetingEndTime("2016-10-24 15:30");
		
String json= templatePostRequest("/bookMeeting/newMeetingReq",jsonToObject(meetingEntryDetailsDto));
System.out.println("New Req Creation Response :"+jsonToObject(json));
response =(Response<MeetingEntryDetailsDto>)jsonToObject(json);
Assert.assertTrue("", response.getStatus().equals(ResponseStatus.SUCCESS));

} 

//newMeetingRequest - Create Meeting between  2016-10-24 15:01 to 2016-10-24 16:00  -> Case Success
@Test
public void Test7() throws Exception {

		Response<MeetingEntryDetailsDto> response = new Response<>();
		
		ConferenceRoomDto conferenceRoom = new ConferenceRoomDto();
		conferenceRoom.setConferenceRoomId(1l);
		
		EmployeeDto employee = new EmployeeDto();
		employee.setEmpId(1l);
		EmployeeDto employee2 = new EmployeeDto();
		employee2.setEmpId(2l);
		
		Set<EmployeeDto> employees  = new HashSet<>();
		employees.add(employee2);
		
		MeetingEntryDetailsDto meetingEntryDetailsDto = new MeetingEntryDetailsDto();
		
		meetingEntryDetailsDto.setConferenceRoom(conferenceRoom);
		meetingEntryDetailsDto.setCreatedBy("Admin");
		meetingEntryDetailsDto.setEmployee(employees);	
		meetingEntryDetailsDto.setMeetingStartTime("2016-10-24 15:01");
		meetingEntryDetailsDto.setMeetingEndTime("2016-10-24 16:00");
		
String json= templatePostRequest("/bookMeeting/newMeetingReq",jsonToObject(meetingEntryDetailsDto));
System.out.println("New Req Creation Response :"+jsonToObject(json));
response =(Response<MeetingEntryDetailsDto>)jsonToObject(json);
Assert.assertTrue("", response.getStatus().equals(ResponseStatus.SUCCESS));

}
    //updateMeetingRequest
  //  @Test
    public void Test8() throws Exception {

		Response<MeetingEntryDetailsDto> response = new Response<>();
		
		ConferenceRoomDto conferenceRoom = new ConferenceRoomDto();
		conferenceRoom.setConferenceRoomId(1l);
		
		EmployeeDto employee = new EmployeeDto();
		employee.setEmpId(1l);
		EmployeeDto employee2 = new EmployeeDto();
		employee2.setEmpId(2l);
		
		Set<EmployeeDto> employees  = new HashSet<>();
		employees.add(employee);
		employees.add(employee2);
		
		MeetingEntryDetailsDto meetingEntryDetailsDto = new MeetingEntryDetailsDto();
		 
		meetingEntryDetailsDto.setConferenceRoomMeetingId(1l);
		meetingEntryDetailsDto.setConferenceRoom(conferenceRoom);
		meetingEntryDetailsDto.setCreatedBy("Admin");
		meetingEntryDetailsDto.setMeetingSubject("AngularJS-2 Session");
		meetingEntryDetailsDto.setEmployee(employees);
		
/*		try {
			meetingEntryDetailsDto.setMeetingStartTime(DateUtil.convertDateFromStr("2016-10-24 13:30", SimpleDateFormatEnum.yyyyMMMdd_HHMM));
			meetingEntryDetailsDto.setMeetingEndTime(DateUtil.convertDateFromStr("2016-10-24 15:00", SimpleDateFormatEnum.yyyyMMMdd_HHMM));
		} catch (ParseException e1) {
			response.setFailure(new ErrorBean(ApplicationStatusCode.APPLICATIONERROR));
			e1.printStackTrace();
		}*/
		
		meetingEntryDetailsDto.setMeetingStartTime("2016-10-24 13:30");
		meetingEntryDetailsDto.setMeetingEndTime("2016-10-24 15:00");
		
        String json= templatePostRequest("/bookMeeting/udateMeetingReq",jsonToObject(meetingEntryDetailsDto));
        System.out.println("Update Response :"+jsonToObject(json));
        response =(Response<MeetingEntryDetailsDto>)jsonToObject(json);
        Assert.assertTrue("", response.getStatus().equals(ResponseStatus.SUCCESS));

    }  
    
   // @Test
    public void deleteMeetingRequest() throws Exception {

		Response<MeetingEntryDetailsDto> response = new Response<>();

		long meetingId = 1;
	
        String json= templateDeleteRequest("/bookMeeting/deleteMeetingReq/"+meetingId);
        System.out.println("Response :"+jsonToObject(json));
        response =(Response<MeetingEntryDetailsDto>)jsonToObject(json);
        Assert.assertTrue("", response.getStatus().equals(ResponseStatus.SUCCESS));

    }     

   // @Test
    public void fetchAllMeetingRequest() throws Exception {

    	Response<List<MeetingEntryDetailsDto>> response = new Response<>();

		long meetingId = 1;
	
        String json= templateDeleteRequest("/bookMeeting/fetchAllMeetings");
        System.out.println("Response :"+jsonToObject(json));
        response =(Response<List<MeetingEntryDetailsDto>>)jsonToObject(json);
        Assert.assertTrue("", response.getStatus().equals(ResponseStatus.SUCCESS));

    }  
}
