package New2024;

public class Jan10 {
    public int minLength(String s) {
        char[] array = new char[s.length()];
        // AB CD
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            array[index] = s.charAt(i);
            if (index >= 1 && ((array[index] == 'B' && array[index-1] == 'A') ||
                    (array[index] == 'D' && array[index-1] == 'C'))) {
                index -= 2;
            }
            index++;
        }
        return index;
    }
}
