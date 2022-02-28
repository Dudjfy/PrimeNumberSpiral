import java.util.Arrays;

public class PrimeNumberSpiral {
    public static void main(String[] args) {
        String[] connections = {">", "/\\", "<", "\\/"};

        int direction = 0;
        int num = 1;
        int w = 11;
        int h = 11;

        int x = Math.floorDiv(w, 2);
        int y = Math.floorDiv(h, 2);

        CellData[][] board = new CellData[h][w];

        int range = w * h;
        int startAt = 2;
        for (int i = startAt; num < range; i++) {
            for (int j = 0; j < Math.floorDiv(i, 2); j++) {
                board[y][x] = new CellData(x, y, num);
                x += (int) Math.cos(Math.toRadians(direction));
                y += (int) Math.sin(Math.toRadians(direction));
                num++;
            }
            direction -= 90;
        }

        printBoard(board, false);
        System.out.println();
        printColoredCheckerBoard(board, false, ConsoleColors.GREEN_BACKGROUND);
        System.out.println();
        printBoard(board, true);
        System.out.println();
        printColoredCheckerBoard(board, true, ConsoleColors.GREEN_BACKGROUND);
    }
    private static void printBoard(CellData[][] board, boolean printRowSpacers){
        if (printRowSpacers){
            System.out.println("---------------------------------------------");
        }

        for (CellData[] rows : board) {
            System.out.print("|");
            for (CellData cell : rows) {
                System.out.print(cell.stringValue + "|");
            }
            System.out.println();

            if (printRowSpacers){
                System.out.println("---------------------------------------------");
            }
        }
        System.out.print(ConsoleColors.RESET);
    }

    private static void printColoredCheckerBoard(CellData[][] board, boolean printRowSpacers, String color){
        if (printRowSpacers){
            System.out.println("---------------------------------------------");
        }

        boolean coloredCell = false;
        for (CellData[] rows : board) {
            System.out.print("|");
            for (CellData cell : rows) {
                if (coloredCell){
                    System.out.print(color + cell.stringValue + ConsoleColors.RESET + "|");
                } else{
                    System.out.print(cell.stringValue + "|");
                }
                coloredCell = !coloredCell;
            }
            System.out.println();

            if (printRowSpacers){
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

        CellData(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.intValue = value;
            this.stringValue = String.format("%3d", value);
        }
    }

}
