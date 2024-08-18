package New2024;

// https://leetcode.cn/problems/student-attendance-record-i/
public class August18 {
    // 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
    // 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
    // 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
    public boolean checkRecord(String s) {
        int aCount = 0;
        int lCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t == 'A') {
                aCount++;
                lCount = 0;
            } else if (t == 'L') {
                lCount++;
            } else {
                lCount = 0;
            }

            if (aCount < 2 && lCount < 3) {
                return false;
            }
        }

        return aCount < 2 && lCount < 3;
    }
}

