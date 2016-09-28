package no.itera.shop.actions;

/**
 * Created by oleksandr.cherniaiev on 28-Sep-16.
 */
public class MainMenu implements Action {
    @Override
    public void showPrompt() {
        String prompt = "1. Product List\n" +
                        "2. Manufacturer List\n" +
                        "3. Account Details\n" +
                        "4. Exit";

        System.out.println(prompt);
    }

    @Override
    public Action perform(int i) {
        switch (i) {
            case 1:
                return new ProductList();
            case 2:
                return new ManfacturerList();
            case 3:
                return new AccountDetails();
            case 4:
                System.out.println("Bye bye!");
                System.exit(0);
            default:
                return this;
        }
    }
}
