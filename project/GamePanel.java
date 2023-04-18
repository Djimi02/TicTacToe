import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;

    private JButton[] buttons = new JButton[9];

    private TicTacToeModel ticTacToeModel = new TicTacToeModel(buttons);

    private boolean gameModeSinglePlayer;

    private Random random;
    
    public GamePanel(boolean gameMode) {
        this.gameModeSinglePlayer = gameMode;

        this.random = new Random();

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.requestFocus();
        this.requestFocusInWindow();

        this.setLayout(new GridLayout(3, 3));

        // Init the grid of buttons
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            this.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ticTacToeModel.insert((JButton)(e.getSource()));

        if (ticTacToeModel.isGameFinished()) {
            for (Component component : this.getComponents()) {
                component.setEnabled(false);
            }
        } else if (gameModeSinglePlayer) { // in case it is single player
            // Simple code that marks random blocks
            while (true) {
                int num = random.nextInt(9);
                if (!buttons[num].isEnabled()) {
                    continue;
                }  
                ticTacToeModel.insert(buttons[num]);
                break;
            }
            if (ticTacToeModel.isGameFinished()) {
                for (Component component : this.getComponents()) {
                    component.setEnabled(false);
                }
            }
        }
    }
}
