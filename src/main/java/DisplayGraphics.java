import javax.swing.*;
import java.awt.*;

public class DisplayGraphics extends Canvas {

    private PrimeNumberSpiral.CellData[][] board;

    public DisplayGraphics(PrimeNumberSpiral.CellData[][] board) {
        this.board = board;
    }

    public void paint(Graphics g) {
//        g.drawString("Hello",40,40);
//        setBackground(Color.WHITE);
//        g.fillRect(130, 30,100, 80);
//        g.drawOval(30,130,50, 60);
//        setForeground(Color.RED);
//        g.fillOval(130,130,50, 60);
//        g.drawArc(30, 200, 40,50,90,60);
//        g.fillArc(30, 130, 40,50,180,40);

        setBackground(Color.WHITE);
        setForeground(Color.GREEN);
        int side = 1;
        for (PrimeNumberSpiral.CellData[] row : board) {
            for (PrimeNumberSpiral.CellData cell : row) {
                if (cell.prime){
                    g.fillRect(cell.x * side, cell.y * side, side, side);
                }
            }
        }

    }
}