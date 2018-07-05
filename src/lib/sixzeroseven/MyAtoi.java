package lib.sixzeroseven;

import java.util.Scanner;

/**
 * @auther: WJoe
 * @Description:Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 * @Date : 21:09 2018/7/4
 */
public class MyAtoi {
    public int myAtoi(String str) {
        if (str == null || str.trim() == "") {
            return 0;
        }
        //去除两边的空格！！！
        str = str.trim();
        boolean boo = true;
        int n = 0;
        if (str.charAt(0) == '+') {
        } else if (str.charAt(0) == '-') {
            boo = false;
        } else if (str.charAt(0) <= '9' && str.charAt(0) >= '0') {
            n = str.charAt(0)-'0';
        } else {
            return 0;
        }

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                n = n * 10 + (str.charAt(i)-'0');
            } else {
                break;
            }
        }
        if (boo) {
            return n;
        }else {
            return n*(-1);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       String s =  scanner.next();
      MyAtoi m = new MyAtoi();
        System.out.println(m.myAtoi(s));
    }
}


