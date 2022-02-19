package ru.netology.domain;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book first = new Book(1, "Want to sleep", 1, "A.Chekhov");
    private Book second = new Book(2, "A-50", 4, "Samsung");

    private Book third = new Book(3, "Want to sleep", 1, "A.Chekhov");

    @Test
    void shouldSearchByName() {
        Book expected = first;
        Book actual = matches();//cann't found method matches, why?
        assertArrayEquals(expected,actual);
    }


}