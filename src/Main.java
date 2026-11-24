import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Alarm> alarms = new ArrayList<>();

        File saveFile = new File("data/alarms.txt");

        if (saveFile.exists()) {
            try {
                BufferedReader fileReader = new BufferedReader(
                    new FileReader(saveFile));
                    String savedLine = fileReader.readLine();

                    while (savedLine != null) {
                        String[] parts = savedLine.split("\\|", -1);

                        if (parts.length == 4) {
                            try {
                                LocalDateTime scheduledTime = LocalDateTime.parse(parts[0]);
                                Alarm savedAlarm = new Alarm(scheduledTime, parts[1], parts[2]);
                        
                                if (parts[3].equals("true")) {
                                    savedAlarm.confirm();
                                }
                        
                                alarms.add(savedAlarm);
                            } catch (DateTimeParseException e) {
                                System.out.println("Skipped a saved alarm with an invalid date or time.");
                            }
                        }                        savedLine = fileReader.readLine();
                    }

                    fileReader.close();

            } catch (IOException e) {
                System.out.println("Could not read saved alarms");
            }
        }
            

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Thread alarmChecker = new Thread(new Runnable() {
                
                public void run() {
                    while (true) { 
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            return;
                        }
                        synchronized (alarms) {
                            LocalDateTime currentTime = LocalDateTime.now();

                            for (Alarm alarm : alarms) {
                                if (alarm.isDue(currentTime)) {
                                    alarm.markTriggered();
                                    System.out.println("\nAlarm triggered: " + 
                                        alarm.getLabel());
                                }
                            
                            }
                        }
                    }
                }
                });
                alarmChecker.start();
            

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
                                        
                                        synchronized (alarms) {
                                            alarms.add(alarm);
                                        }
                                        saveFile.getParentFile().mkdirs();
                                        PrintWriter writer = new PrintWriter("data/alarms.txt");
                                        for (Alarm savedAlarm : alarms) {
                                            writer.println(savedAlarm.getScheduledTime() + "|" 
                                            + savedAlarm.getLabel() + "|"
                                            + savedAlarm.getPartnerPhoneNumber() + "|"
                                            + savedAlarm.isConfirmed());
                                        }
                                        writer.close();
                                        
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
            alarmChecker.interrupt();

        
    }
}