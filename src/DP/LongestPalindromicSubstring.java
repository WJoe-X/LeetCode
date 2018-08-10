package DP;

/**
 * @auther: WJoe
 * @Description: Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 * @Date : 16:04 2018/8/10
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s ==null|| s.length() ==0)
            return "";
        char[] chars = s.toCharArray();
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i <chars.length ; i++) {
            int j = 1;
            while (i-j>=0 &&i+j<chars.length &&chars[i-j]==chars[i+j]){
                if (2*j+1>max){
                    max = 2*j+1;
                    start = i-j;
                    end = i+j;
                }
            }
            if (chars[i]==chars[i+1]){
                while (i-j>=0 &&i+1+j<chars.length &&chars[i-j]==chars[i+j+1]){
                    if (2*j+2>max){
                        max = 2*j+2;
                        start = i-j;
                        end = i+j+1;
                    }
                }
            }
        }
       return s.substring(start,end+1);
    }
}
