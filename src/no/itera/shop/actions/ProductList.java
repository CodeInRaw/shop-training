package no.itera.shop.actions;

import no.itera.shop.db.Model;
import no.itera.shop.domain.Product;

/**
 * Created by oleksandr.cherniaiev on 28-Sep-16.
 */
public class ProductList implements Action {
    @Override
    public void showPrompt() {
        System.out.println("*** Product list ***\n");

        for (int i = 0; i < Model.getInstance().getProducts().size(); i++) {
            Product p = Model.getInstance().getProducts().get(i);

            System.out.print(i + 1);
            System.out.print(". ");
            System.out.println(p.getName());
            System.out.println("\t\t" + p.getManufacturer().getName() + "\t\t$" + p.getPrice());
        }

        System.out.println("0. Return to Main Menu");
    }

    @Override
    public Action perform(int i) {
        if (i == 0) return new MainMenu();

        if (i > 0 && i <= Model.getInstance().getProducts().size()) {
            return new ProductDetails(Model.getInstance().getProducts().get(i - 1));
        }

        return this;
    }
}
