package math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.TimeUtils;

import static org.junit.jupiter.api.Assertions.*;

class GreatestCommonDivisorTest {
    GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();
    private static final Logger logger = LoggerFactory.getLogger(GreatestCommonDivisorTest.class);

    @Test
    void gcd() {
        long executionTimeInMillis1 = TimeUtils.measureExecutionTimeInMillis(() -> {
            long gcd = greatestCommonDivisor.gcd(433494437L, 701408733L);
            Assertions.assertEquals(1, gcd);
        });

        long executionTimeInMillis2 = TimeUtils.measureExecutionTimeInMillis(() -> {
            long gcd = greatestCommonDivisor.gcdWithEuclid(433494437L, 701408733L);
            Assertions.assertEquals(1, gcd);
        });

        logger.info("execution time: {}ms", executionTimeInMillis1);
        logger.info("execution time: {}ms", executionTimeInMillis2);

        Assertions.assertTrue(executionTimeInMillis1 > executionTimeInMillis2);
    }
}