import javax.swing.*;
import java.awt.*;

public class Tetris extends JFrame {

    private final int BOARD_WIDTH = 10;
    private final int BOARD_HEIGHT = 20;
    private final int DELAY = 300;

    private Timer timer;
    private boolean isFallingFinished = false;
    private boolean isPaused = false;
    private int currentX = 0;
    private int currentY = 0;

    private JLabel statusBar;

    public Tetris() {
        initUI();
    }

    private void initUI() {
        statusBar = new JLabel(" 0");
        add(statusBar, BorderLayout.SOUTH);

        Board board = new Board(this);
        add(board);
        board.start();

        setTitle("Tetris");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public int getBoardWidth() {
        return BOARD_WIDTH;
    }

    public int getBoardHeight() {
        return BOARD_HEIGHT;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public boolean isFallingFinished() {
        return isFallingFinished;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public void setFallingFinished(boolean fallingFinished) {
        isFallingFinished = fallingFinished;
    }

    public JLabel getStatusBar() {
        return statusBar;
    }

    public void start() {
        timer = new Timer(DELAY, event -> {
            if (isFallingFinished) {
                isFallingFinished = false;
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Tetris game = new Tetris();
            game.setVisible(true);
        });
    }
}
