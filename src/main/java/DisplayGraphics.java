import javax.swing.*;
import java.awt.*;

public class DisplayGraphics extends Canvas {

    private PrimeNumberSpiral.CellData[][] board;
    private int side;

    public DisplayGraphics(PrimeNumberSpiral.CellData[][] board, int side) {
        this.board = board;
        this.side = side;
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

//        setBackground(Color.WHITE);
//        setForeground(Color.GREEN);
        drawPrimeConnectingLines(g);
        drawPrimeSquares(g);
        drawPrimeNumbers(g);
    }

    private void drawPrimeConnectingLines(Graphics g) {
        g.setColor(Color.BLUE);
        for (PrimeNumberSpiral.CellData[] row : board) {
            for (PrimeNumberSpiral.CellData cell : row) {
                if (cell.direction == 0){
                    g.drawLine(cell.x * side + side / 2, cell.y * side + side / 2, (cell.x + 1) * side + side / 2, cell.y * side + side / 2);
                } else if (cell.direction == 90){
                    g.drawLine(cell.x * side + side / 2, cell.y * side + side / 2, cell.x * side + side / 2, (cell.y - 1) * side + side / 2);
                } else if (cell.direction == 180){
                    g.drawLine(cell.x * side + side / 2, cell.y * side + side / 2, (cell.x - 1) * side + side / 2, cell.y * side + side / 2);
                } else{
                    g.drawLine(cell.x * side + side / 2, cell.y * side + side / 2, cell.x * side + side / 2, (cell.y + 1) * side + side / 2);
                }
            }
        }
    }

    private void drawPrimeNumbers(Graphics g) {
        g.setColor(Color.BLACK);
        FontMetrics metrics = g.getFontMetrics();
        for (PrimeNumberSpiral.CellData[] row : board) {
            for (PrimeNumberSpiral.CellData cell : row) {
                g.drawString(cell.stringValue,
                        cell.x * side + (side - metrics.stringWidth(cell.stringValue)) / 2,
                        cell.y * side + (side - metrics.getHeight()) / 2 + metrics.getAscent());
            }
        }
    }

    private void drawPrimeSquares(Graphics g) {
        g.setColor(Color.GREEN);
        for (PrimeNumberSpiral.CellData[] row : board) {
            for (PrimeNumberSpiral.CellData cell : row) {
                if (cell.prime){
                    g.fillRect(cell.x * side, cell.y * side, side, side);
                }
            }
        }
    }
}