import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class GuessNumberTest {

    @Test
    public void getUserInput() {
        FakeIO io = getFakeIO(asList(1));
        GuessNumber game = new GuessNumber(io, 2);
        assertEquals(1, game.getUserInput());
    }

    @Test
    public void numbersDontMatch() {
        FakeIO io = getFakeIO(asList(1));
        GuessNumber game = new GuessNumber(io, 2);
        assertFalse(game.isOver());
    }

    @Test
    public void numbersMatch() {
        FakeIO io = getFakeIO(asList(2));
        GuessNumber game = new GuessNumber(io, 2);
        assertTrue(game.numberMatch(io.getInput()));
    }

    @Test
    public void gameIsNotOver() {
        FakeIO io = getFakeIO(asList(1,2));
        GuessNumber game = new GuessNumber(io, 2);
        assertFalse(game.isOver());
    }

    @Test
    public void gameWonWithMultipleInputs() {
        FakeIO io = getFakeIO(asList(1,2,4,1,4,5,9));
        GuessNumber game = new GuessNumber(io, 2);
        game.numberMatch(io.getInput());
        assertTrue(game.isOver());
    }

    @Test
    public void gameWonAfterSixTries() {
        FakeIO io = getFakeIO(asList(1,3,4,8,1,9,7,9,7));
        GuessNumber game = new GuessNumber(io, 2);
        game.gameLoop(io.getInput());
        assertTrue(game.isOver());
    }
    
    @Test
    public void promptsUser() {
        FakeIO io = getFakeIO(asList(2));
        GuessNumber game = new GuessNumber(io, 2);
        assertEquals(io.showUserCorrectGuess(2), game.showUserCorrectGuess(io.getInput()));
    }

    @Test
    public void numbersMatchToRandom() {
        Randomizer randomizer = new Randomizer();

        int myNumber = randomizer.numberGenerator(3);
        FakeIO io = getFakeIO(asList(20, myNumber));
        System.out.println("number: " + myNumber);
        GuessNumber game = new GuessNumber(io, myNumber);
        assertTrue(game.numberMatch(io.getInput()));
    }

    private FakeIO getFakeIO(List<Integer> numbers) {
        return new FakeIO(numbers);
    }

    private class FakeIO implements IoInterface {
        private LinkedList<Integer> numbers;

        public FakeIO(List<Integer> numbers) {
            this.numbers = new LinkedList<>(numbers);
        }

        @Override
        public int getInput() {
            return numbers.pop();
        }

        @Override
        public String initialPrompt() {
            return "Hi! Enter a number from 0-10. You have six tries.";
        }

        @Override
        public String showUserWrongGuess(int guess) {
            return guess + " is the wrong guess, try again.";
        }

        @Override
        public String showUserCorrectGuess(int guess) {
           return "Match made! Your guess, " + guess + " is correct!";
        }
    }
}