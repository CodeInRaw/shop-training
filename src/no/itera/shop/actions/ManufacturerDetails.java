package no.itera.shop.actions;

import no.itera.shop.domain.Manufacturer;
import no.itera.shop.domain.Product;

/**
 * Created by oleksandr.cherniaiev on 28-Sep-16.
 */
public class ManufacturerDetails implements Action {
    private Manufacturer manufacturer;

    public ManufacturerDetails(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public void showPrompt() {
        System.out.println("*** " + manufacturer.getName() + " ***");
        System.out.println("Country: " + manufacturer.getOriginCountry());
        System.out.println("Products count: " + manufacturer.getProducts().size());
        System.out.println();
        System.out.println(manufacturer.getDescription());

        System.out.println("\n" +
                "1. Return to the list of manufacturers\n" +
                "2. Return to main menu");
    }

    @Override
    public Action perform(int i) {
        switch (i) {
            case 1:
                return new ManufacturerList();
            case 2:
                return new MainMenu();
            default:
                return this;
        }
    }
}
