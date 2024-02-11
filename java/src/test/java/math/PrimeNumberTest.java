package math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.TimeUtils;

class PrimeNumberTest {
    private static final Logger logger = LoggerFactory.getLogger(PrimeNumberTest.class);
    PrimeNumber primeNumber = new PrimeNumber();

    @Test
    void countPrimeNumber() {
        int n = 10;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (primeNumber.isPrime(i)) {
                count++;
                logger.info("{} is prime number", i);
            }
        }
        Assertions.assertEquals(4, count);
    }

    @Test
    void testPrimeNumberSearchSpeed() {
        long executionTimeInMillis = TimeUtils.measureExecutionTimeInMillis(new Runnable() {
            @Override
            public void run() {
                int n = 5000000;
                int currentPrimeNumber = 2;
                for (int i = 1; i < n; i++) {
                    if (primeNumber.isPrime(i)) {
                        if (currentPrimeNumber < i) currentPrimeNumber = i;
                    }
                }
                logger.info("max prime number: {}", currentPrimeNumber);
            }
        });
        logger.info("execution time: {}ms", executionTimeInMillis);
    }
}