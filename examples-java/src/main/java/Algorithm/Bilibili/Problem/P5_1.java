package Algorithm.Bilibili.Problem;

/**
 * Created by Elvis on 2019/12/23.
 */
public class P5_1 {
	public static void main(String[] args) {
		int[][] array = new int[][] {
			{0, 0, 1, 0, 1, 0},
			{1, 1, 1, 0, 1, 1},
			{1, 0, 1, 1, 1, 1},
			{0, 0, 1, 0, 0, 1}
		};
		System.out.println(countIslands(array));
 	}

 	public static int countIslands(int[][] arr) {
	    if (arr == null || arr[0] == null) {
	        return 0;
        }
 		int count = 0;
 		for (int i = 0; i < arr.length; i++) {
 			for (int j = 0; j < arr[i].length; j++) {
 				if (infect(arr, i, j)) {
 					count++;
 				}
 			}
 		}
 		return count;
 	}

 	public static boolean infect(int[][] arr, int i, int j) {
 		if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != 1) {
 			return false;
 		}
 		arr[i][j] = 2;
 		infect(arr, i - 1, j);
 		infect(arr, i + 1, j);
 		infect(arr, i, j - 1);
 		infect(arr, i, j + 1);
 		return true;
 	}
}
