package seedu.duke;

import java.util.ArrayList;
import java.util.Arrays;

public class FoodPlace {

    private ArrayList<String> faculty = new ArrayList<>();
    private ArrayList<DiningOptions> info = new ArrayList<>();

    public FoodPlace(String[] faculty, String[][] data) {
        this.faculty.addAll(Arrays.asList(faculty));
        for (int i = 0; i < data.length; i++) {
            info.add(new DiningOptions(data[i]));
        }
    }

}
