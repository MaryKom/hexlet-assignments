package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers){
        Map<String, Integer> result = new HashMap<>();
        MaxThread maxthread = new MaxThread(numbers);
        MinThread minthread = new MinThread(numbers);

        maxthread.start();
        minthread.start();

        try {
            maxthread.join();
            LOGGER.log(Level.INFO, "Thread " + maxthread.getName() + " stopped");

            minthread.join();
            LOGGER.log(Level.INFO, "Thread " + minthread.getName() + " stopped");
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }

        result.put("max", maxthread.getMaxNumber());
        result.put("min", minthread.getMinNumber());
        return result;
    }
    // END
}
