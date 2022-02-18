package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.productManager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository();

    private Product first = new Product(1, "first", 100);
    private Book second = new Book(2, "Want to sleep", 1, "A.Chekhov");
    private Smartphone third = new Smartphone(3, "A-50", 4, "Samsung");

    @BeforeEach
    public void setUp() {
        repo.save(first);
        repo.save(second);
        repo.save(third);

    }

    @Test
    void shouldSave() {

        Product[] expected = {first, second, third};
        Product[] actual = repo.showAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {

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