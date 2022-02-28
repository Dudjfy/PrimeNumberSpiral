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
//        System.out.println(x + " " + y);

        String[][] board = new String[h][w];
//        for (int row = 0; row < board.length; row++) {
//            for (int col = 0; col < board[row].length; col++) {
//                board[row][col] = "";
//            }
//        }


        int range = w * h;
        int startAt = 2;
        for (int i = startAt; num < range; i++) {
//            System.out.println("i: " + i + ", dir:" + direction % 360 + ", cos:" + (int) Math.cos(Math.toRadians(direction)) + ", sin:" + (int) Math.sin(Math.toRadians(direction)) +  " - ");
            for (int j = 0; j < Math.floorDiv(i, 2); j++) {
//              System.out.println(num + " - X" + x + " Y" + y);
//              System.out.println("i: " + i + ", dir:" + direction % 360
//                        + ", cos:" + (int) Math.cos(Math.toRadians(direction))
//                        + ", sin:" + (int) Math.sin(Math.toRadians(direction))
//                        + ", X" + x
//                        + " Y" + y
//                        + " - ");

                board[y][x] = Integer.toString(num);
                x += (int) Math.cos(Math.toRadians(direction));
                y += (int) Math.sin(Math.toRadians(direction));
                num++;
            }
            direction -= 90;
//            System.out.println();
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
