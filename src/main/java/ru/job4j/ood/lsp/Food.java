package ru.job4j.ood.lsp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Food {
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime expiryDate;
    private Double price;
    private double discount;

    public Food(String name) {
    }

    public Food(String name, LocalDateTime createDate, LocalDateTime expiryDate, double price, double discount) {
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

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
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

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPercentExpiration() {
        var expirationDays = (double) Duration.between(createDate, expiryDate).toDays();
        var expirationDaysByNow = (double) Duration.between(LocalDateTime.now(), expiryDate).toDays();
        return ((expirationDaysByNow
                / expirationDays) * 100);
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiryDate);
    }

    public void applyDiscount() {
        this.price *= (1 - discount / 100);
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
