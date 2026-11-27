# Accountability Alarm App

## Project Goal

Help college students wake up for classes and exams without relying on their parents. If a student does not confirm they are awake within 15 seconds, the program prints a simulated SMS addressed to their accountability partner.

## MVP Scope

- Set an alarm with a time and label.
- Enter an accountability partner’s phone number.
- Play a sound when the alarm time is reached.
- Allow the user to confirm they are awake.
- Print a simulated SMS if the user does not respond within 15 seconds.

The working MVP will run in the terminal. The computer must stay awake and the program must remain running.

## Roadmap

### Completed
- Create and list alarms with a date, time, label, and partner phone number.
- Save alarms locally and restore them when the app starts.
- Play an alarm sound and allow 15 seconds to confirm.
- Save confirmed and missed outcomes and print a simulated SMS for missed alarms.
- Create an HTML/CSS interface mockup in `mockup/`.

### Planned
- Add recurring alarms for weekly class schedules.
- Show a history of missed alarms and successful wake-ups.
- Allow partners to confirm they checked on the user.
- Add reminders for regular tasks.

## Tech Stack

- Java for the program’s logic.
- HTML and CSS for an interface mockup.
- Arrays, ArrayLists, loops, and classes to manage alarms.
- Plain text files to store alarm information.
- Git and GitHub for version control.

  ## Setup and Run

You need a Java Development Kit (JDK) with `javac` and `java` available in your terminal. Run the following from the repository’s top-level folder, where `src/` and `sounds/` are located.

```bash
javac -d build src/Alarm.java src/Main.java
java -cp build Main
```

The app includes its alarm sound at `sounds/alarm.wav`. Partner notifications are simulated in the terminal, so you don’t need an SMS account or API key.

Keep the program running and the computer awake until the alarm goes off.

## How to Use

1. Choose `1` to create an alarm. Enter a label, a 10-digit partner phone number, and a future date and time in `YYYY-MM-DDTHH:MM` format. The `T` separates the date and time. For a quick test, pick a time a couple of minutes ahead.
2. Choose `2` to list alarms. The app saves alarms in `data/alarms.txt` and loads them when it starts.
3. When the alarm rings, type `awake` at the menu prompt and press Enter within 15 seconds. If the window expires, the app stops the sound and prints a simulated SMS to the terminal.
4. Choose `3` to exit.

## Project Structure

- `src/`: Java source code.
- `tests/`: Test files.
- `docs/`: Project planning documents and diagram files.
- `mockup/` contains the HTML/CSS interface preview.
- `sounds/alarm.wav` is the bundled alarm sound.
- `data/alarms.txt` is created locally when you save your first alarm.

## Project Status

The terminal MVP is implemented and has been tested from a fresh clone. The HTML/CSS mockup shows how the app could look with a visual interface.