import java.time.*;
import java.time.temporal.ChronoUnit;


// Using the following information:
// * Use America/New_York as the time zone for Boston Logan Airport(BOS).
// * Use America/Los_Angeles as the time zone for San Francisco Airport (SFO).
// * Use Asia/Calcutta as the time zone for Bangalore's Bengaluru International Airport (BLR)

public class Zone {
    public static void main(String args[]) {
        {
            // Flight 123, San Francisco to Boston, leaves SFO at 10:30 PM June 13, 2014
            // The flight is 5 hours 30 minutes
            ZoneId zone1 = ZoneId.of("America/New_York");  //bos
            ZoneId zone2 = ZoneId.of("America/Los_Angeles"); //sfo
            LocalDateTime flight = LocalDateTime.of(2014, 6, 13, 22, 30);
            LocalTime fTime = LocalTime.of(22, 30);
            LocalDate fDate = LocalDate.of(2014, 6, 13);
            LocalDateTime fOff = flight.plusHours(5).plusMinutes(30);
            ZonedDateTime flight2 = ZonedDateTime.of(flight, zone2);
            ZonedDateTime fOff2 = ZonedDateTime.of(fOff, zone2);
            OffsetDateTime offSetFlight = flight2.toOffsetDateTime();
            OffsetDateTime offSetOff = fOff2.toOffsetDateTime();
            System.out.println("What is the local time in Boston when the flight takes off? "
                    + offSetFlight.atZoneSameInstant(zone1));
            System.out.println("What is the local time at Boston Logan airport when the flight arrives? "
                    + offSetOff.atZoneSameInstant(zone1));
            System.out.println("What is the local time in San Francisco when the flight arrives? "
                    + fOff2 + "\n");
        }
        {
            // Flight 456, San Francisco to Bangalore, India, leaves SFO at Saturday, 10:30 PM June 28, 2014
            // The flight time is 22 hours
            ZoneId sfo = ZoneId.of("America/Los_Angeles");
            ZoneId blr = ZoneId.of("Asia/Calcutta");
            LocalDateTime flight = LocalDateTime.of(2014, 6, 28, 22, 30);
            LocalDateTime fOff = flight.plusHours(22);
            ZonedDateTime fOff2 = ZonedDateTime.of(fOff, sfo);
            OffsetDateTime offSetOff = fOff2.toOffsetDateTime();
            ZonedDateTime fOffBLR = offSetOff.atZoneSameInstant(blr);
            System.out.println("Will the traveler make a meeting in Bangalore Monday at 9 AM local time? ");
            if(fOffBLR.getDayOfWeek().equals(DayOfWeek.MONDAY) && fOffBLR.getHour() == 9) {
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
            System.out.println("Can the traveler call her husband at a reasonable time when she arrives? ");
            if(fOff2.getHour() > 8 && fOff2.getHour() < 23) {
                System.out.println("yes" + "\n");
            }
            else{
                System.out.println("no" + "\n");
            }
        }

        {
            // Flight 123, San Francisco to Boston, leaves SFO at 10:30 PM Saturday, November 1st, 2014
            // Flight time is 5 hours 30 minutes.
            ZoneId sfo = ZoneId.of("America/Los_Angeles");
            ZoneId bos = ZoneId.of("America/New_York");
            LocalDateTime flight = LocalDateTime.of(2014, 11, 1, 22, 30);
            LocalDateTime fOff = flight.plusHours(5).plusMinutes(30);
            ZonedDateTime fOff2 = ZonedDateTime.of(fOff, sfo);
            OffsetDateTime offSetOff = fOff2.toOffsetDateTime();
            ZonedDateTime fOffBOS = offSetOff.atZoneSameInstant(bos);
            // System.out.println(ZonedDateTime.of(flight, sfo));
            // System.out.println(fOff2);
            // System.out.println(ZonedDateTime.of(flight, sfo).toOffsetDateTime().atZoneSameInstant(bos));
            // System.out.println(fOffBOS);
            System.out.println("What day and time does the flight arrive in Boston? " + fOffBOS.getDayOfWeek()
                    + " " + LocalTime.of(fOffBOS.getHour(),fOffBOS.getMinute()));
            System.out.println("What happened? " + "LA: -7:00->-8:00; " + "NW: -4:00->-5:00" + "\n");

        }


    }
}
