package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Food {
    private String name;
    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime expiryDate = LocalDateTime.now();
    private Double price;
    private int discount;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    public Food(String name) {
    }

    public Food(String name, LocalDateTime createDate, LocalDateTime expiryDate, Double price, int discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public Double getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return discount == food.discount
                && Objects.equals(name, food.name)
                && Objects.equals(createDate, food.createDate)
                && Objects.equals(expiryDate, food.expiryDate)
                && Objects.equals(price, food.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createDate, expiryDate, price, discount);
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", createDate=" + createDate
                + ", expiryDate=" + expiryDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}
