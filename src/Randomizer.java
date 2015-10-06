import java.util.Random;

public class Randomizer {

    public int numberGenerator(int max) {
        Random randomGenerator  = new Random();
        return randomGenerator.nextInt(max);
    }
}
