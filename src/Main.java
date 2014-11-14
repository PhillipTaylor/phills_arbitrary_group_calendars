import microsoft.exchange.webservices.data.*;
import java.net.URI;
import ExchangeGroupCalendar.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {

    static String SERVER_URL = "http://cas01-pr-whi.london.net-a-porter.com/";
    static String USERNAME = "p.taylor";
    static String PASSWORD = "deleted";

    public static void main(String[] args) {

        for (String arg : args)
            System.out.println("CHECKING: " + arg);

        try {
            Main.doSomething(args);
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
            System.out.println("error:" + e.getStackTrace());
        }
    }

    public static void doSomething(String args[]) throws Exception {
        System.out.println("Application Started");

        ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
        ExchangeCredentials credentials = new WebCredentials(USERNAME, PASSWORD);
        service.setCredentials(credentials);

        //service.setUrl(new URI(SERVER_URL));
        service.autodiscoverUrl("phill.taylor@net-a-porter.com");

        System.out.println("Querying server...");

        CalendarQuery groupCal = new CalendarQuery(service);
        //groupCal.findAppointments("2014-10-01 12:00:00", "2014-11-01 12:00:00");
        
        groupCal.queryAvailability(args, "2014-11-12 08:00:00", "2014-11-13 18:00:00");

    }

}
