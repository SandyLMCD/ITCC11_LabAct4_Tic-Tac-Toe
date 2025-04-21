import java.awt.*;
import java.awt.event.*;

public class TicTacToeGame extends Frame implements ActionListener {

    private Button[][] buttons = new Button[3][3];
    private boolean playerXTurn = true;
    private Label statusLabel;

    public TicTacToeGame() {
        setTitle("Tic Tac Toe");
        setSize(800, 400);
        setLayout(null);
        setBackground(Color.decode("#fffaf9"));

        Panel backgroundPanel = new Panel();
        backgroundPanel.setBounds(0, 0, 800, 400);
        backgroundPanel.setBackground(Color.decode("#fffaf9"));
        backgroundPanel.setLayout(null); // match layout
        add(backgroundPanel);
    }

}
