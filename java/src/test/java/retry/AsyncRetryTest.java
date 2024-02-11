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