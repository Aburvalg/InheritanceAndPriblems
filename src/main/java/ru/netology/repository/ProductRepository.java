package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    public Product[] showAll() {
        return products;
    }

    public void removeById(int id) {
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product film : products) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        products = tmp;
    }

    public int amount() {
        int result = 0;
        for (Product product : showAll()) {
            result = result + product.getCount();
        }
        return result;
    }
}