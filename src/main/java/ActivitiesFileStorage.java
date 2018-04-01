package main.java;

import main.java.exceptions.InvalidTimeException;

import java.io.*;
import java.time.format.DateTimeFormatter;

public class ActivitiesFileStorage {

    private static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H m");

    public static void store(File file, Activities activities) throws IOException {
        try (FileWriter writer = new FileWriter(file, false)) {
            for(Activity activity : activities) {
                writer.write(timeFormat.format(activity.getStartsAt()) + " " + activity.getAction() + "\n");
            }
            writer.flush();
            writer.close();
        }
    }

    public static Activities load(File file) throws IOException, InvalidTimeException {
        Activities activities = new Activities();
        try (FileReader reader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                activities.add(NewActivityParser.parse(line));
            }
            return activities;
        }
    }
}
