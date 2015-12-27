package hackerrank.algorithms.Implementation;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by yupeng on 12/27/2015.
 * <p/>
 * Problem Statement
 * <p/>
 * Roy wanted to increase his typing speed for programming contests. So, his friend advised him to type the sentence "The quick brown fox jumps over the lazy dog" repeatedly, because it is a pangram. (Pangrams are sentences constructed by using every letter of the alphabet at least once.)
 * <p/>
 * After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.
 * <p/>
 * Given a sentence s, tell Roy if it is a pangram or not.
 * <p/>
 * Input Format
 * <p/>
 * Input consists of a string s.
 * <p/>
 * Constraints
 * Length of s can be at most 103 (1≤|s|≤103) and it may contain spaces, lower case and upper case letters. Lower-case and upper-case instances of a letter are considered the same.
 * <p/>
 * Output Format
 * <p/>
 * Output a line containing pangram if s is a pangram, otherwise output not pangram.
 * <p/>
 * Sample Input
 * <p/>
 * Input #1
 * <p/>
 * We promptly judged antique ivory buckles for the next prize
 * Input #2
 * <p/>
 * We promptly judged antique ivory buckles for the prize
 * Sample Output
 * <p/>
 * Output #1
 * <p/>
 * pangram
 * Output #2
 * <p/>
 * not pangram
 * Explanation
 * <p/>
 * In the first test case, the answer is pangram because the sentence contains all the letters of the English alphabet.
 */
public class Pangrams {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for (char c : input.toCharArray()
                ) {
            map.put(c,1);
        }
        map.remove(' ');
        if(map.size()==26){
            System.out.println("pangram");
        }else{
            System.out.println("not pangram");
        }

    }
}
