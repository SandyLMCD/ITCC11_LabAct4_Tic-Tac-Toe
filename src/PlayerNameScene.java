import java.awt.*;
import java.awt.event.*;

public class PlayerNameScene extends Frame {

    private TextField player1Input;
    private TextField player2Input;
    private String player1Name = "Player 1";
    private String player2Name = "Player 2";

    public PlayerNameScene() {
        setTitle("Enter Player Names");
        setSize(500, 400);
        setLayout(null);
        setBackground(Color.decode("#fffaf9")); // Background matches homepage

        // Title
        Label title = new Label("Enter player names", Label.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setBounds(100, 50, 300, 40);
        add(title);

        // Player 1 Label and Input
        Label p1Label = new Label("Player 1", Label.CENTER);
        p1Label.setFont(new Font("SansSerif", Font.PLAIN, 18));
        p1Label.setBounds(100, 120, 120, 30);
        add(p1Label);

        player1Input = new TextField();
        player1Input.setBounds(100, 160, 120, 30);
        player1Input.setBackground(Color.decode("#ffe4cc"));
        add(player1Input);

        // Player 2 Label and Input
        Label p2Label = new Label("Player 2", Label.CENTER);
        p2Label.setFont(new Font("SansSerif", Font.PLAIN, 18));
        p2Label.setBounds(280, 120, 120, 30);
        add(p2Label);

        player2Input = new TextField();
        player2Input.setBounds(280, 160, 120, 30);
        player2Input.setBackground(Color.decode("#ffe4cc"));
        add(player2Input);

        // Play Button
        Button playButton = new Button("Play");
        playButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        playButton.setBounds(200, 240, 100, 40);
        playButton.setBackground(Color.decode("#ffdab3"));
        playButton.setFocusable(false);
        playButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(playButton);

        playButton.addActionListener(e -> {
            player1Name = player1Input.getText().trim().isEmpty() ? "Player 1" : player1Input.getText().trim();
            player2Name = player2Input.getText().trim().isEmpty() ? "Player 2" : player2Input.getText().trim();
            launchGame();
        });

        // Window close
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void launchGame() {
        // You can pass player1Name and player2Name into the game
        new TicTacToe(player1Name, player2Name);
        dispose(); // Close this window
    }

    public static void main(String[] args) {
        new PlayerNameScene();
    }
}
