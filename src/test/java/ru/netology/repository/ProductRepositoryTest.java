package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    void shouldSave() {
        Product first = new Product(1, "sdgfs", 100);
        Book second = new Book(2, "sdgf", 35, "vre");
        Book third = new Book("rger");
        Smartphone forth = new Smartphone(3, "dsfre", 54, "wesc");
        Smartphone fifth = new Smartphone("F-50");

        ProductRepository repo = new ProductRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(forth);
        repo.save(fifth);


        Product[] expected = {first, second, third, forth, fifth};
        Product[] actual = repo.showAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        Product first = new Product(1, "sdgfs", 100);
        Book second = new Book(2, "sdgf", 35, "vre");
        Smartphone third = new Smartphone(3, "dsfre", 54, "wesc");


        ProductRepository repo = new ProductRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);

        repo.removeById(2);

        Product[] expected = {first, third};
        Product[] actual = repo.showAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveEmpty() {

        ProductRepository repo = new ProductRepository();

        Product[] expected = {};
        Product[] actual = repo.showAll();
        assertArrayEquals(expected, actual);
    }


}