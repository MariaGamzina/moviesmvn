package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieManager;


public class MovieManagerTest {

    @Test
    public void testEmpty() {
        MovieManager manager = new MovieManager();

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOne() {
        MovieManager manager = new MovieManager();

        manager.save("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testFew() {
        MovieManager manager = new MovieManager();

        manager.save("Бладшот");
        manager.save("Вперёд");
        manager.save("Отель Белград");

        String[] expected = {"Бладшот", "Вперёд", "Отель Белград"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastLowLimit() {
        MovieManager manager = new MovieManager();

        manager.save("Бладшот");
        manager.save("Вперёд");
        manager.save("Отель Белград");

        String[] expected = {"Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastLimit() {
        MovieManager manager = new MovieManager();

        manager.save("Бладшот");
        manager.save("Вперёд");
        manager.save("Отель Белград");
        manager.save("Джентельмены");
        manager.save("Человек-невидимка");

        String[] expected = {"Человек-невидимка", "Джентельмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastHighLimit() {
        MovieManager manager = new MovieManager();

        manager.save("Бладшот");
        manager.save("Вперёд");
        manager.save("Отель Белград");
        manager.save("Джентельмены");
        manager.save("Человек-невидимка");
        manager.save("Тролли. Мировой тур");

        String[] expected = {"Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель Белград", "Вперёд"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastSetLimit() {
        MovieManager manager = new MovieManager(6);

        manager.save("Бладшот");
        manager.save("Вперёд");
        manager.save("Отель Белград");
        manager.save("Джентельмены");
        manager.save("Человек-невидимка");
        manager.save("Тролли. Мировой тур");

        String[] expected = {"Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastSetLimitLow() {
        MovieManager manager = new MovieManager(7);

        manager.save("Бладшот");
        manager.save("Вперёд");
        manager.save("Отель Белград");
        manager.save("Джентельмены");
        manager.save("Человек-невидимка");
        manager.save("Тролли. Мировой тур");

        String[] expected = {"Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastSetLimitHigh() {
        MovieManager manager = new MovieManager(6);

        manager.save("Бладшот");
        manager.save("Вперёд");
        manager.save("Отель Белград");
        manager.save("Джентельмены");
        manager.save("Человек-невидимка");
        manager.save("Тролли. Мировой тур");
        manager.save("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель Белград", "Вперёд"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
