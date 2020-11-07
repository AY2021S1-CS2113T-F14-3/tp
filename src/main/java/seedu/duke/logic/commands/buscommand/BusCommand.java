package seedu.duke.logic.commands.buscommand;

import seedu.duke.exceptions.ExceptionType;
import seedu.duke.model.bus.Bus;
import seedu.duke.model.bus.BusData;
import seedu.duke.model.bus.BusStops;
import seedu.duke.exceptions.CustomException;
import seedu.duke.logic.similaritycheck.SimilarityCheck;
import seedu.duke.logic.commands.commons.Command;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.EnumSet;

public class BusCommand extends Command {

    private String busStop;

    public BusCommand(String busStop) throws CustomException {
        ArrayList<String> possibleLocs = new ArrayList<>(similarLocations(busStop));
        if (possibleLocs.isEmpty()) {
            this.busStop = BusStops.formatName(busStop.trim());
            BusStops.findBusStop(busStop).incrementSearchCount();
            super.isValid = true;
        } else {
            Ui.printPossibleLocsMessage(possibleLocs);
            super.isValid = false;
            throw new CustomException(ExceptionType.POSSIBLE_LOCS_DUMMY);
        }
    }

    @Override
    public void executeCommand() {
        ArrayList<Bus> busList = BusData.getBusAtStop(busStop);
        Ui.printBusAtBusStop(busList, busStop);
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
