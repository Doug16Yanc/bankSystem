package repositories;

import java.util.Map;
import java.util.Random;

public class GenerationId implements Generation{

    public static int generateId(Map customerMap) {
        Random random = new Random();
        Long enter;

        do {
            enter = (long) (random.nextInt(1000) + 1000000);
        } while (customerMap.containsKey(enter));

        customerMap.put(enter, true);
        return Math.toIntExact(enter);
    }
}
