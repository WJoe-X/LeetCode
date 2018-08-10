package lib.sixzeroseven;

/**
 * @auther: WJoe
 * @Description:Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * @Date : 21:53 2018/7/4
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
             if (x==0){
                 return true;
             }else if (x<0){
                 return false;
             }
             String s = String.valueOf(x);
             int i = 0,j=s.length()-1;
             while (i<=j){
                 if (s.charAt(i)==s.charAt(j)){
                     i++;
                     j--;
                 }else {
                     return  false;
                 }
             }
             return true;
    }

}
