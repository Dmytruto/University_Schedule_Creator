import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class Time {
    private int timeId;
    private String time;
    private DayOfWeek day;
    Locale locale = Locale.getDefault();

    Time(int timeId, DayOfWeek day, String time){
        this.timeId = timeId;
        this.time = time;
        this.day = day;
    }

    public int getTimeId(){
        return this.timeId;
    }

    public String getTime(){
        return this.day.getDisplayName(TextStyle.FULL, locale) + " " + this.time;
    }

    public DayOfWeek getDay(){
        return this.day;
    }

    public Integer getLessonStartHour(){
        return Integer.parseInt(this.time.split(":")[0]);
    }
}
