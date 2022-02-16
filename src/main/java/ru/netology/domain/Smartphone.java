package ru.netology.domain;

public class Smartphone extends Product {
    private String model;

    public Smartphone(int id, String name, int count, String model) {
        super(id, name, count);
        this.model = model;
    }

    public Smartphone(String model) {
        this.model = model;
    }
}
