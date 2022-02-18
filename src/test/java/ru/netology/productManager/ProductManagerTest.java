package ru.netology.productManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);

    private Product first = new Product(1, "first", 100);
    private Book second = new Book(2, "Want to sleep", 1, "A.Chekhov");
    private Smartphone third = new Smartphone(3, "A-50", 4, "Samsung");

    private Book forth = new Book(4, "Want to sleep", 1, "A.Chekhov");
    private Smartphone fifth = new Smartphone(5, "A-50", 4, "Samsung");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

    }

    @Test
    public void add() {

        Product[] expected = {first, second, third};
        Product[] actual = repo.showAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByProduct() {
        Product[] expected = {first};
        Product[] actual = manager.searchBy("first");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByBook() {
        Product[] expected = {second};
        Product[] actual = manager.searchBy("Want to sleep");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByPhone() {
        Product[] expected = {third};
        Product[] actual = manager.searchBy("A-50");
        assertArrayEquals(expected, actual);
    }

    @Test   // При пустом запросе выдается весь массив!!!!!!!
    public void searchByEmptySearch() {
        Product[] expected = {first, second, third};
        Product[] actual = manager.searchBy("");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBySimilar() {
        manager.add(forth);
        Product[] expected = {second, forth};
        Product[] actual = manager.searchBy("Want to sleep");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNothing() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("efver");
        assertArrayEquals(expected, actual);
    }


}