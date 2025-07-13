package example.utils;


public class MyUtils {

    private MyUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }


    public static void silentlySleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
    }

}
