import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LocalDateTime scheduledTime = LocalDateTime.of(2026, 11, 20, 7, 30);
        Alarm alarm = new Alarm(scheduledTime, "Math Exam", "202-555-0100");
        ArrayList<Alarm> alarms = new ArrayList<>();
        alarms.add(alarm);

        System.out.println(alarm.getScheduledTime());
        System.out.println(alarms.get(0).getLabel());        
        System.out.println(alarm.getPartnerPhoneNumber());
        System.out.println(alarm.isConfirmed());
    }
}