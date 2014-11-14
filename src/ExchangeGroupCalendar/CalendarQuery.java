package ExchangeGroupCalendar;

import microsoft.exchange.webservices.data.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class CalendarQuery {

    private ExchangeService service;
    private String[] usernames;

    public CalendarQuery (ExchangeService service) {
        this.service = service;
        this.usernames = usernames;
    }

    public void findAppointments(String startDate,String endDate) throws Exception
    {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dtStartDate = formatter.parse(startDate);
        Date dtEndDate = formatter.parse(endDate);

        CalendarFolder cf=CalendarFolder.bind(this.service, WellKnownFolderName.Calendar);
        FindItemsResults<Appointment> findResults = cf.findAppointments(new CalendarView(dtStartDate, dtEndDate));
        for (Appointment appt : findResults.getItems())
        {
            System.out.println("SUBJECT====="+appt.getSubject());
            //System.out.println("BODY========"+appt.getBody());
        }
    }

    public void queryAvailability(String[] userEmails, String startDate, String endDate) throws Exception
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dtStartDate = formatter.parse(startDate);
        Date dtEndDate = formatter.parse(endDate);

        List<AttendeeInfo> attendees = new ArrayList<AttendeeInfo>();

        for (String userEmail : userEmails)
            attendees.add(new AttendeeInfo(userEmail));

        GetUserAvailabilityResults results = service.getUserAvailability(
            attendees,
            new TimeWindow(dtStartDate, dtEndDate),
            AvailabilityData.FreeBusyAndSuggestions
        );

        int attendeeIndex = 0;

        for (AttendeeAvailability attendeeAvailability : results.getAttendeesAvailability())
        {
            System.out.println("Availability for " + userEmails[attendeeIndex]);
            if (attendeeAvailability.getErrorCode() == ServiceError.NoError)
            {
                for (CalendarEvent calendarEvent : attendeeAvailability.getCalendarEvents())
                {
                    System.out.println("  Calendar event");
                    System.out.println("    Start time: " + calendarEvent.getStartTime().toString());
                    System.out.println("    End time: " + calendarEvent.getEndTime().toString());

                    if (calendarEvent.getDetails() != null)
                    {
                        System.out.println("     Subject: " + calendarEvent.getDetails().getSubject());
                        System.out.println("     Is Meeting: " + calendarEvent.getDetails().isMeeting());
                        // Output additional properties.
                    }
                }
            }

            attendeeIndex++;
        }
    }
}

