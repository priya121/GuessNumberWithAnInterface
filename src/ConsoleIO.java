import java.io.*;

public class ConsoleIO implements IoInterface {
    private final PrintStream outputChannel;
    private final BufferedReader inputChannel;

    public ConsoleIO(InputStream inputChannel, PrintStream outputChannel) {
        this.inputChannel = new BufferedReader(new InputStreamReader(inputChannel));
        this.outputChannel = outputChannel;
    }

    @Override
    public int getInput() {
        try {
            return Integer.parseInt(inputChannel.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String initialPrompt() {
        outputChannel.println("Please enter a number from 1 - 100: ");
        return null;
    }

    @Override
    public String showUserWrongGuess(int guess) {
        outputChannel.println("Your guess " + guess + " is wrong.");
        return null;
    }

    @Override
    public String showUserCorrectGuess(int guess) {
        outputChannel.println("Your guess " + guess + " is the correct answer! You win!");
        return null;
    }
}
