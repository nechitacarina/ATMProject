package Menues;

public enum StartMenu {
    LOGIN(1, "Login"),
    EXIT(2, "Exit");

    private int optionNumber;
    private String optionDescription;

    StartMenu(int optionNumber, String optionDescription){
        this.optionNumber = optionNumber;
        this.optionDescription = optionDescription;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public String getOptionDescription() {
        return optionDescription;
    }
}
