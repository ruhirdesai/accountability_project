import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Alarm> alarms = new ArrayList<>();
            

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        while (true) { 
                            
                            System.out.println("Accountability Alarm App");
                            System.out.println("1. Create an alarm");
                            System.out.println("2. List alarms");
                            System.out.println("3. Exit");
                            System.out.print("Choose an option: ");

                        String choice = br.readLine();
                        if (choice == null) {
                            break;
                        }
                        if (choice.equals("1")) {
                            System.out.print("Enter alarm label: ");
                            String label = br.readLine();
                            if (label == null) {
                                break;
                            }
                            System.out.println("Alarm label: " + label);
                            System.out.print("Enter partner phone number: ");
                            String partnerPhoneNumber = br.readLine();
                            if (partnerPhoneNumber == null) {
                                break;
                            }
                            System.out.println("Partner phone number: " + partnerPhoneNumber);
                            System.out.print("Enter alarm date and time (YYYY-MM-DDTHH:MM): ");
                            String dateTimeInput = br.readLine();
                            if (dateTimeInput == null) {
                                break;
                            }
                                try {
                                    LocalDateTime scheduledTime = LocalDateTime.parse(dateTimeInput);

                                    if (scheduledTime.isAfter(LocalDateTime.now())) {
                                        Alarm alarm = new Alarm(scheduledTime, label, partnerPhoneNumber);
                                        alarms.add(alarm);
                                        System.out.println("Alarm created: " + alarm.getLabel());
                                    } else {
                                        System.out.println("Choose a date and time in the future.");
                                    }
                                } catch (DateTimeParseException e) {
                                    System.out.println("Invalid date or time. Use YYYY-MM-DDTHH:MM.");
                                }
                            } 
                        else if (choice.equals("2")) {
                            if (alarms.isEmpty()) {
                                System.out.println("No alarms yet.");
                            } else {
                                for (Alarm alarm : alarms) {
                                    System.out.println(alarm.getScheduledTime() + " - " + alarm.getLabel());
                                }
                            }
                        } 
                        else if (choice.equals("3")) {
                            System.out.println("Goodbye!");
                            break;

                        } else {
                            System.out.println("Please enter 1, 2, or 3.");
                        }
                    }
                    } catch (IOException e) {
                    System.out.println("Could not read your choice.");
                
            }
        
    }
}