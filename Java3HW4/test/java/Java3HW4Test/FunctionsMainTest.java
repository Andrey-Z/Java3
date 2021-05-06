package Java3HW4Test;

import Java3Lesson4.Functions;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static

public class FunctionsMainTest {
    Functions functions = new Functions();
    private static Logger logger = LoggerFactory.getLogger(FunctionsMainTest.class);

    @Test
    @DisplayName("Проверить, является ли testIsNumberPositive положительным числом")
    void testIsNumberPositive() {
        logger.debug("Проверка, является ли число положительным");
        assertTrue(functions.isNumberPositive(3));
    }
    @Test
    @DisplayName("Проверить функцию testIsNumberNegative с отрицательным числом")
        void ifNumberIsNegative (){
        logger.debug("Проверка функции с отрицательным числом");
        assertFalse(functions.isPrime(-1));
    }
    @Test
    void trueAssumtion(){
        assumeTrue(1==2);
        assertEquals(1,1);
    }
}
