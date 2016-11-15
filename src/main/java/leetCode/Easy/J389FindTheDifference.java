package leetCode.Easy;

/**
 * Created by yupeng on 2016/10/9.
 */
public class J389FindTheDifference {
    public char findTheDifference(String s, String t) {
        if (("".equals(s) || s == null) && t != null) {
            return t.toCharArray()[0];
        }
        if (s != null && (t == null || "".equals(t))) {
            return s.toCharArray()[0];
        }
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        char result = charsS[0];
        for (int i = 1; i < charsS.length; i++) {
            result ^= charsS[i];
        }
        for (int i = 0; i < charsT.length; i++) {
            result ^= charsT[i];
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        J389FindTheDifference j389FindTheDifference = new J389FindTheDifference();
        char theDifference = j389FindTheDifference.findTheDifference(s, t);
        System.out.println(theDifference);
    }

}
