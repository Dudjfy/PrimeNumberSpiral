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

        String[][] board = new String[h][w];

        int range = w * h;
        int startAt = 2;
        for (int i = startAt; num < range; i++) {
            for (int j = 0; j < Math.floorDiv(i, 2); j++) {
                board[y][x] = Integer.toString(num);
                x += (int) Math.cos(Math.toRadians(direction));
                y += (int) Math.sin(Math.toRadians(direction));
                num++;
            }
            direction -= 90;
        }

        printBoard(board);
    }

    private static void printBoard(String[][] board){
        System.out.println("---------------------------------------------");
        for (String[] rows : board) {
            System.out.print("|");
            for (String cell : rows) {
                System.out.print(String.format("%3s|", cell));
            }
            System.out.println();
            System.out.println("---------------------------------------------");
        }
    }

}
