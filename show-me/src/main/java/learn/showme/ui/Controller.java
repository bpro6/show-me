package learn.showme.ui;

import learn.showme.domain.ShowMeService;

public class Controller {

    private final View view;
    private final ShowMeService showMeService;

    public Controller(View view, ShowMeService showMeService) {
        this.view = view;
        this.showMeService = showMeService;
    }

    public void run() {
        view.displayHeader("Welcome to Air BnB");
        try {
            runApp();
        } catch (Exception ex) {
            view.displayException(ex);
        }
        view.displayMessage("Good bye.");
    }

    private void runApp() {

        MainMenuOption option;
        do {
            option = view.selectMainMenuOption();
            switch (option) {
                case CAESAR_CYPHER -> caesarCypher();
                case ROMAN_NUMERAL_CONVERTER -> romanNumeralConverter();

            }
        } while (option != MainMenuOption.EXIT);
    }

    public void caesarCypher(){

//        System.out.println("this is the caesar cypher");

        String[] options = {"RETURN TO MAIN","ENCODE","DECODE"};

String option = null;
        do {
            option = view.selectSubMenuOption(options);
            switch (option) {
                case "ENCODE"->{

                    String string = view.readString();
                    int index = view.readIndex();
                    System.out.println( showMeService.encodeCaesarCypher(string, index));}

                case "DECODE"-> {

                    String string = view.readString();
                    System.out.println(showMeService.decodeCaesarCypher(string));

                }

            }
        } while (!option.equals("RETURN TO MAIN"));

    }

    public void romanNumeralConverter() {

        String[] options = {"RETURN TO MAIN", "ROMAN NUMERAL TO INTEGER", "INTEGER TO ROMAN NUMERAL"};

        String option = null;

        do {
            option = view.selectSubMenuOption(options);

            switch (option) {
                case "ROMAN NUMERAL TO INTEGER" -> {

                    String string = view.readString();
                 //   showMeService.romanToInt(string);

                }

                case "INTEGER TO ROMAN NUMERAL" -> {

                    int I = view.readInt("enter number to convert: ");
                    System.out.println(showMeService.intToRoman(I));


                }
            }
        }while (!option.equals("RETURN TO MAIN"));
    }

}
