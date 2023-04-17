package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    void asserThatTheProductAddIntoShop() {
        ControlQuality controlQuality = new ControlQuality();
        Food food = new Food("Milk", LocalDateTime.now().minusMonths(2), LocalDateTime.now().plusMonths(1), 100.0, 10);
        Food food1 = new Food("Cheese", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusDays(1), 100.0, 10);
        AbstractStore shop = new Shop();
        AbstractStore wareHouse = new Warehouse();
        AbstractStore trash = new Trash();
        List<AbstractStore> stores = List.of(wareHouse, shop, trash);
        controlQuality.sort(stores, food);
        controlQuality.sort(stores, food1);
        System.out.println(shop.findByName("Milk"));
        assertThat(food).isEqualTo(shop.findByName("Milk"));
    }

    @Test
    void asserThatNotAddProductIntoShop() {
        ControlQuality controlQuality = new ControlQuality();
        Food food = new Food("Milk", LocalDateTime.now(), LocalDateTime.now().plusMonths(1), 100.0, 10);
        Food food1 = new Food("Cheese", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusDays(1), 100.0, 10);
        AbstractStore shop = new Shop();
        AbstractStore wareHouse = new Warehouse();
        AbstractStore trash = new Trash();
        List<AbstractStore> stores = List.of(wareHouse, shop, trash);
        controlQuality.sort(stores, food);
        controlQuality.sort(stores, food1);
        assertThat(food).isNotEqualTo(shop.findByName("Cheese"));
    }

    @Test
    void asserThatAddProductIntoShopWhenPercentsMore75AndGetDiscount() {
        ControlQuality controlQuality = new ControlQuality();
        Food food = new Food("Milk", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusMonths(1), 100.0, 10);
        Food food1 = new Food("Cheese", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusDays(1), 100.0, 10);
        Food food3 = new Food("Milk", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusMonths(1), 90.0, 10);
        AbstractStore shop = new Shop();
        AbstractStore wareHouse = new Warehouse();
        AbstractStore trash = new Trash();
        List<AbstractStore> stores = List.of(wareHouse, shop, trash);
        controlQuality.sort(stores, food);
        controlQuality.sort(stores, food1);
        assertThat(food3).isEqualTo(shop.findByName("Milk"));
    }

    @Test
    void asserThatTheProductAddIntoWareHouse() {
        ControlQuality controlQuality = new ControlQuality();
        Food food = new Food("Milk", LocalDateTime.now().minusMonths(60), LocalDateTime.now().plusMonths(6), 100.0, 10);
        Food food1 = new Food("Cheese", LocalDateTime.now().minusDays(2), LocalDateTime.now().plusDays(1), 100.0, 10);
        AbstractStore shop = new Shop();
        AbstractStore wareHouse = new Warehouse();
        AbstractStore trash = new Trash();
        List<AbstractStore> stores = List.of(wareHouse, shop, trash);
        controlQuality.sort(stores, food);
        controlQuality.sort(stores, food1);
        assertThat(food).isEqualTo(wareHouse.findByName("Milk"));
    }

    @Test
    void asserThatNotAddProductIntoWareHouse() {
        ControlQuality controlQuality = new ControlQuality();
        Food food = new Food("Milk", LocalDateTime.now(), LocalDateTime.now().plusMonths(1), 100.0, 10);
        Food food1 = new Food("Cheese", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusDays(1), 100.0, 10);
        AbstractStore shop = new Shop();
        AbstractStore wareHouse = new Warehouse();
        AbstractStore trash = new Trash();
        List<AbstractStore> stores = List.of(wareHouse, shop, trash);
        controlQuality.sort(stores, food);
        controlQuality.sort(stores, food1);
        assertThat(food).isNotEqualTo(wareHouse.findByName("Cheese"));
    }

    @Test
    void asserThatTheProductAddIntoTrash() {
        ControlQuality controlQuality = new ControlQuality();
        Food food = new Food("Milk", LocalDateTime.now().minusDays(2), LocalDateTime.now().minusDays(4), 100.0, 10);
        Food food1 = new Food("Cheese", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusDays(1), 100.0, 10);
        AbstractStore shop = new Shop();
        AbstractStore wareHouse = new Warehouse();
        AbstractStore trash = new Trash();
        List<AbstractStore> stores = List.of(wareHouse, shop, trash);
        controlQuality.sort(stores, food);
        controlQuality.sort(stores, food1);
        assertThat(food).isEqualTo(trash.findByName("Milk"));
    }

    @Test
    void asserThatNotAddProductIntoTrash() {
        ControlQuality controlQuality = new ControlQuality();
        Food food = new Food("Milk", LocalDateTime.now().minusDays(2), LocalDateTime.now(), 100.0, 10);
        Food food1 = new Food("Cheese", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusDays(1), 100.0, 10);
        AbstractStore shop = new Shop();
        AbstractStore wareHouse = new Warehouse();
        AbstractStore trash = new Trash();
        List<AbstractStore> stores = List.of(wareHouse, shop, trash);
        controlQuality.sort(stores, food);
        controlQuality.sort(stores, food1);
        assertThat(food).isNotEqualTo(trash.findByName("Cheese"));
    }

}