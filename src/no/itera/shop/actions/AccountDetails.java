package no.itera.shop.actions;

import no.itera.shop.db.Model;

/**
 * Created by oleksandr.cherniaiev on 28-Sep-16.
 */
public class AccountDetails implements Action {
    @Override
    public void showPrompt() {
        System.out.println("*** Account details ***\n\n" +
                "Your balance: $" + Model.getInstance().getBalance() + "\n" +
                "Purchased products:");
        for (String p : Model.getInstance().getProductsPurchased()) {
            System.out.print("\t");
            System.out.println(p);
        }
        System.out.println("\n" +
                "1. Return to Main Menu");
    }

    @Override
    public Action perform(int i) {
        switch (i) {
            case 1:
                return new MainMenu();
            default:
                return this;
        }
    }
}
