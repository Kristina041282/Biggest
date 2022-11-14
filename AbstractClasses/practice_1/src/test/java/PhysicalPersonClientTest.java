import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhysicalPersonClientTest {

    private static final double DELTA = 0.01;
    private static final String notExpectedSumMessage = "Сумма на счете не соответствует ожидаемой";
    
    private PhysicalPersonClient physicalPersonClient;

    @BeforeEach
    public void setUp() {
        physicalPersonClient = new PhysicalPersonClient();
    }

    @Test
    @DisplayName("Метод put")
    void put() {
        physicalPersonClient.put(1.0);
        assertEquals(1.0, physicalPersonClient.getAmount(), DELTA, notExpectedSumMessage);
    }

    @Test
    @DisplayName("Метод put, попытка вызвать метод с отрицательной суммой (баланс не должен измениться)")
    void putNegativeAmount() {
        physicalPersonClient.put(-1.0);
        assertEquals(0.0, physicalPersonClient.getAmount(), DELTA, notExpectedSumMessage);
    }


    @Test
    @DisplayName("Метод take")
    void take() {
        physicalPersonClient.put(2.0);
        physicalPersonClient.take(1.0);
        assertEquals(1.0, physicalPersonClient.getAmount(), DELTA, notExpectedSumMessage);
    }

    @Test
    @DisplayName("Метод take, попытка снять со счета денег больше, чем на счете имеется")
    void takeTooMuchMoney() {
        physicalPersonClient.put(2.0);
        physicalPersonClient.take(3.0);
        assertEquals(2.0, physicalPersonClient.getAmount(), DELTA, notExpectedSumMessage);
    }
}