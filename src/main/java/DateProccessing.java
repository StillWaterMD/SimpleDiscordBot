import java.util.Date;

public class DateProccessing {

    public static Date getExecutionDate(Date current) {


        int hour = current.getHours();
        long totalShift;
        long hourShift = 60 * 60 * 1000; //1 час в милисекундах
        long longDate = current.getTime();

        if (hour > 15) {
            totalShift = (24 - hour + 17) * hourShift;
        } else {
            totalShift = (17 - hour) * hourShift + 30 * 60 * 1000;
        }

        current.setTime(longDate + totalShift);

        return current;
    }


}
