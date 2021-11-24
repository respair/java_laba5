import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Set;

import static java.time.DayOfWeek.*;
import static java.time.temporal.ChronoUnit.MINUTES;

public class DateTime {
    public static void main(String args[]){
        LocalDate now, bDate, dDate;
        now = LocalDate.now();

        System.out.println("Abe Lincoln: ");
        bDate = LocalDate.of(1809,2,12);
        dDate = LocalDate.of(1855,4,15);
        System.out.println("How old when he died? " + ChronoUnit.YEARS.between(bDate, dDate));
        System.out.println("How many days did he live? " + ChronoUnit.DAYS.between(bDate, dDate) + "\n");

        System.out.println("Bennedict Cumberbatch: ");
        LocalDate bDate2;
        bDate2 = LocalDate.of(1976,6,19);
        System.out.println("Born in a leap year? " + bDate2.isLeapYear());
        System.out.println("How many days in the year he was born? " + bDate2.lengthOfYear());
        System.out.println("How many decades old is he? " + ChronoUnit.YEARS.between(bDate2, now)/10);
        System.out.println("What was the day of the week on his 21st birthday? "
                + bDate2.plusMonths(21).getDayOfWeek() + "\n");

        System.out.println("Train departs Boston at 1:45PM and arrives New York 7:25PM: ");
        LocalTime time1, time2, time3;
        time1 = LocalTime.of(13,45);
        time2 = LocalTime.of(19,25);
        time3 = time2.plusHours(1).plusMinutes(19);
        System.out.println("How many minutes long is the train ride? " + time1.until(time2, MINUTES));
        System.out.println("If the train was delayed 1 hour 19 minutes, what is the actual arrival time? "
                + time3 + "\n");

        System.out.println("Flight: Boston to Miami, leaves March 24th 9:15PM. Flight time is 4 hours 15 minutes: ");
        LocalDateTime flight, flight2;
        flight = LocalDateTime.of(2022,3,24,21,15);
        flight2 = flight.plusHours(4).plusMinutes(15);
        System.out.println("When does it arrive in Miami? " + flight2);
        System.out.println("When does it arrive if the flight is delays 4 hours 27 minutes? "
                + flight2.plusHours(4).plusMinutes(27) + "\n");


// School semester starts the second Tuesday of September of this year.
// Hint: Look at the TemporalAdjusters class
// What is the date?
// School summer vacation starts June 25th
// Assuming:
// * Two weeks off in December
// * Two other vacation weeks
// * School is taught Monday - Friday
// How many days of school are there?
// Hint: keep track of the short weeks also

        System.out.println("School semester starts the second Tuesday of September of this year: ");
        LocalDate start, school, finish;
        start = LocalDate.of(2022,9,1);
        finish = LocalDate.of(2023,6,25);
        school = start.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.TUESDAY));
        System.out.println("What is the date? " + school);
        final Set<DayOfWeek> businessDays = Set.of(
                MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
        );

        long sum = school.datesUntil(finish)
                .filter(t -> businessDays.contains(t.getDayOfWeek()))
                .count();
        sum -= 28;
        System.out.println("How many days of school are there? " + sum + "\n");


        // A meeting is schedule for 1:30 PM next Tuesday. If today is Tuesday, assume it is today.
        // What is the time of the week's meetings?

        LocalDate now3;
        LocalTime timeOfMeeting;
        timeOfMeeting = LocalTime.of(13,30);
        now3 = LocalDate.now();
        if( now3.getDayOfWeek().equals(TUESDAY)){
            System.out.println("What is the time of the week's meetings? today at " + timeOfMeeting + "\n");
        }
        else{
            TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
            int weekNumber = now3.get(woy) + 1;
            now3 = LocalDate.of(2021,1,1);
            LocalDate tuesday = now3.with(TemporalAdjusters.dayOfWeekInMonth(weekNumber, DayOfWeek.TUESDAY));
            System.out.println(weekNumber +"What is the time of the week's meetings? " + tuesday + " " + timeOfMeeting + "\n");
        }

    }
}
