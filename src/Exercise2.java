public class Exercise2 {

    private static int[][] calculateTranspose( int[][] grid) {
        int[][] transpose;
        int row = grid.length;
        int column = grid[0].length;
        transpose = new int[column][row];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                transpose[i][j] = grid[j][i];
            }
        }
        return transpose;
    }

    private static void printGrid(int[][] array) {
        for (int[] row : array) {
            System.out.print("  ");
            for (int number : row) {
                System.out.printf("  [%5d]", number);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] numbers = {
                {1, 2, 3, 4, 5, 6},
                {10, 20, 30, 40, 50, 60},
                {100, 200, 300, 400, 500, 600,}
        };
        System.out.println("Original number grid:");
        System.out.println();
        printGrid(numbers);
        System.out.println("Transposed grid:");
        System.out.println();
        printGrid(calculateTranspose(numbers));
        System.out.println();
    }
}
