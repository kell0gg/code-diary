package util;

public class TimeUtils {
    public static long measureExecutionTimeInMillis(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
