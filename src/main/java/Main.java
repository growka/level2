import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        String[] arrayFruit = {"apple", "apple", "apple", "orange", "melon", "apple", "kiwi", "kiwi", "melon",
                "banana", "kiwi"};

        HashMap<String, Integer> fruit = new HashMap<>();
        for (String x : arrayFruit) {
            fruit.put(x, fruit.getOrDefault(x, 0) + 1);
        }
        System.out.println(fruit);


        //задача про тел книгу

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "1111111");
        phoneBook.add("Ivanov", "22222222");
        phoneBook.add("Ivanov", "33333333");
        phoneBook.add("Petrov", "444444444");
        phoneBook.add("Petrov", "5555555555");
        phoneBook.add("Sidorov", "666666666");

        phoneBook.get("Ivanov");
        phoneBook.get("Petrov");
        phoneBook.get("Sidorov");
    }


}
