package repositories;


import java.util.List;
import java.util.Random;

public class GenerationId implements Generation{

    public static int generateId(List customerList) {
        Random random = new Random();
        int enter;

        do enter = (random.nextInt(1000) + 100000);
        while (customerList.contains(enter));

        customerList.add(enter);
        return enter;
    }
}
