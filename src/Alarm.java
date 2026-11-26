import java.time.LocalDateTime;
public class Alarm {
    private LocalDateTime scheduledTime;
    private String label;
    private String partnerPhoneNumber;
    private boolean confirmed;
    private boolean triggered;
    private boolean missed;

    public Alarm(LocalDateTime scheduledTime, String label, String partnerPhoneNumber) {
        this.scheduledTime = scheduledTime;
        this.label = label;
        this.partnerPhoneNumber = partnerPhoneNumber;
        this.confirmed = false;
    }

    public String getLabel() {
        return label;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public String getPartnerPhoneNumber() {
        return partnerPhoneNumber;
    }

    public boolean isConfirmed() {
        return confirmed;
    }
    
    public void confirm() {
        confirmed = true;
    }

    public boolean isDue(LocalDateTime currentTime) {
        return !triggered && !confirmed && !missed
        && !scheduledTime.isAfter(currentTime);
    }

    public void markTriggered() {
        triggered = true;
    }
    
    public void markMissed() {
        missed = true;
    }
    
    public boolean isMissed() {
        return missed;
    }
}