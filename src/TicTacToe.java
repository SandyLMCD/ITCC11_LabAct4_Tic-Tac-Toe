import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends Frame {
    private String player1Name;
    private String player2Name;

    private Label turnLabel;
    private boolean player1Turn = true;
    private Button[][] board = new Button[3][3];

    public TicTacToe(String p1, String p2) {
        this.player1Name = p1;
        this.player2Name = p2;

        setTitle("Tic Tac Toe");
        setSize(600, 600);
        setLayout(null);
        setBackground(Color.decode("#f9f9f9"));

        setupUI();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void setupUI() {
        // Start New Game Button
        Button startButton = new Button("Start New Game");
        startButton.setBounds(220, 50, 160, 40);
        startButton.setBackground(Color.decode("#fcd75c"));
        startButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        startButton.addActionListener(e -> resetBoard());
        add(startButton);

        // Player 1 Panel
        Panel player1Panel = new Panel(new GridLayout(2, 1));
        player1Panel.setBounds(50, 200, 100, 80);
        player1Panel.setBackground(Color.decode("#ffeef0"));
        player1Panel.add(new Label(player1Name, Label.CENTER));
        player1Panel.add(new Label("X", Label.CENTER));
        add(player1Panel);

        // Player 2 Panel
        Panel player2Panel = new Panel(new GridLayout(2, 1));
        player2Panel.setBounds(450, 200, 100, 80);
        player2Panel.setBackground(Color.decode("#ffeef0"));
        player2Panel.add(new Label(player2Name, Label.CENTER));
        player2Panel.add(new Label("O", Label.CENTER));
        add(player2Panel);

        // Game Grid
        Panel gridPanel = new Panel(new GridLayout(3, 3));
        gridPanel.setBounds(180, 150, 220, 220);
        gridPanel.setBackground(Color.decode("#f44336"));
        add(gridPanel);

        Font cellFont = new Font("SansSerif", Font.BOLD, 36);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = new Button("");
                board[row][col].setFont(cellFont);
                board[row][col].setBackground(Color.white);
                final int r = row, c = col;
                board[row][col].addActionListener(e -> handleMove(r, c));
                gridPanel.add(board[row][col]);
            }
        }

        // Turn Indicator
        turnLabel = new Label(player1Name + "'s turn", Label.CENTER);
        turnLabel.setBounds(200, 400, 200, 30);
        turnLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        turnLabel.setBackground(Color.decode("#fcd75c"));
        add(turnLabel);
    }

    private void handleMove(int row, int col) {
        Button btn = board[row][col];
        if (!btn.getLabel().equals(""))
            return;

        String currentPlayer = player1Turn ? player1Name : player2Name;
        String symbol = player1Turn ? "X" : "O";

        btn.setLabel(symbol);

        if (checkWinner(symbol)) {
            showWinnerScreen(currentPlayer);
        } else {
            player1Turn = !player1Turn;
            turnLabel.setText((player1Turn ? player1Name : player2Name) + "'s turn");
        }
    }

    private boolean checkWinner(String symbol) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getLabel().equals(symbol) &&
                    board[i][1].getLabel().equals(symbol) &&
                    board[i][2].getLabel().equals(symbol))
                return true;

            if (board[0][i].getLabel().equals(symbol) &&
                    board[1][i].getLabel().equals(symbol) &&
                    board[2][i].getLabel().equals(symbol))
                return true;
        }

        return (board[0][0].getLabel().equals(symbol) &&
                board[1][1].getLabel().equals(symbol) &&
                board[2][2].getLabel().equals(symbol)) ||
                (board[0][2].getLabel().equals(symbol) &&
                        board[1][1].getLabel().equals(symbol) &&
                        board[2][0].getLabel().equals(symbol));
    }

    private void resetBoard() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                board[row][col].setLabel("");

        player1Turn = true;
        turnLabel.setText(player1Name + "'s turn");
    }

    private void showWinnerScreen(String winner) {
        Frame winFrame = new Frame("Game Over");
        winFrame.setSize(400, 300);
        winFrame.setLayout(null);
        winFrame.setBackground(Color.white);

        Label winMessage = new Label(winner + " Wins the Game!", Label.CENTER);
        winMessage.setBounds(50, 80, 300, 50);
        winMessage.setFont(new Font("SansSerif", Font.BOLD, 20));
        winFrame.add(winMessage);
        dispose();

        Button newGame = new Button("Start New Game");
        newGame.setBounds(120, 150, 160, 30);
        newGame.setBackground(Color.decode("#fcebd5"));
        newGame.setFocusable(false);
        newGame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        newGame.addActionListener(e -> {
            winFrame.dispose();
            resetBoard();
        });
        winFrame.add(newGame);

        Button mainMenu = new Button("Back to Main Menu");
        mainMenu.setBounds(120, 190, 160, 30);
        mainMenu.setBackground(Color.decode("#fcebd5"));
        mainMenu.setFocusable(false);
        mainMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mainMenu.addActionListener(e -> {
            winFrame.dispose();
            this.dispose();
            new MainMenu(); // Assuming your main menu class is called MainMenu
        });
        winFrame.add(mainMenu);

        winFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new TicTacToe("Alice", "Bob");
    }
}
