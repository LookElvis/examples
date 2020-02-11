package New.Test1;



import java.util.*;

/**
 * Created by Elvis on 2020/2/11.
 */
public class d3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[] array = new int[num];
        List<Integer> list = new ArrayList<>(num);

        int last = 0;
        for (int i = 0; i < num; i++) {
            int tmp = input.nextInt();
            array[last++] = tmp;
        }

        for (int i = 0; i < num; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
