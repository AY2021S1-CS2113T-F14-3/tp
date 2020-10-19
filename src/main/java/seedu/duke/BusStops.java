package seedu.duke;

import seedu.duke.exceptions.CustomException;
import seedu.duke.exceptions.ExceptionType;

import java.util.Arrays;
import java.util.EnumSet;

import static seedu.duke.ui.Ui.printLine;

public enum BusStops {
    PGP("PGP", "Prince George's Park"),
    KENTRIDGEMRTSTATION("Kent Ridge MRT Station", "Kent Ridge MRT entrance", new String[]{"kr mrt", "krmrt"}),
    OPPUNIVERSITYHEALTHCENTRE("Opp University Health Centre", "Near University Health Centre", new String[]{"opp UHC"}),
    YUSOFISHAKHOUSE("Yusof Ishak House", "Location with the Student Service center", new String[]{"YIH"}),
    CENTRALLIBRARY("Central Library", "also known as CLB", new String[]{"CLB"}),
    KENTRIDGE("Kent Ridge", "Kent Ridge"),
    MUSEUM("Museum", "Opposite Faculty of Engineering"),
    UNIVERSITYTOWN("University Town", "Place filled with dining and recreational options", new String[]{"Utown"}),
    UNIVERSITYHEALTHCENTRE("University Health Centre", "UHC, where students can get MC", new String[]{"UHC"}),
    OPPKENTRIDGEMRTSTATION("Opp Kent Ridge MRT station", "Opposite Kent Ridge MRT"),
    RAFFLESHALL("Raffles Hall", "Hall located near Faculty of Engineering"),
    KENTVALE("Kent Vale", "Accommodation for visiting faculty guests"),
    EA("EA", "Located in Faculty of Engineering"),
    NUSIT("NUS IT", "Opposite Central library",new String[]{"IT"}),
    LT27("LT27", "Lim Seng Tjoe Lecture theatre at faculty of science, Opposite of S17 bus stop"),
    OPPUNIVERSITYHALL("Opp University Hall","Opp of University Hall, near a football field"),
    S17("S17","outside of S17, opposite of LT27"),
    UNIVERSITYHALL("University Hall","University Hall"),
    TCOMS("TCOMS","IDK"),
    OPPHSSML("Opp HSSML","idk"),
    OPPNUSS("Opp NUSS","idk"),
    COM2("COM2", "COM2, within School of Computing"),
    VENTUS("Ventus, Opp LT13","idk"),
    OPPYUSOFISHAKHOUSE("Opp Yusof Ishak House", "Opposite YIH, near Faculty of Engineering", new String[]{"opp YIH"}),
    LT13("LT13","idk"),
    AS5("AS5","idk"),
    BIZ2("BIZ2","Near Faculty of Business"),
    OPPTCOMS("Opp TCOMS","idk help"),
    OEITIONGHAM("Oei Tiong Ham(BTC)","idk"),
    BOTANICGARDENSMRT("Botanic Gardens MRT","MRT station"),
    COLLEGEGREEN("College Green", "idk"),
    PGPR("PGPR", "Prince George's Park Residence");

    private final String description;
    private final String name;
    private int count;
    private String [] closeNames = {};

    BusStops(String name, String description) {
        this.description = description;
        this.name = name;
        this.count = 0;
    }

    BusStops(String name, String description, String[] closeNames) {
        this.description = description;
        this.name = name;
        this.count = 0;
        this.closeNames = closeNames;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public static String formatName(String input) throws CustomException {
        for (BusStops info: EnumSet.allOf(BusStops.class)) {
            if (info.name.equalsIgnoreCase(input)) {
                return info.name;
            }
        }
        throw new CustomException(ExceptionType.INVALID_BUS_STOP);
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static void listStops() {
        printLine();
        for (BusStops info : EnumSet.allOf(BusStops.class)) {
            System.out.print(info.name + " : " + info.description + ".");
            if (info.closeNames.length > 0) {
                System.out.print(" Also known as: ");
                for (String aka : info.closeNames) {
                    System.out.print("\"" + aka + "\" ");
                }
            }

            System.out.println();
        }
        printLine();
    }

}
