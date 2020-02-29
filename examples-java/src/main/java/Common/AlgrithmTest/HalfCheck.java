package Common.AlgrithmTest;

/**
 * Created by Elvis on 2020/2/29.
 */
public class HalfCheck {
    public static void main(String[] args) {
        int[] m = new int[] {1, 3, 7, 8, 12, 18, 23};
        int target = 14;
        int l = 0;
        int r = m.length - 1;
        int mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (m[mid] == target) {
                System.out.println(mid);
                break;
            } else if (m[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(-1);
    }
}
