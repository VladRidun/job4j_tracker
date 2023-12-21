package ru.job4j.tracker.actions;

import ru.job4j.tracker.store.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;

public class EditItemAction implements UserAction {
    private final Output out;

    public EditItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new name for item: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Заявка изменена успешно.");
        } else {
            out.println(String.format("Item with id=%s not found.", id));
        }
        return true;
    }
}