import java.util.ArrayList;
import java.util.List;

public class Snail {

    /**
     * TODO 5
     * <p>
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     * <p>
     * Example:
     * <p>
     * Input:
     * <p>
     * {
     * {1,2,3},
     * {4,5,6},
     * {7,8,9}
     * }
     * <p>
     * Output:
     * <p>
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     * returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {

        if (isPerfectSquare(array2d)== true) {

            int n = array2d.length;
            int[] List = new int[array2d.length * array2d.length];
            System.out.println("hello!");
            int rowStart = 0;
            int rowEnd = n - 1;
            int colStart = 0;
            int colEnd = n - 1;
            int index = 0;

            while (rowStart <= rowEnd && colStart <= colEnd) {
                // Traverse the top row from left to right
                for (int col = colStart; col <= colEnd; col++) {
                    List[index++] = array2d[rowStart][col];
                }
                rowStart++;

                // Traverse the right column from top to bottom
                for (int row = rowStart; row <= rowEnd; row++) {
                    List[index++] = array2d[row][colEnd];
                }
                colEnd--;

                // Traverse the bottom row from right to left
                if (rowStart <= rowEnd) {
                    for (int col = colEnd; col >= colStart; col--) {
                        List[index++] = array2d[rowEnd][col];
                    }
                    rowEnd--;
                }

                // Traverse the left column from bottom to top
                if (colStart <= colEnd) {
                    for (int row = rowEnd; row >= rowStart; row--) {
                        List[index++] = array2d[row][colStart];
                    }
                    colStart++;
                }
            }
            return List;
        }
        return new int[0];


        // Convert the list to an array


    }

    // Method to check if a number is a perfect square



    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if(!isPerfectSquare(array1d))
        {
            return new int[0][0];
        }
        int[][] mySnail = new int[ (int) Math.sqrt(array1d.length)][ (int) Math.sqrt(array1d.length)];
        int n = array1d.length;
        int size = (int) Math.sqrt(n);

        if (size * size != n) {
            return new int[0][0]; // Return an empty 2D array if n is not a perfect square
        }

        int[][] snail = new int[size][size];
        int rowStart = 0, rowEnd = size - 1;
        int colStart = 0, colEnd = size - 1;
        int value = 0;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Fill the top row
            for (int col = colStart; col <= colEnd; col++) {
                snail[rowStart][col] = array1d[value++];
            }
            rowStart++;

            // Fill the right column
            for (int row = rowStart; row <= rowEnd; row++) {
                snail[row][colEnd] = array1d[value++];
            }
            colEnd--;

            // Fill the bottom row
            if (rowStart <= rowEnd) {
                for (int col = colEnd; col >= colStart; col--) {
                    snail[rowEnd][col] = array1d[value++];
                }
                rowEnd--;
            }

            // Fill the left column
            if (colStart <= colEnd) {
                for (int row = rowEnd; row >= rowStart; row--) {
                    snail[row][colStart] = array1d[value++];
                }
                colStart++;
            }
        }

        return snail;
    }



    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {

        for(int i =0; i<array1d.length;i++)
        {
            System.out.println(array1d[i]);
        }
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {

        for(int i=0; i<array2d.length;i++)
        {
            for(int j=0; j<array2d[i].length;j++)
            {
                System.out.println(array2d[i][j]);
            }
        }


    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        if(array1d==null)
        {
            return false;
        }
        int length = array1d.length;
        int sqrt = (int) Math.sqrt(length);

        return sqrt * sqrt == length;
    }



    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {

        if(array2d==null)
        {
            return false;
        }
        int rows = array2d.length;

        if (rows == 0) {

            return false;
        }


        int columns = array2d[0].length;
        for (int i = 1; i < rows; i++) {
            if (array2d[i].length != columns) {
                return false;
            }
        }

        return rows == columns;
    }


}
