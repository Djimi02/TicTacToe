import java.awt.Color;

import javax.swing.JButton;

public class TicTacToeModel {

    protected int numberOfFilled = 0;
    protected boolean player1Turn = true;

    protected JButton[] buttons;

    public TicTacToeModel(JButton[] buttons) {
        this.buttons = buttons;
    }

    // Checks if there is a row, column or diagonal with the same symbol
    // Currently it only checks if the symbols are equal, but not which symbol it is
    public boolean isGameFinished() {
        boolean out = false;
        if (buttons[0].getText().equals(buttons[1].getText()) && buttons[1].getText().equals(buttons[2].getText())
                && buttons[0].getText().equals("X")) {
            System.out.println("The game has ended! X wins!");
            out = true;
            buttons[0].setBackground(Color.red);
            buttons[1].setBackground(Color.red);
            buttons[2].setBackground(Color.red);
        } else if (buttons[0].getText().equals(buttons[3].getText())
                && buttons[3].getText().equals(buttons[6].getText()) && buttons[0].getText().equals("X")) {
            System.out.println("The game has ended! X wins!");
            out = true;
            buttons[0].setBackground(Color.red);
            buttons[3].setBackground(Color.red);
            buttons[6].setBackground(Color.red);
        } else if (buttons[3].getText().equals(buttons[4].getText())
                && buttons[4].getText().equals(buttons[5].getText()) && buttons[3].getText().equals("X")) {
            System.out.println("The game has ended! X wins!");
            out = true;
            buttons[3].setBackground(Color.red);
            buttons[4].setBackground(Color.red);
            buttons[5].setBackground(Color.red);
        } else if (buttons[6].getText().equals(buttons[7].getText())
                && buttons[7].getText().equals(buttons[8].getText()) && buttons[6].getText().equals("X")) {
            System.out.println("The game has ended! X wins!");
            out = true;
            buttons[6].setBackground(Color.red);
            buttons[7].setBackground(Color.red);
            buttons[8].setBackground(Color.red);
        } else if (buttons[1].getText().equals(buttons[4].getText())
                && buttons[4].getText().equals(buttons[7].getText()) && buttons[1].getText().equals("X")) {
            System.out.println("The game has ended! X wins!");
            out = true;
            buttons[1].setBackground(Color.red);
            buttons[4].setBackground(Color.red);
            buttons[7].setBackground(Color.red);
        } else if (buttons[2].getText().equals(buttons[5].getText())
                && buttons[5].getText().equals(buttons[8].getText()) && buttons[2].getText().equals("X")) {
            System.out.println("The game has ended! X wins!");
            out = true;
            buttons[2].setBackground(Color.red);
            buttons[5].setBackground(Color.red);
            buttons[8].setBackground(Color.red);
        } else if (buttons[0].getText().equals(buttons[4].getText())
                && buttons[4].getText().equals(buttons[8].getText()) && buttons[0].getText().equals("X")) {
            System.out.println("The game has ended! X wins!");
            out = true;
            buttons[0].setBackground(Color.red);
            buttons[4].setBackground(Color.red);
            buttons[8].setBackground(Color.red);
        } else if (buttons[2].getText().equals(buttons[4].getText())
                && buttons[4].getText().equals(buttons[6].getText()) && buttons[2].getText().equals("X")) {
            System.out.println("The game has ended! X wins!");
            out = true;
            buttons[2].setBackground(Color.red);
            buttons[4].setBackground(Color.red);
            buttons[6].setBackground(Color.red);
        } else if (buttons[0].getText().equals(buttons[1].getText())
                && buttons[1].getText().equals(buttons[2].getText()) && buttons[0].getText().equals("O")) {
            System.out.println("The game has ended! O wins!");
            out = true;
            buttons[0].setBackground(Color.red);
            buttons[1].setBackground(Color.red);
            buttons[2].setBackground(Color.red);
        } else if (buttons[0].getText().equals(buttons[3].getText())
                && buttons[3].getText().equals(buttons[6].getText()) && buttons[0].getText().equals("O")) {
            System.out.println("The game has ended! O wins!");
            out = true;
            buttons[0].setBackground(Color.red);
            buttons[3].setBackground(Color.red);
            buttons[6].setBackground(Color.red);
        } else if (buttons[3].getText().equals(buttons[4].getText())
                && buttons[4].getText().equals(buttons[5].getText()) && buttons[3].getText().equals("O")) {
            System.out.println("The game has ended! O wins!");
            out = true;
            buttons[3].setBackground(Color.red);
            buttons[4].setBackground(Color.red);
            buttons[5].setBackground(Color.red);
        } else if (buttons[6].getText().equals(buttons[7].getText())
                && buttons[7].getText().equals(buttons[8].getText()) && buttons[6].getText().equals("O")) {
            System.out.println("The game has ended! O wins!");
            out = true;
            buttons[6].setBackground(Color.red);
            buttons[7].setBackground(Color.red);
            buttons[8].setBackground(Color.red);
        } else if (buttons[1].getText().equals(buttons[4].getText())
                && buttons[4].getText().equals(buttons[7].getText()) && buttons[1].getText().equals("O")) {
            System.out.println("The game has ended! O wins!");
            out = true;
            buttons[1].setBackground(Color.red);
            buttons[4].setBackground(Color.red);
            buttons[7].setBackground(Color.red);
        } else if (buttons[2].getText().equals(buttons[5].getText())
                && buttons[5].getText().equals(buttons[8].getText()) && buttons[2].getText().equals("O")) {
            System.out.println("The game has ended! O wins!");
            out = true;
            buttons[2].setBackground(Color.red);
            buttons[5].setBackground(Color.red);
            buttons[8].setBackground(Color.red);
        } else if (buttons[0].getText().equals(buttons[4].getText())
                && buttons[4].getText().equals(buttons[8].getText()) && buttons[0].getText().equals("O")) {
            System.out.println("The game has ended! O wins!");
            out = true;
            buttons[0].setBackground(Color.red);
            buttons[4].setBackground(Color.red);
            buttons[8].setBackground(Color.red);
        } else if (buttons[2].getText().equals(buttons[4].getText())
                && buttons[4].getText().equals(buttons[6].getText()) && buttons[2].getText().equals("O")) {
            System.out.println("The game has ended! O wins!");
            out = true;
            buttons[2].setBackground(Color.red);
            buttons[4].setBackground(Color.red);
            buttons[6].setBackground(Color.red);
        } else if (numberOfFilled == 9) {
            System.out.println("Draw!");
            out = true;
            for (JButton jButton : buttons) {
                jButton.setBackground(Color.orange);
            }
        }

        return out;
    }

    public void insert(JButton button) {
        String symbol;
        if (player1Turn) {
            symbol = "X";
        } else {
            symbol = "O";
        }
        player1Turn = !player1Turn;

        button.setText(symbol);
        button.setEnabled(false);

        this.numberOfFilled++;
    }

}
