package lib.sixzeroseven;

import java.util.Scanner;

/**
 * @auther: WJoe
 * @Description: Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 * @Date : 21:08 2018/6/28
 */
public class LongestPalindromicSubstring {
   private static String  expandAroundCenter(String s, int c1, int c2) {
        int l = c1, r = c2;
       int n = s.length();
        if (l >= 0 && r <= n-1 &&s.charAt(l) != s.charAt(r)){
            return  "";
        }

        while (l >= 0 && r <= n-1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }

   public String longestPalindromeSimple(String s) {
        int n = s.length();
        if (n == 0) return "";
        String longest = s.substring(0, 1);  // a single char itself is a palindrome
        for (int i = 0; i < n-1; i++) {
            String p1 = expandAroundCenter(s, i, i);
            if (p1.length() > longest.length())
                longest = p1;

            String p2 = expandAroundCenter(s, i, i+1);
            if (p2.length() > longest.length())
                longest = p2;
        }
        return longest;
    }

    public  static void  main(String[] args){
       LongestPalindromicSubstring ll = new LongestPalindromicSubstring();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
      System.out.print(ll.longestPalindromeSimple(s));

    }

}
