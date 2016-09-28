package no.itera.shop;

import no.itera.shop.actions.Action;
import no.itera.shop.actions.MainMenu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        showWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        Action currentAction = new MainMenu();
        while (true) {
            try {
                currentAction.showPrompt();
                Integer choice = scanner.nextInt();
                currentAction = currentAction.perform(choice);
                System.out.println();
            } catch (Exception e) {
                continue;
            }
        }
    }

    private static void showWelcomeMessage() {
        String message = "*******************************************************************\n" +
                "******************          W E L C O M E          ****************\n" +
                "******************            T O  T H E           ****************\n" +
                "******************             S H O P             ****************\n" +
                "*******************************************************************\n\n";

        System.out.println(message);

    }
}
