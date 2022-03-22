import java.util.*;

public class TicTacToeRunner {

    public static final String OPTION_O = "O";
    public static final String OPTION_X = "X";
    public static boolean X_IS_PLAYING = true;

    private final Map<String, List<String>> board;

    private final Scanner scanner;

    public TicTacToeRunner() {
        this.board = new HashMap<>();

        this.board.put("A", Arrays.asList(" "," "," "));
        this.board.put("B", Arrays.asList(" "," "," "));
        this.board.put("C", Arrays.asList(" "," "," "));

        this.scanner = new Scanner(System.in);
    }

    public void start() {

        this.drawBoard();
        boolean gameFinished = false;
        while(!gameFinished) {
            String lineIdentifier = this.scanner.next();
            int columnIdentifier = this.scanner.nextInt();

            try {
                List<String> line = this.board.get(lineIdentifier.toUpperCase());

                if (!this.checkFieldIsEmpty(line.get(columnIdentifier - 1))) {
                    continue;
                }

                line.set(columnIdentifier - 1, X_IS_PLAYING ? OPTION_X : OPTION_O);

                X_IS_PLAYING = !X_IS_PLAYING;

                this.drawBoard();

            } catch (NullPointerException ex) {
                System.out.println("That position doesn't exist");
                continue;
            }
        }
    }
    public boolean checkFieldIsEmpty(String field) {
        if (!field.equals(" ")) {
            System.out.println("Cheater! Try Again!");
            return false;
        }

        return true;
    }
    public void drawBoard() {
        this.board.forEach((lineIdentifier, line) -> drawLine(line));
    }

    public void drawLine(List<String> line) {
        System.out.println("|" + line.get(0) + " " + line.get(1) + " " + line.get(2) + "|");
    }
}
