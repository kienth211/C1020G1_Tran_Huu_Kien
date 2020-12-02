package bai4_class.bai_tap.e2_stop_watch;
import java.time.LocalTime;
public class StopWatch {
    private LocalTime startTime;
    private LocalTime endTime;
    private long startTimeLong;
    private long endTimeLong;

    public StopWatch() {
    }

    public LocalTime getStartTime() {
        this.startTime = java.time.LocalTime.now();
        setStartTimeLong();
        return this.startTime;
    }

    public LocalTime getEndTime() {
        this.endTime = java.time.LocalTime.now();
        setEndTimeLong();
        return this.endTime;
    }

    public void setStartTimeLong() {
        this.startTimeLong = System.currentTimeMillis();
    }

    public void setEndTimeLong() {
        this.endTimeLong = System.currentTimeMillis();
    }

    public long getStartTimeLong() {
        return this.startTimeLong;
    }

    public long getEndTimeLong() {
        return this.endTimeLong;
    }

    public long calculator(){
        return  getEndTimeLong() - getStartTimeLong();
    }
}
