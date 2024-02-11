package retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class AsyncRetry {
    private static final Logger logger = LoggerFactory.getLogger(AsyncRetry.class);
    private static final ScheduledExecutorService retryScheduler = Executors.newScheduledThreadPool(1);

    public <T> CompletableFuture<T> retry(int maxAttempts, long delay, Supplier<CompletableFuture<T>> operation) {
        CompletableFuture<T> future = new CompletableFuture<>();
        attemptOperation(future, maxAttempts, 0, delay, operation);
        return future;
    }

    private <T> void attemptOperation(CompletableFuture<T> future, int maxAttempts, int attempt, long delay, Supplier<CompletableFuture<T>> operation) {
        operation.get().thenAccept(result -> {
            future.complete(result);
        }).exceptionally(ex -> {
            if (attempt < maxAttempts - 1) {
                // 재시도 횟수 이전이면 retryScheduler 를 이용해서 일정시간 후 작업을 다시 수행함
                retryScheduler.schedule(new Runnable() {
                    @Override
                    public void run() {
                        logger.info("retry attempt {}, max attempts {}", attempt, maxAttempts);
                        attemptOperation(future, maxAttempts, attempt + 1, delay, operation);
                    }
                }, delay, TimeUnit.MILLISECONDS);
            } else {
                future.completeExceptionally(ex);
            }
            return null;
        });
    }
}