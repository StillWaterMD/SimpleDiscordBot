import java.util.Date;

public class DateProccessing {

    public static Date getExecutionDate(Date current) {

        Date when = new Date();

        int hour = current.getHours();
        long hourShift = 60 * 60 * 1000; //1 час в милисекундах
        long totalShift;
        if (hour > 15) {

            totalShift = (24 - hour + 17) * hourShift;

        } else {

            totalShift = (17 - hour) * hourShift + 30 * 60 * 1000;

        }

        long longDate = current.getTime();
        when.setTime(longDate + totalShift);

        return when;
    }


}
