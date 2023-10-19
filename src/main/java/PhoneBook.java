import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {
    static Map<String, Integer> phoneBook = new TreeMap<>();
    public static Map<String, Integer> getPhoneBook() {
        return phoneBook;
    }
    public static int add(String name, int number) {

        if (!phoneBook.containsKey(name)) {
            phoneBook.putIfAbsent(name, number);
        }
        return phoneBook.size();
    }


    public static String findByNumber(int number) {
        Set<Map.Entry<String, Integer>> entrySet = phoneBook.entrySet();
        String name = null;
        for (Map.Entry<String, Integer> nameNumberPair : entrySet) {
            if (number == nameNumberPair.getValue()) {
                name = nameNumberPair.getKey();
            }
        }
        return name;
    }
}
