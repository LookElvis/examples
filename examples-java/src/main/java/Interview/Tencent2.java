package Interview;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/9/20.
 */
public class Tencent2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int times = input.nextInt();

        for (int i = 0; i < times; i++) {
            int k = input.nextInt();
            int[] m = new int[k];
            int sum = 0;
            for (int j = 0; j < k; j++) {
                m[j] = input.nextInt();
                sum += m[j];
            }
            int r = SumToM(m, m.length / 2, sum / 2);
            System.out.println(r + " " + (sum - r));
        }
    }

    public static int SumToM(int[] value, int N, int M) {
        int f[] = new int[100];
        int g[][] = new int[100][100];
        int i;
        int v;
        for(i=0;i<N;i++)
        {
            for(v=M;v>=value[i];v--)
            {
                if(f[v]<f[v-value[i]]+value[i])
                {
                    f[v]=f[v-value[i]]+value[i];
                    g[i][v]=1;
                }
                else
                {
                    f[v]=f[v];
                    g[i][v]=0;
                }
            }
        }
        return f[M];
    }
}
