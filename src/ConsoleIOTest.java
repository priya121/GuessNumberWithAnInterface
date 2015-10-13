import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class ConsoleIOTest {

    @Test
    public void displaysInitialPrompt() {
        ByteArrayOutputStream recordedOutput = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(recordedOutput);
        InputStream inputStream = new ByteArrayInputStream("2\n".getBytes());
        ConsoleIO console = new ConsoleIO(inputStream, out);
        console.initialPrompt();
        assertEquals("Please enter a number from 1 - 100: ", recordedOutput.toString());
    }

    @Test
    public void getsUserInput() {
        InputStream inputStream = new ByteArrayInputStream("2\n".getBytes());
        ConsoleIO console = new ConsoleIO(inputStream, null);
        assertEquals(2, console.getInput());
    }
    
    @Test
    public void showsWrongGuess() {
        ByteArrayOutputStream recordedOutput = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(recordedOutput);
        ConsoleIO console = new ConsoleIO(null, out);
        int guess = 2;
        console.showUserWrongGuess(guess);
        assertEquals("Your guess 2 is wrong.", recordedOutput.toString());
    }

    @Test
    public void showsCorrectGuessEndsGame() {
        ByteArrayOutputStream recordedOutput = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(recordedOutput);
        InputStream inputStream = new ByteArrayInputStream("2\n".getBytes());
        ConsoleIO console = new ConsoleIO(inputStream, out);
        int guess = 2;
        console.showUserCorrectGuess(guess);
        assertEquals("Your guess 2 is the correct number! You win!", recordedOutput.toString());
    }
}