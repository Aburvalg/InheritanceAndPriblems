package ru.netology.domain;

public class Smartphone extends Product {
    private String brand;

    public Smartphone(int id, String name, int count, String brand) {
        super(id, name, count);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return getBrand().contains(search);
    }


}
