package leetCode.Easy;

/**
 * Created by yupeng on 2016/10/9.
 */
public class J344ReverseString {
    public String reverseString(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            str.append(chars[i]);
        }
        return str.toString();
    }

    public static void main(String[] args) {

    }
}
