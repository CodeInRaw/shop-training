package no.itera.shop.actions;

import no.itera.shop.db.Model;
import no.itera.shop.domain.Product;

/**
 * Created by oleksandr.cherniaiev on 28-Sep-16.
 */
public class BuyConfirmation implements Action {
    private Product product;

    public BuyConfirmation(Product product) {
        this.product = product;
    }

    @Override
    public void showPrompt() {
        System.out.println("*** Buy Confirmation ***\n\n" +
                "Are you sure you want to Buy " + product.getName() + " for $" + product.getPrice() + "?\n\n" +
                "1. Yes, I am sure. Buy\n" +
                "2. No. Return to product details\n" +
                "3. Return to main menu");
    }

    @Override
    public Action perform(int i) {
        switch (i) {
            case 1:
                if (Model.getInstance().getBalance() < product.getPrice()) {
                    System.out.println("ERROR! Insufficient funds.");
                    return new ProductDetails(product);
                }

                Model.getInstance().setBalance(Model.getInstance().getBalance() - product.getPrice());
                Model.getInstance().getProductsPurchased().add(product.getName());
                System.out.println(product.getName() + " is purchased.\n");
                return new AccountDetails();
            case 2:
                return new ProductDetails(product);
            case 3:
                return new MainMenu();
            default:
                return this;
        }
    }
}
