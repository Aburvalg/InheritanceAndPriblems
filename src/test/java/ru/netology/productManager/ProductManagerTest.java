package ru.netology.productManager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {

    @Test
    public void add() {
        Product first = new Product(1, "sdgfs", 100);
        Book second = new Book(2, "sdgf", 35, "vre");
        Smartphone third = new Smartphone(3, "dsfre", 54, "wesc");
        Book forth = new Book("egrt");
        Smartphone fifth = new Smartphone("F-50");

        ProductRepository repo = new ProductRepository();

        ProductManager manager = new ProductManager(repo);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);

        Product[] expected = {first, second, third, forth, fifth};
        Product[] actual = repo.showAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBy() {
        Product first = new Product(1, "sdgfs", 100);
        Book second = new Book(2, "sdgf", 35, "vre");
        Smartphone third = new Smartphone(3, "dsfre", 54, "wesc");

        ProductRepository repo = new ProductRepository();

        ProductManager manager = new ProductManager(repo);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Product[] expected = {first}; // при вводе first тест падает
        Product[] actual = manager.searchBy("sdgfs");
        assertArrayEquals(expected, actual);
    }


}