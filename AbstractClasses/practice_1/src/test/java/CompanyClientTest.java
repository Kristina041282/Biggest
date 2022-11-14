import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyClientTest {

    private static final double DELTA = 0.001;
    private static final String notExpectedSumMessage = "Сумма на счете не соответствует ожидаемой";
    
    private CompanyClient companyClient;

    @BeforeEach
    public void setUp() {
        companyClient = new CompanyClient();
    }

    @Test
    @DisplayName("Метод put")
    void put() {
        companyClient.put(1.0);
        assertEquals(1.0, companyClient.getAmount(), DELTA, notExpectedSumMessage);
    }

    @Test
    @DisplayName("Метод put, попытка вызвать метод с отрицательной суммой (баланс не должен измениться)")
    void putNegativeAmount() {
        companyClient.put(-1.0);
        assertEquals(0.0, companyClient.getAmount(), DELTA, notExpectedSumMessage);
    }

    @Test
    @DisplayName("Метод take")
    void take() {
        companyClient.put(2.0);
        companyClient.take(1.0);
        assertEquals(0.99, companyClient.getAmount(), DELTA, notExpectedSumMessage);
    }

    @Test
    @DisplayName("Метод take, попытка снять со счета денег больше, чем на счете имеется")
    void takeTooMuchMoney() {
        companyClient.put(1.0);
        companyClient.take(3.0);
        assertEquals(1.0, companyClient.getAmount(), DELTA, notExpectedSumMessage);
    }
}