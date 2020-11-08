package seedu.duke.logic.commands.buscommand;

import seedu.duke.model.bus.Bus;
import seedu.duke.model.bus.BusData;
import seedu.duke.exceptions.CustomException;
import seedu.duke.exceptions.ExceptionType;
import seedu.duke.logic.commands.commons.Command;
import seedu.duke.ui.Ui;

public class RouteMapCommand extends Command {
    private String busCode;

    public RouteMapCommand(String busCode) {
        this.busCode = busCode.trim();
    }

    @Override
    public void executeCommand() throws CustomException {
        String userBusRouteSelection = this.busCode;
        checkBusCode(userBusRouteSelection);
        selectAndPrintBusRoute(userBusRouteSelection);
    }

    /**
     * Select and print bus route, if found.
     *
     * @param userBusRouteSelection user-specified bus route
     * @throws CustomException to catch missing bus code or invalid bus code
     */
    private void selectAndPrintBusRoute(String userBusRouteSelection) throws CustomException {
        assert !userBusRouteSelection.isBlank() : "User input is empty.";
        try {
            Bus selectedBus = BusData.selectBus(userBusRouteSelection);
            Ui.printFullRoute(selectedBus);
        } catch (NullPointerException e) {
            throw new CustomException(ExceptionType.INVALID_BUS);
        }
    }

    /**
     * Checks validity of bus code.
     *
     * @param userBusRouteSelection user-specified bus route
     * @throws CustomException to catch missing bus code or invalid bus code
     */
    private void checkBusCode(String userBusRouteSelection) throws CustomException {
        if (userBusRouteSelection.isEmpty()) {
            throw new CustomException(ExceptionType.MISSING_BUS_CODE);
        }
        if (userBusRouteSelection.isBlank()) {
            throw new CustomException(ExceptionType.MISSING_BUS_CODE);
        }
    }
}

