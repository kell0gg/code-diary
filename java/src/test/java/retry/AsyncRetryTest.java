package retry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

class AsyncRetryTest {
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    private static final AtomicInteger atomicInteger = new AtomicInteger(0);
    private static final AtomicInteger retryAtomicInteger = new AtomicInteger(0);
    AsyncRetry asyncRetry = new AsyncRetry();

    @Test
    void defaultRetryTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> result = asyncRetry.retry(2, 1000, new Supplier<CompletableFuture<String>>() {
            @Override
            public CompletableFuture<String> get() {
                return defaultAsyncOperation();
            }
        });
        Assertions.assertEquals(SUCCESS, result.get());
    }

    @Test
    void decoratorRetryTest() throws ExecutionException, InterruptedException {
        // max attempts 까지 retry 실패, ExecutionException 가 발생
        CompletableFuture<String> result1 = asyncRetry.decoratorRetry(9, 1000, () -> defaultOperation());
        Assertions.assertThrows(ExecutionException.class, () -> result1.get());
        
        CompletableFuture<String> result2 = asyncRetry.decoratorRetry(10, 1000, () -> defaultOperation());
        Assertions.assertEquals(SUCCESS, result2.get());
    }

    private static String defaultOperation() {
        if (retryAtomicInteger.incrementAndGet() != 10) {
            throw new RuntimeException(FAILURE);
        }
        return SUCCESS;
    }

    private static CompletableFuture<String> defaultAsyncOperation() {
        CompletableFuture<String> future = new CompletableFuture<>();
        if (atomicInteger.incrementAndGet() % 2 == 0) {
            future.complete(SUCCESS);
        } else {
            future.completeExceptionally(new RuntimeException(FAILURE));
        }
        return future;
    }
}