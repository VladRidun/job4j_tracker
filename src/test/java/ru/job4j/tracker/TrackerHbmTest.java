package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.HbmTracker;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerHbmTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenReplaceIsDone() throws Exception {
        try (var tracker = new HbmTracker()) {
            var itemAdd1 = tracker.add(new Item("test1"));
            for (Item i : tracker.findAll()) {
                System.out.println(i);
            }
            Item item2 = new Item();
            item2.setName("item2");
            int id = tracker.findById(itemAdd1.getId()).getId();
            tracker.replace(id, item2);
            System.out.println(tracker.findById(id));
            assertThat(tracker.findById(id).getName()).isEqualTo(item2.getName());
        }
    }

    @Test
    public void whenFindAllIsDone() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item first = tracker.add(new Item("First"));
            Item second = tracker.add(new Item("Second"));
            assertThat(List.of(first, second)).isEqualTo(tracker.findAll());
        }
    }

    @Test
    public void whenDeleteIsDone() {
        try (var tracker = new HbmTracker()) {
            Item bug = tracker.add(new Item("Bug"));
            for (Item i : tracker.findAll()) {
                System.out.println(i);
            }
            int id = bug.getId();
            tracker.delete(id);
            assertThat(tracker.findById(id)).isNull();
        }
    }

    @Test
    public void whenTestFindByNameCheckArrayAsSame() {
        try (var tracker = new HbmTracker()) {
            Item second1 = tracker.add(new Item("First"));
            Item second2 = tracker.add(new Item("First"));
            assertThat(List.of(second1, second2)).isEqualTo(tracker.findByName(second1.getName()));
        }
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        try (var tracker = new HbmTracker()) {
            Item first = tracker.add(new Item("First"));
            Item second = tracker.add(new Item("Second"));
            tracker.add(new Item("First"));
            tracker.add(new Item("Second"));
            tracker.add(new Item("First"));
            List<Item> result = tracker.findByName(second.getName());
            assertThat(result.get(1).getName()).isEqualTo(second.getName());
        }
    }
}