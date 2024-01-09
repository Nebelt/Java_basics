import java.nio.charset.IllegalCharsetNameException;
import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws WrongNameException {
        checkCustomer(data);
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }

    public void checkCustomer(String data) throws WrongNameException {


        if (data.isBlank()) {
            throw new ArrayIndexOutOfBoundsException("Пустая команда ADD");
        }

        if (data.split("\\s+").length != 4) {
            throw new ArrayIndexOutOfBoundsException("Неверное количество переменных на вход");
        }
        String[] components = data.split("\\s+");

        String regexName = "[а-яА-Я]+";
        if (!components[0].matches(regexName)) {
            throw new WrongNameException("Неверное имя");
        }
        if (!components[1].matches(regexName)) {
            throw new WrongNameException("Неверная фамилия");
        }

        components[2] = components[2].toLowerCase();
        String regexMail = "[a-z]+.?[a-z]*@[a-z]+.[a-z]+";
        if (!components[2].matches(regexMail)) {
            throw new IllegalCharsetNameException("Неверный e-mail " + components[2]);
        }

        String regexPhone = "\\+79[0-9]{9}";
        if (!components[3].matches(regexPhone)) {
            throw new IllegalCharsetNameException("Неверный телефон " + components[3]);
        }

    }
}


class WrongNameException extends Exception {

    public WrongNameException(String message) {
        super(message);
    }
}