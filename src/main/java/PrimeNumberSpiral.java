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

        printBoard(board);
    }

    private static void printBoard(CellData[][] board){
        System.out.println("---------------------------------------------");
        for (CellData[] rows : board) {
            System.out.print("|");
            for (CellData cell : rows) {
                System.out.print(cell.stringValue + "|");
            }
            System.out.println();
            System.out.println("---------------------------------------------");
        }
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
