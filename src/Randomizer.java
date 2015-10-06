import java.util.Random;

public class Randomizer {

    public int numberGenerator(int max) {
        Random randomGenerator  = new Random();
        int value = randomGenerator.nextInt(max);
        return value;
    }




}
