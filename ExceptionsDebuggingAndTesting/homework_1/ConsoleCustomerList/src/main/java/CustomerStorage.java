import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private static Logger logger = LogManager.getLogger(CustomerStorage.class);
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        //logger.log(Level.WARN, "Сообщение об ошибке");
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        String regexPhone = "^(\\+7)([0-9]{10})";
        String regexEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        String[] components = data.split("\\s+");
        if(components.length != 4) {
            logger.error("Произошла ошибка, введите корректно данные:");
            throw new IndexOutOfBoundsException("Please write the correct format");
        }
        if (!components[INDEX_PHONE].matches(regexPhone)) {//если введен номер не корректно, то бросим исключение
            logger.error("Произошла ошибка, введите корректно номер:");
            throw new IllegalArgumentException("Please write the correct phone number");
        }
        if (!components[INDEX_EMAIL].matches(regexEmail)) {
            logger.error("Произошла ошибка, введите корректно email:");
            throw new IllegalArgumentException("Please write the correct email");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        logger.info("Запросили полный список:");
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        logger.info("Удаление сотрудника:");
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        logger.info("Просмотр имени сотрудника:");
        return storage.get(name);
    }

    public int getCount() {
        logger.info("Подсчет сотрудников:");
        return storage.size();
    }
}