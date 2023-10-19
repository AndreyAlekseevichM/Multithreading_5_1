import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;


public class PhoneBookTest {
    Map<String, Integer> expected = new TreeMap<>();

    @BeforeAll
    static void contactAdd() {
        PhoneBook.add("Petya", 1000000001);
        PhoneBook.add("Olya", 1000000002);
    }

    @Test
    void add() {
        int actualNumber = PhoneBook.add("Olya", 1000000002);
        expected.put("Olya", 1000000002);
        expected.put("Petya", 1000000001);
        int expectedNumber = expected.size();
        Map<String, Integer> actual = PhoneBook.getPhoneBook();
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expectedNumber, actualNumber);
    }

    @Test
    void findByNumber() {
        String expected = "Petya";
        String actual = PhoneBook.findByNumber(1000000001);
        String nonExpected = "Olya";
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotEquals(nonExpected, actual);
        Assertions.assertNotNull(actual);
    }

    @Test
    void findByName() {
        int expected = 1000000002;
        int actual = PhoneBook.findByName("Olya");
        int nonExpected = 1000000001;
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotEquals(nonExpected, actual);
        Assertions.assertNotNull(actual);
    }

}
