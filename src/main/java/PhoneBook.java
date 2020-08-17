import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    private HashMap<String, ArrayList<String>> contacts = new HashMap<>();

    public void add(String lastName, String phoneNumber) {

        ArrayList<String> phones = contacts.get(lastName);

        if (phones != null) {
            phones.add(phoneNumber);
        } else {
            phones = new ArrayList<>();
            phones.add(phoneNumber);
            contacts.put(lastName, phones);
        }
    }

    public void get(String lastName) {

        System.out.println(lastName + " " + contacts.get(lastName));

    }
}
