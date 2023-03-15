package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe")).isEqualTo(new Order("3sfe", "Dress"));
    }

    @Test
    public void whenManyOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1s2e", "Suit"));
        orders.add(new Order("1d3f", "Shoes"));
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.size()).isEqualTo(3);
    }
}