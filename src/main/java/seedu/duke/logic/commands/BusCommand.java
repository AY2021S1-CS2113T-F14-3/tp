package seedu.duke.logic.commands;

import seedu.duke.Bus;
import seedu.duke.BusData;
import seedu.duke.BusStops;
import seedu.duke.exceptions.CustomException;

import java.util.ArrayList;

import static seedu.duke.ui.Ui.printLine;

public class BusCommand extends Command {

    public String busStop;

    public BusCommand(String busStop) throws CustomException {
        this.busStop = BusStops.formatName(busStop.trim());
    }

    @Override
    public void executeCommand() {
        assert !busStop.isBlank() : "Bus stop is empty";
        printLine();
        ArrayList<Bus> busList = BusData.busAtStop(busStop);
        System.out.print(busStop + ":  ");
        for (Bus bus: busList) {
            System.out.print(bus.getBusNumber() + "   ");
        }
        System.out.println();
        printLine();
    }
}