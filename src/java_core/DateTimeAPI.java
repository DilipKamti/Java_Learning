package java_core;

// DateTimeAPI.java
// Basic to Deep Dive (Java 8+ Date & Time API) ✅
// Covers: LocalDate, LocalTime, LocalDateTime, ZonedDateTime,
// Instant, Duration, Period, DateTimeFormatter, parsing/formatting,
// timezone, legacy Date conversion, interview tricks.

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateTimeAPI {

    // =========================================================
    // 1) Why Java 8 Date-Time API introduced?
    // =========================================================
    /*
        Old API problems (java.util.Date, Calendar):
        ❌ Mutable (not thread-safe)
        ❌ Confusing methods (months start from 0 in Calendar)
        ❌ Hard timezone handling
        ❌ Formatting/parsing not clean

        Java 8 introduced java.time package:
        ✅ Immutable (thread-safe)
        ✅ Clear API design
        ✅ Better timezone support
        ✅ Better formatting & parsing
    */

    // =========================================================
    // 2) LocalDate (Date only)
    // =========================================================
    static void localDateDemo() {
        System.out.println("----- LocalDate Demo -----");

        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);

        LocalDate customDate = LocalDate.of(2026, 1, 24);
        System.out.println("Custom Date: " + customDate);

        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Day of Month: " + today.getDayOfMonth());

        LocalDate nextWeek = today.plusWeeks(1);
        System.out.println("Next Week: " + nextWeek);

        LocalDate lastMonth = today.minusMonths(1);
        System.out.println("Last Month: " + lastMonth);

        System.out.println("Is Leap Year? " + today.isLeapYear());
    }

    // =========================================================
    // 3) LocalTime (Time only)
    // =========================================================
    static void localTimeDemo() {
        System.out.println("----- LocalTime Demo -----");

        LocalTime now = LocalTime.now();
        System.out.println("Now: " + now);

        LocalTime customTime = LocalTime.of(10, 30, 45);
        System.out.println("Custom Time: " + customTime);

        System.out.println("Hour: " + now.getHour());
        System.out.println("Minute: " + now.getMinute());
        System.out.println("Second: " + now.getSecond());

        System.out.println("After 2 hours: " + now.plusHours(2));
        System.out.println("Before 15 mins: " + now.minusMinutes(15));
    }

    // =========================================================
    // 4) LocalDateTime (Date + Time)
    // =========================================================
    static void localDateTimeDemo() {
        System.out.println("----- LocalDateTime Demo -----");

        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now: " + now);

        LocalDateTime custom = LocalDateTime.of(2026, 1, 24, 10, 45, 30);
        System.out.println("Custom: " + custom);

        System.out.println("Plus 5 days: " + now.plusDays(5));
        System.out.println("Minus 2 hours: " + now.minusHours(2));
    }

    // =========================================================
    // 5) ZonedDateTime (Date+Time+Zone)
    // =========================================================
    static void zonedDateTimeDemo() {
        System.out.println("----- ZonedDateTime Demo -----");

        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("India Time: " + indiaTime);

        ZonedDateTime usTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("US Time: " + usTime);

        System.out.println("Zone: " + indiaTime.getZone());
        System.out.println("Offset: " + indiaTime.getOffset());
    }

    // =========================================================
    // 6) Instant (Machine time / UTC timestamp)
    // =========================================================
    /*
        Instant represents a timestamp in UTC.
        Best for logging, events, database timestamps.
    */
    static void instantDemo() {
        System.out.println("----- Instant Demo -----");

        Instant now = Instant.now();
        System.out.println("Instant now: " + now);

        Instant after10Sec = now.plusSeconds(10);
        System.out.println("After 10 sec: " + after10Sec);
    }

    // =========================================================
    // 7) Duration (Time-based difference)
    // =========================================================
    static void durationDemo() {
        System.out.println("----- Duration Demo -----");

        LocalTime start = LocalTime.of(10, 0);
        LocalTime end = LocalTime.of(12, 30);

        Duration duration = Duration.between(start, end);
        System.out.println("Duration: " + duration);
        System.out.println("Minutes: " + duration.toMinutes());
        System.out.println("Seconds: " + duration.toSeconds());
    }

    // =========================================================
    // 8) Period (Date-based difference)
    // =========================================================
    static void periodDemo() {
        System.out.println("----- Period Demo -----");

        LocalDate dob = LocalDate.of(2000, 1, 1);
        LocalDate today = LocalDate.now();

        Period period = Period.between(dob, today);
        System.out.println("Period: " + period);
        System.out.println("Years: " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days: " + period.getDays());
    }

    // =========================================================
    // 9) DateTimeFormatter (Formatting)
    // =========================================================
    static void formatterDemo() {
        System.out.println("----- DateTimeFormatter Demo -----");

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatted = now.format(formatter1);
        System.out.println("Formatted: " + formatted);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println("Only Date: " + now.format(formatter2));
    }

    // =========================================================
    // 10) Parsing String to Date/Time
    // =========================================================
    static void parsingDemo() {
        System.out.println("----- Parsing Demo -----");

        String dateStr = "24-01-2026";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            LocalDate date = LocalDate.parse(dateStr, formatter);
            System.out.println("Parsed Date: " + date);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid Date Format ❌");
        }
    }

    // =========================================================
    // 11) Legacy Date <-> LocalDateTime Conversion
    // =========================================================
    static void legacyConversionDemo() {
        System.out.println("----- Legacy Date Conversion Demo -----");

        Date oldDate = new Date();
        System.out.println("Old Date: " + oldDate);

        // Date -> Instant -> LocalDateTime
        Instant instant = oldDate.toInstant();
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("Converted LocalDateTime: " + ldt);

        // LocalDateTime -> Instant -> Date
        Date newDate = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("Back to Date: " + newDate);
    }

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Java 8 DateTime API ==========\n");

        localDateDemo();
        System.out.println();

        localTimeDemo();
        System.out.println();

        localDateTimeDemo();
        System.out.println();

        zonedDateTimeDemo();
        System.out.println();

        instantDemo();
        System.out.println();

        durationDemo();
        System.out.println();

        periodDemo();
        System.out.println();

        formatterDemo();
        System.out.println();

        parsingDemo();
        System.out.println();

        legacyConversionDemo();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Why Java 8 Date-Time API introduced?
- Old Date/Calendar were mutable, not thread-safe, confusing.
- New API is immutable, thread-safe, better timezone handling.

2) LocalDate vs LocalTime vs LocalDateTime?
- LocalDate -> only date
- LocalTime -> only time
- LocalDateTime -> date + time

3) ZonedDateTime vs LocalDateTime?
- ZonedDateTime includes timezone
- LocalDateTime does not include timezone

4) Instant is used for?
- Machine timestamp in UTC (logging, events, DB timestamps)

5) Period vs Duration?
- Period -> date based (years, months, days)
- Duration -> time based (hours, minutes, seconds)

6) How to format date/time?
- Use DateTimeFormatter.ofPattern()

7) How to parse date string?
- LocalDate.parse(dateStr, formatter)

8) Are java.time classes thread-safe?
- YES (immutable)
*/

