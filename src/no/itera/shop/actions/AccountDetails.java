package no.itera.shop.actions;

/**
 * Created by oleksandr.cherniaiev on 28-Sep-16.
 */
public class AccountDetails implements Action {
    @Override
    public void showPrompt() {
        System.out.println("Account details\n\n" +
                "1. Return to Main Menu\n" +
                "2. Exit");
    }

    @Override
    public Action perform(int i) {
        switch (i) {
            case 1:
                return new MainMenu();
            case 2:
                System.out.println("Bye bye!");
                System.exit(0);
            default:
                return this;
        }
    }
}
