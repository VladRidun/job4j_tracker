package ru.job4j.ood.isp;

public class AddToParentAction implements UserAction {
    private final Output out;

    public AddToParentAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add item to menu parent item";
    }

    @Override
    public boolean execute(Menu menu, Input input) {
        out.println("ADD ITEM TO MENU PARENT ITEM");
        String name = input.askStr("Enter name of new item: ");
        String parentName = input.askStr("Enter name of parent item: ");
        boolean result = menu.add(parentName, name, TodoApp.DEFAULT_ACTION);
        if (!result) {
            out.println("Item is exist. Enter Item with new name");
        } else {
            out.println("Item is added.");
        }
        return true;
    }
}