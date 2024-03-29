import javax.swing.*;

public class PrimeNumberSpiral {
    public static void main(String[] args) {

        String[] connections = {">", "/\\", "<", "\\/"};

        int direction = 0;
        int num = 1;
        int side = 25;
        int w = side;
        int h = side;

        int x = Math.floorDiv(w, 2);
        int y = Math.floorDiv(h, 2);

        CellData[][] board = new CellData[h][w];

        int range = w * h;
        int startAt = 2;
        for (int i = startAt; num < range; i++) {
            for (int j = 0; j < Math.floorDiv(i, 2); j++) {
                board[y][x] = new CellData(x, y, num, Math.abs(direction % 360));
                x += (int) Math.cos(Math.toRadians(direction));
                y += (int) Math.sin(Math.toRadians(direction));
                num++;
            }
            direction -= 90;
        }

//        printBoard(board, false);
//        printBoardHighlightPrimes(board, false, ConsoleColors.GREEN_BACKGROUND);
//        System.out.println();
//        printColoredCheckerBoard(board, false, ConsoleColors.GREEN_BACKGROUND);
//        System.out.println();
//        printBoard(board, true);
//        System.out.println();
//        printColoredCheckerBoard(board, true, ConsoleColors.GREEN_BACKGROUND);

        paint(w, h, board, 40);
    }

    private static void paint(int w, int h, CellData[][] board, int side) {
        DisplayGraphics m = new DisplayGraphics(board, side);
        JFrame f = new JFrame();
        f.add(m);
        f.setSize(Math.max(w * side + side / 2, 1000), Math.max(h * side + side / 2, 1000));
        //f.setLayout(null);
        f.setVisible(true);
    }

    private static void printBoardHighlightPrimes(CellData[][] board, boolean printRowSpacers, String color) {
        if (printRowSpacers) {
            System.out.println("---------------------------------------------");
        }

        for (CellData[] rows : board) {
            System.out.print("|");
            for (CellData cell : rows) {
                if (cell.prime) {
                    System.out.print(color + cell.stringValue + ConsoleColors.RESET + "|");
                } else {
                    System.out.print(cell.stringValue + "|");
                }
            }
            System.out.println();

            if (printRowSpacers) {
                System.out.println("---------------------------------------------");
            }
        }
        System.out.print(ConsoleColors.RESET);
    }

    private static void printBoard(CellData[][] board, boolean printRowSpacers) {
        if (printRowSpacers) {
            System.out.println("---------------------------------------------");
        }

        for (CellData[] rows : board) {
            System.out.print("|");
            for (CellData cell : rows) {
                System.out.print(cell.stringValue + "|");
            }
            System.out.println();

            if (printRowSpacers) {
                System.out.println("---------------------------------------------");
            }
        }
        System.out.print(ConsoleColors.RESET);
    }

    private static void printColoredCheckerBoard(CellData[][] board, boolean printRowSpacers, String color) {
        if (printRowSpacers) {
            System.out.println("---------------------------------------------");
        }

        boolean coloredCell = false;
        for (CellData[] rows : board) {
            System.out.print("|");
            for (CellData cell : rows) {
                if (coloredCell) {
                    System.out.print(color + cell.stringValue + ConsoleColors.RESET + "|");
                } else {
                    System.out.print(cell.stringValue + "|");
                }
                coloredCell = !coloredCell;
            }
            System.out.println();

            if (printRowSpacers) {
                System.out.println("---------------------------------------------");
            }
        }
        System.out.print(ConsoleColors.RESET);
    }

    public static class CellData {
        int x;
        int y;
        int intValue;
        String stringValue;
        int direction;
        boolean prime = true;

        CellData(int x, int y, int value, int direction) {
            this.x = x;
            this.y = y;
            this.intValue = value;
            this.stringValue = String.format("%3d", value);
            this.direction = direction;

            this.isPrime();
        }

        private void isPrime() {
            if (intValue == 1) {
                prime = false;
            }
            for (int i = 2; i <= (int) Math.sqrt(intValue); i++) {
                if (intValue % i == 0) {
                    prime = false;
                    break;
                }
            }
        }
    }

}
