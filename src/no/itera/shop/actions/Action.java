package no.itera.shop.actions;

public interface Action {
    void showPrompt();
    Action perform(int i);
}
