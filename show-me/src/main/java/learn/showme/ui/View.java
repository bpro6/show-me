package learn.showme.ui;

import java.util.List;

public class View {

    private final ConsoleIO io;

    public View(ConsoleIO io) {
        this.io = io;
    }

    public MainMenuOption selectMainMenuOption() {
        io.printHeader("Main Menu");
        MainMenuOption[] values = MainMenuOption.values();
        for (int i = 0; i < values.length; i++) {
            io.printf("%s. %s%n", i, values[i].getLabel());
        }
        String msg = String.format("Select [0-%s]: ", values.length - 1);
        int index = io.readInt(msg, 0, values.length - 1);
        io.println();
        return values[index];
    }

    public String selectSubMenuOption(String[] values){

        for (int i = 0; i < values.length; i++) {
            io.printf("%s. %s%n", i, values[i]);
        }
        String msg = String.format("Select [0-%s]: ", values.length - 1);
        int index = io.readInt(msg, 0, values.length - 1);
        io.println();
        return values[index];



    }

    public void displayHeader(String message) {
        io.printHeader(message);
    }

    public void displayException(Exception ex) {
        io.println("[FATAL ERR]");
        io.println(ex.getMessage());
        io.println();
    }

    public void displayMessage(String message) {
        io.println(message);
    }

    public void displayErrors(List<String> errors) {
        displayMessage("[Errors]");
        for (String error : errors) {
            io.println(error);
        }
    }

    public String readString(){

        return io.readRequiredString("enter string: ");

    }
    public int readIndex(){

        return io.readInt("Enter number from 1 to 26: ");
    }

    public int readInt(String prompt){

        return io.readInt(prompt,0,1000000);
    }

}
