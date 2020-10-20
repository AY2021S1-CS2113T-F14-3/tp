package seedu.duke.logic.commands;

import seedu.duke.Bus;
import seedu.duke.BusData;
import seedu.duke.BusStops;
import seedu.duke.exceptions.CustomException;
import seedu.duke.logic.SimilarityCheck;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.EnumSet;

import static seedu.duke.ui.Ui.printLine;

public class BusCommand extends Command {

    public String busStop;

    public BusCommand(String busStop) throws CustomException {
        ArrayList<String> possibleLocs = new ArrayList<>(similarLocations(busStop));
        if (possibleLocs.isEmpty()) {
            this.busStop = BusStops.formatName(busStop.trim());
        } else {
            Ui.printPossibleLocsMessage(possibleLocs);
        }
    }

    @Override
    public void executeCommand() {
        if (busStop != null) {
            assert !busStop.isBlank() : "Bus stop is empty";
            printLine();
            ArrayList<Bus> busList = BusData.busAtStop(busStop);
            System.out.print(busStop + ":  ");
            for (Bus bus : busList) {
                System.out.print(bus.getBusNumber() + "   ");
            }
            System.out.println();
            printLine();
        }
    }

    private ArrayList<String> similarLocations(String location) {
        ArrayList<String> possibleLocs = new ArrayList<>();
        ArrayList<String> routeNames = new ArrayList<>();
        for (BusStops info: EnumSet.allOf(BusStops.class)) {
            routeNames.add(info.getName().toLowerCase());
        }
        if (!routeNames.contains(location.trim().toLowerCase())) {
            possibleLocs = SimilarityCheck.similarLoc(location);
        }
        return possibleLocs;
    }
}
