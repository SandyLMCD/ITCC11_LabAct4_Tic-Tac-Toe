import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener {
    private Button startButton;
    private Label title;

    public MainMenu() {
        setTitle("Tic Tac Toe");
        setSize(500, 400);
        setLayout(null);
        setBackground(Color.decode("#fffaf9"));

        Panel backgroundPanel = new Panel();
        backgroundPanel.setBounds(0, 0, 500, 400);
        backgroundPanel.setBackground(Color.decode("#fffaf9"));
        backgroundPanel.setLayout(null); // match layout
        add(backgroundPanel);

        title = new Label("Tic Tac Toe", Label.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 36));
        title.setBounds(100, 100, 300, 50);
        title.setForeground(Color.decode("#F34854"));
        backgroundPanel.add(title);

        startButton = new Button("Start Game");
        Color normalColor = Color.decode("#ffe4cc");
        Color hoverColor = Color.decode("#ffdab3");
        startButton.setBounds(150, 200, 200, 50);
        startButton.setBackground(Color.decode("#ffe4cc"));
        startButton.setForeground(Color.decode("#9c541c"));
        startButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        startButton.addActionListener(this);
        startButton.setFocusable(false);
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        startButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                startButton.setBackground(hoverColor);
            }

            public void mouseExited(MouseEvent e) {
                startButton.setBackground(normalColor);
            }
        });

        backgroundPanel.add(startButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            // Start the game
            new TicTacToeGame();
            dispose(); // Close the main menu
        }
    }

    public static void main(String[] args) {
        new MainMenu();
    }

}
