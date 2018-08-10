package lib.sixzeroseven;

/**
 * @auther: WJoe
 * @Description:Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 * @Date : 22:43 2018/7/4
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        int length = Integer.MAX_VALUE;
        StringBuilder sb= new StringBuilder();
        for(int i = 0; i <strs.length ; i++) {
           length = Math.min(strs[i].length(),length);
        }
        for (int i = 0; i <length ; i++) {
            for (int j = 1; j <strs.length ; j++) {
                if (strs[0].charAt(i)!=strs[j].charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }

}
