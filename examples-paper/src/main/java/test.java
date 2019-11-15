/**
 * Created by liuxiang on 2019/11/15.
 */
public class test {
    public static void main(String[] args) {
        System.out.println(Murmurhash.hashUnsigned("murmurhash"));
        System.out.println(Murmurhash.hashUnsigned("paper"));
        System.out.println(Murmurhash.hashUnsigned("liuxiang"));
        String a = "test";
        int numPartitions = 8;
        System.out.println(Math.abs(Murmurhash.hash(a)) % numPartitions);
    }
}
