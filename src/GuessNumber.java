public class GuessNumber {

    private ioInterface io;
    private int myNumber;
    private boolean isOver;
    String userPrompt;
    private int tries;

    public GuessNumber(ioInterface io, int myNumber) {
        this.io = io;
        this.myNumber = 2;
        this.isOver = false;
        this.userPrompt = "";
        this.tries = 0;
    }

    public int getUserInput() {
        return io.getInput();
    }

    public boolean numberMatch(int usersGuess) {
        if (usersGuess == myNumber || tries == 6) {
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
}
