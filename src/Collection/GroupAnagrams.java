package Collection;

import java.util.*;

/**
 * @auther: WJoe
 * @Description: Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * @Date : 19:40 2018/8/19
 */
public class GroupAnagrams {
    public static List<List<String>>  groupAnagrams(String[] strs) {
        if (strs ==null ||strs.length ==0)
            return  null;
        TreeMap<String,List<String>> map = new TreeMap<>();

        for (String s: strs) {
            char [] chars =s.toCharArray();
            Arrays.sort(chars);
            String copy= new String(chars);
            if (!map.containsKey(copy))
                map.put(copy ,new ArrayList<String>());
                map.get(copy).add(s);

        }
        return new ArrayList<>(map.values());
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
