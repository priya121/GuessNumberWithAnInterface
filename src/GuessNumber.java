public class GuessNumber {

    private static IoInterface io;
    private int myNumber;
    private boolean isOver;
    String userPrompt;
    String greeting;
    private int tries;

    public GuessNumber(IoInterface io, int myNumber) {
        this.io = io;
        this.myNumber = myNumber;
        this.isOver = false;
        this.userPrompt = "";
        this.tries = 0;
    }

    public static void main(String args[]) {
        IoInterface io = new ConsoleIO(System.in, System.out);
        GuessNumber newGame = new GuessNumber(io, new Randomizer().numberGenerator(101));
        newGame.initialGreeting();
        newGame.gameLoop(io.getInput());
    }

    public int getUserInput() {
        return io.getInput();
    }

    public boolean numberMatch(int usersGuess) {
        if (usersGuess == myNumber || tries == 5) {
            io.showUserCorrectGuess(usersGuess);
            return isOver = true;
        } else {
            gameLoop(usersGuess);
            return isOver;
        }
    }

    public boolean gameLoop(int usersGuess) {
        do {
            showUserWrongGuess(usersGuess);
            tries += 1;
            numberMatch(getUserInput());
            return isOver;
        }
        while (usersGuess != myNumber);
    }

    public boolean isOver() {
        return isOver;
    }

    public String showUserWrongGuess(int guess) {
        userPrompt = io.showUserWrongGuess(guess);
        return userPrompt;
    }

    public String showUserCorrectGuess(int guess) {
        userPrompt = io.showUserCorrectGuess(guess);
        return userPrompt;
    }

    public String initialGreeting() {
        greeting = io.initialPrompt();
        return greeting;
    }
}
