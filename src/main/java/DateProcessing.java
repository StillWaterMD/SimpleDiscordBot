import java.util.Date;

public class DateProcessing {

    public static Date getExecutionDate(Date current) {


        int hour = current.getHours();
        long totalShift;
        int hourOfEvent = 15;
        long hourShift = 60 * 60 * 1000; //1 час в милисекундах
        long longDate = current.getTime();

        if (hour > hourOfEvent) {
            totalShift = (24 - hour + hourOfEvent) * hourShift;
        } else {
            totalShift = (hourOfEvent - hour) * hourShift + 10 * 60 * 1000;
        }

        current.setTime(longDate + totalShift);

        return current;
    }


}
