package Menues;

public enum ATMMenu {

    DISPLAY_CURRENT_BALANCE(1, "Display current balance"),
    CASH_WITHDRAWAL(2, "Cash withdrawal"),
    CASH_DEPOSIT(3, "Cash deposit"),
    CHANGE_PIN(4, "Change PIN"),
    EXIT(5, "Exit");
    private int optionNumber;
    private String optionDescription;

    ATMMenu(int optionNumber, String optionDescription){
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
