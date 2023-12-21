package learn.showme.ui;

public enum MainMenuOption {

    EXIT("Exit"),
    CAESAR_CYPHER("Caesar Cypher"),

    ROMAN_NUMERAL_CONVERTER("Roman Numeral Converter");

    private String label;

    public String getLabel() { return label; }

    MainMenuOption(String label) { this.label = label; }

}
