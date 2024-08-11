package New2024;

import java.util.*;

public class March {
    private int maxValue;

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        int res = new March().countPaths(n, roads);
        System.out.println(res);
    }

    // 16 Mar.
    public int maxMoves(int[][] grid) {
        int maxValue = Integer.MIN_VALUE;
        int[][] visit = new int[grid.length][grid[0].length];
        for (int[] row : visit) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < grid.length; i++) {
            maxValue = Math.max(maxValue, dfs333(i-1, 1, grid[i][0], grid, 0, visit));
            maxValue = Math.max(maxValue, dfs333(i, 1, grid[i][0], grid, 0, visit));
            maxValue = Math.max(maxValue, dfs333(i+1, 1, grid[i][0], grid, 0, visit));
        }
        return maxValue;
    }
    public int dfs333(int x, int y, int lastValue, int[][] grid, int count, int[][] visit) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return count;
        }
        if (visit[x][y] != -1) {
            return visit[x][y];
        }
        if (grid[x][y] > lastValue) {
            count++;
            int gridValue = grid[x][y];
            int x1 = dfs333(x-1, y+1, gridValue, grid, count, visit);
            int x2 = dfs333(x, y+1, gridValue, grid, count, visit);
            int x3 = dfs333(x+1, y+1, gridValue, grid, count, visit);
            int max = Math.max(Math.max(x1, x2), x3);
            visit[x][y] = max;
            return max;
        }
        return count;
    }

    // 15 Mar.
    public long sellingWood(int m, int n, int[][] prices) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < prices.length; i++) {
            map.put(prices[i][0] + " " + prices[i][1], prices[i][2]);
        }

        long[][] memo = new long[m+1][n+1];
        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs222(m, n, memo, map);
    }
    public long dfs222(int x, int y, long[][]memo, Map<String, Integer> map) {
        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        long value = map.getOrDefault(x + " " + y, 0);
        System.out.println(value);

        if (x > 1) {
            for (int i = 1; i < x; i++) {
                value = Math.max(value, dfs222(i, y, memo, map) + dfs222(x-i, y, memo, map));
            }
        }

        if (y > 1) {
            for (int j = 1; j < y; j++) {
                value = Math.max(value, dfs222(x, j, memo, map) + dfs222(x, y-j, memo, map));
            }
        }

        memo[x][y] = value;
        return value;
    }

    // 14 Mar.
    public long maxArrayValue(int[] nums) {
        long sum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            sum = nums[i] <= sum ? nums[i] + sum : nums[i];
        }
        return sum;
    }

    // 13 Mar.
    public String maximumOddBinaryNumber(String s) {
        int oneCount = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                oneCount++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < oneCount; i++) {
            sb.append('1');
        }
        for (int i = oneCount; i < s.length() - 1; i++) {
            sb.append('0');
        }
        sb.append('1');
        return sb.toString();
    }

    // March 11
    public String capitalizeTitle(String title) {
        int index = 0;
        int len = title.length();
        char[] res = new char[len];
        int x = 0;
        while (index < len) {
            while ((index < len) && title.charAt(index) != ' ') {
                System.out.println(index);
                index++;
            }

            if (index - x > 2) {
                res[x] = Character.toUpperCase(title.charAt(x));
                x++;
            }
            while (x < index) {
                res[x] = Character.toLowerCase(title.charAt(x));
                x++;
            }
            System.out.println(x +"- ");
            if (x < index) {
                res[x] = ' ';
            }
            index++;
            x = index;
        }

        return new String(res).replace("\u0000", " ");
    }

    // March 10
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int[] s1 = new int[10];
        int[] s2 = new int[10];

        int sameCount = 0;
        int otherCount = 0;
        for (int i = 0; i < n; i++) {
            int tmp1 = secret.charAt(i) - '0';
            int tmp2 = guess.charAt(i) - '0';
            if (tmp1 == tmp2) {
                sameCount++;
            }
            s1[tmp1]++;
            s2[tmp2]++;
        }

        for (int i = 0; i < 10; i++) {
            otherCount += Math.min(s1[i], s2[i]);
        }
        otherCount -= sameCount;
        return sameCount + "A" + otherCount + "B";
    }

    // March 9
    public long kSum(int[] nums, int k) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list1.add(nums[i]);
            for (int j = 0; j < list1.size(); j++) {
                list2.add(list1.get(j) + nums[i]);
            }
            list1 = list2;
        }

        list1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int j: list1) {
            System.out.println(j);
        }
        return list1.get(k);
    }

    // March 8
    public int minimumPossibleSum(int n, int target) {
        long mid = target / 2;
        long res = 0;
        long modNum = 1000000007;
        if (n <= mid) {
            res = (1 + n) * n / 2;
        } else {
            res = (long)(1 + mid) * mid / 2 + (((long) target + target + n - mid - 1) * (n - mid) / 2 % modNum);
        }
        System.out.println(res);
        return (int) (res % modNum);
    }


    // March 6
    public int findKOr(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < 31; i++) {
            int count = 0;
            int tmpNum = (int) Math.pow(2, i);
            for (int j = 0; j < nums.length; j++) {
                if ((tmpNum & nums[j]) == tmpNum) {
                    count++;
                }
                if (count >= k) {
                    res += tmpNum;
                    break;
                }
            }
        }
        return res;
    }

    // March 5
    public int countPaths(int n, int[][] roads) {
        long[][] matrix = new long[n][n];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], Long.MAX_VALUE);
        }
        // 邻接矩阵
        for (int i = 0; i < roads.length; i++) {
            matrix[roads[i][0]][roads[i][1]] = roads[i][2];
            matrix[roads[i][1]][roads[i][0]] = roads[i][2];
        }
        // 是否访问过
        boolean[] isVisit = new boolean[n];
        // 存储最短距离
        long[] shortest = new long[n];
        Arrays.fill(shortest, Long.MAX_VALUE);
        // 0到i的最短路径数量
        int[] dp = new int[n];
        // 0到0的最短路径数量为1
        dp[0] = 1;
        isVisit[0] = true;

        // 挑选节点次数
        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;
            int index = -1;
            // 贪心策略，选择到source最短的点加入图中
            for (int j = 0; j < n; j++) {
                if (isVisit[j] == false && matrix[0][j] < min) {
                    index = j;
                    min = matrix[0][j];
                }
            }

            // 在图中查找，经过index的更短路径
            for (int j = 0; j < n; j++) {
                if (isVisit[j] == true && matrix[0][index] + matrix[index][j] < matrix[0][j]) {
                    matrix[0][j] = matrix[0][index] + matrix[index][j];
                    dp[j] = dp[index];
                } else if  (isVisit[j] == true && matrix[0][index] + matrix[index][j] == matrix[0][j]) {
                    dp[j] += dp[index];
                }
            }
        }
        return dp[n-1];
    }

    // March 1
    public boolean validPartition(int[] nums) {
        boolean[] flag = new boolean[nums.length + 1];
        flag[nums.length] = true;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i >= 1) {
                flag[i - 1] |= flag[i + 1] && checkValid(nums, i, 1);

                System.out.println(i-1 + " " + flag[i - 1]);
            }
            if (i >= 2) {
                flag[i - 2] |= flag[i + 1] && checkValid(nums, i, 2);
                System.out.println(i-2 + " " + flag[i - 2]);
            }
        }
        return flag[0];
    }
    public boolean checkValid(int[] nums, int right, int size) {
        int left = right - size;
        if (size == 1) {
            return nums[left] == nums[right];
        }
        if (size == 2) {
            return ((nums[left+1] == nums[right]) && (nums[left] == nums[right])) ||
                    ((nums[left+1] == nums[left] + 1) && (nums[right] == nums[left+1] + 1));
        }
        return false;
    }
}
