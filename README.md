# Accountability Alarm App

## Project Goal

Help college students wake up for classes and exams without relying on their parents. If a student does not confirm they are awake, the program will notify a chosen friend who can check on them.

## MVP Scope

- Set an alarm with a time and label.
- Enter an accountability partner’s phone number.
- Play a sound when the alarm time is reached.
- Allow the user to confirm they are awake.
- Notify the partner if the user does not respond within a set time.

The working MVP will run in the terminal. The computer must stay awake and the program must remain running.

## Future Plans

- Add recurring alarms for weekly class schedules.
- Choose different accountability partners for different alarms.
- Track missed alarms and successful wake-ups.
- Allow partners to confirm they have checked on the user.
- Add reminders for regular tasks.

## Tech Stack

- Java for the program’s logic.
- HTML and CSS for an interface mockup.
- Arrays, ArrayLists, loops, and classes to manage alarms.
- Plain text files to store alarm information.
- Git and GitHub for version control.
- An SMS service for text notifications, which still needs to be selected and tested.

  ## Setup and Run

You need a Java Development Kit (JDK) with `javac` and `java` available in your terminal. Run the following from the repository’s top-level folder, where `src/` and `sounds/` are located.

```bash
javac -d build src/Alarm.java src/Main.java
java -cp build Main
```

The app includes its alarm sound at `sounds/alarm.wav`. Partner notifications are simulated in the terminal, so you don’t need an SMS account or API key.

Keep the program running and the computer awake until the alarm goes off.

## Project Structure

- `src/`: Java source code.
- `tests/`: Test files.
- `docs/`: Project planning documents and diagram files.

## Project Status

Planning stage. Implementation has not started.
