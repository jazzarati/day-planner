package main.java;

import main.java.exceptions.InvalidTimeException;
import main.java.exceptions.UnknownInputType;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static final String defaultFilePath = "myPlanner.txt";

    public static void main(String[] args) {
        final File file = new File(setupFile(args));

        System.out.print("Opening Day Planner");
        System.out.print(".");
        System.out.print(".");
        System.out.println(".");

        Activities activities;
        try {
            activities = ActivitiesFileStorage.load(file);
        } catch (IOException | InvalidTimeException e) {
            activities = new Activities();
        }
        listActivities(activities);

        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            input = scanner.nextLine();
            try {
                InputType inputType = InputTypeDetector.detect(input);
                if(inputType.equals(InputType.QUIT)) {
                    save(file, activities);
                    break;
                } else if(inputType.equals(InputType.LIST)) {
                    listActivities(activities);
                } else if(inputType.equals(InputType.ACTIVITY)) {
                    activities.add(NewActivityParser.parse(input));
                } else if(inputType.equals(InputType.DELETE)) {
                    Integer index = DeleteActivityParser.parse(input);
                    activities.remove(index);
                    System.out.println("Removed activity at " + index);
                } else if(inputType.equals(InputType.MOVE)) {
                    MoveCommand moveCommand = MoveParser.parse(input);
                    activities.move(moveCommand);
                    System.out.println("Moved activity to " + timeFormat.format(moveCommand.getTime()));
                } else if(inputType.equals(InputType.SAVE)) {
                    save(file, activities);
                } else if(inputType.equals(InputType.CLEAR)) {
                    System.out.println("Cleared all activites");
                    activities = new Activities();
                } else if(inputType.equals(InputType.HELP)) {
                    showHelp();
                }
            } catch (IOException | InvalidTimeException | UnknownInputType e) {
                e.printStackTrace();
            }
        } while(true);
    }

    private static String setupFile(String[] args) {
        return args.length > 0 ? args[0] : defaultFilePath;
    }

    private static void save(File file, Activities activities) throws IOException {
        ActivitiesFileStorage.store(file, activities);
        System.out.println("Saved activites to " + file.toString());
    }

    private static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
    private static void listActivities(Activities activities) {
        if(activities.size() == 0) {
            System.out.println("No activities planned");
            return;
        }

        int index = 0;
        for(Activity activity : activities) {
            System.out.println(index++ + " - " + timeFormat.format(activity.getStartsAt()) + " - " + activity.getAction());
        }
    }

    private static void showHelp() {
        System.out.println("Commands: ");
        System.out.println("--------------------------------");
        System.out.println("4 45 Do stuff: Add an activity to 'Do stuff' at 4:45");
        System.out.println("l: List current plan");
        System.out.println("d 2: Delete activity at index 2");
        System.out.println("s: Save activities");
        System.out.println("clear: Clear all activities");
        System.out.println("?: Show help");
        System.out.println("q: Save and quit\n");
    }
}
