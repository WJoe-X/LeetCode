package lib.sixzeroseven;

import java.util.Scanner;

/**
 * @auther: WJoe
 * @Description:Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * @Date : 20:26 2018/7/4
 */
public class ReverseInt {

    public int reverse(int x) {
        boolean boo = x >= 0;
        int n = Math.abs(x);
        try {


            StringBuilder s = new StringBuilder(String.valueOf(n));
            String sr = s.reverse().toString();
            int r = Integer.parseInt(sr);
            if (!boo) {
                r *= -1;
            }
            return r;
        } catch (Exception e) {
            return 0;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ReverseInt rr = new ReverseInt();
        System.out.println(rr.reverse(n));
    }

}
