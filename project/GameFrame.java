import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameFrame extends JFrame implements ActionListener {
    private JMenuBar menuBar = new JMenuBar();

    private JMenu gameMenu = new JMenu("Game");
    private JMenu editMenu = new JMenu("Edit");

    private JMenuItem newGame = new JMenuItem("New Game");
    private JCheckBoxMenuItem singleGameMenuItem = new JCheckBoxMenuItem("Single Game", true);
    
    private GamePanel activeGamePanel;

    public GameFrame() {
        this.setLayout(new BorderLayout());

        activeGamePanel = new GamePanel(singleGameMenuItem.isSelected());
        this.add(activeGamePanel);

        newGame.addActionListener(this);
        singleGameMenuItem.addActionListener(this);

        gameMenu.add(newGame);
        editMenu.add(singleGameMenuItem);

        menuBar.add(gameMenu);
        menuBar.add(editMenu);

        this.setJMenuBar(menuBar);

        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame) {
            System.out.println("new game created");
            this.getContentPane().removeAll();
            this.activeGamePanel = new GamePanel(singleGameMenuItem.isSelected());
            this.add(activeGamePanel);
            this.getContentPane().revalidate();
            this.pack();
        }
    }

}
