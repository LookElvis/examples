package Algorithm.Problem;

/**
 * Created by Elvis on 2019/12/18.
 */
public class P3_2 {
    public static void main(String[] args) {
        int[][] m = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printZigZag(m);
    }

    public static void printZigZag(int[][] m) {
    	int row1 = 0;
    	int row2 = 0;
    	int col1 = 0;
    	int col2 = 0;
    	int endR = m.length - 1;
    	int endC = m[0].length - 1;
    	boolean isFromUp = false;
    	while (row2 <= endR) {
    		printLevel(m, row1, col1, row2, col2, isFromUp);
    		row2 = col2 == endC ? ++row2 : row2;
    		col2 = col2 == endC ? col2 : ++col2;
    	    col1 = row1 == endR ? ++col1 : col1;
    		row1 = row1 == endR ? row1 : ++row1;
    		isFromUp = !isFromUp;
    	}
    }

    public static void printLevel(int[][] m, int row1, int col1, int row2, int col2, boolean isFromUp) {
    	if (isFromUp) {
    		while (col1 <= col2) {
    			System.out.print(m[row2++][col2--] + " ");
    		}
    	} else {
       		while (col1 <= col2) {
    			System.out.print(m[row1--][col1++] + " ");
    		} 		
    	}
    }
}
