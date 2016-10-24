Change 1:
This Application is used to Book Meeting Rooms.

Technology Used :
Java 1.8
Spring Boot
Hibernate



http://localhost:9123/conferenceRoom/save

Header : 

Content-Type:application/json

Request Body :

Input 1:
{
  "conferenceRoomName": "Room 1",
  "conferenceRoomLocation": "AZ-CHENNAI-BLOCK-5-FLOOR-1",
  "conferenceRoomStatus": true
}

Input 2:
{
  "conferenceRoomName": "Room 2",
  "conferenceRoomLocation": "AZ-CHENNAI-BLOCK-5-FLOOR-3",
  "conferenceRoomStatus": true
}


http://localhost:9123/conferenceRoom/findOne/1

Sample Output :
{
  "conferenceRoomId": 1,
  "conferenceRoomName": "Room 1",
  "conferenceRoomLocation": "AZ-CHENNAI-BLOCK-5-FLOOR-2",
  "conferenceRoomStatus": true,
  "employeeConferenceRoomMeetingEntryDetails": [],
  "id": 1
}

http://localhost:9123/employee/save
Header : 

Content-Type:application/json

Request Body :

Input 1:
{
	"empName" : "Employee1",
	"empStatus" : true
}

Input 2:
{
	"empName" : "Employee2",
	"empStatus" : true
}

http://localhost:9123/employee/findOne/1

Sample Output :
{
  "empId": 1,
  "empName": "Employee1",
  "empStatus": true,
  "employeeConferenceRoomMeetingEntryDetails": [],
  "id": 1
}

http://localhost:9123/bookMeeting/newMeetingReq
Header : 

Content-Type:application/json

Request Body :

{
    "meetingSubject": "AngularJS-2 Session",
    "createdBy": "Admin",
    "conferenceRoom": 
	{
      "conferenceRoomId": 1,
      "conferenceRoomName": "Room 1",
      "conferenceRoomLocation": "AZ-CHENNAI-BLOCK-5-FLOOR-2",
      "conferenceRoomStatus": true
    },
    "employee": [
      {
        "empId": 1,
        "empName": "Employee-1",
        "empStatus": false
      },
      {
        "empId": 2,
        "empName": "Employee-2",
        "empStatus": false
      }	  
    ],
    "meetingStartTime": "2016-10-24 13:30",
    "meetingEndTime": "2016-10-24 15:00"
}


Sample Response :

{
  "status": "SUCCESS",
  "data": {
    "conferenceRoomMeetingId": null,
    "meetingSubject": "AngularJS-2 Session",
    "createdBy": "Admin",
    "conferenceRoom": {
      "conferenceRoomId": 1,
      "conferenceRoomName": "Room 1",
      "conferenceRoomLocation": "AZ-CHENNAI-BLOCK-5-FLOOR-3",
      "conferenceRoomStatus": true
    },
    "employee": [
      {
        "empId": 2,
        "empName": "Employee-2",
        "empStatus": false
      },
      {
        "empId": 1,
        "empName": "Employee-1",
        "empStatus": false
      }
    ],
    "meetingStartTime": "2016-10-24 13:30",
    "meetingEndTime": "2016-10-24 15:00"
  }
}

http://localhost:9123/bookMeeting/fetchAllMeetings

Sample Response :

{
  "status": "SUCCESS",
  "data": [
    {
      "conferenceRoomMeetingId": 1,
      "meetingSubject": "AngularJS-2 Session",
      "createdBy": "Admin",
      "conferenceRoom": {
        "conferenceRoomId": 1,
        "conferenceRoomName": "Room 1",
        "conferenceRoomLocation": "AZ-CHENNAI-BLOCK-5-FLOOR-3",
        "conferenceRoomStatus": true
      },
       "employee": [
      {
        "empId": 2,
        "empName": "Employee-2",
        "empStatus": false
      },
      {
        "empId": 1,
        "empName": "Employee-1",
        "empStatus": false
      }
     ]
      "meetingStartTime": "2016-10-24 13:30",
      "meetingEndTime": "2016-10-24 15:00"
    }
  ]
}


http://localhost:9123/bookMeeting/removeMeetingReq/1

Response :
{
  "status": "SUCCESS",
  "data": "true"
}



Test Cases for New / Update Meeting Request :
==============================================
This Response will get when evere you tried meeting room already booked time .
Sample Response :
{
  "status": "FAILURE",
  "error": {
    "code": "NOTSUPPORTED",
    "message": "Room Already Booked in between time 2016-10-24 13:30 - 2016-10-24 15:00"
  }
}