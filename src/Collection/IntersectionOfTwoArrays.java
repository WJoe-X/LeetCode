package Collection;

import java.util.*;

/**
 * @auther: WJoe
 * @Description: 给定两个数组，求两个数组的公共元素
 * @Date : 17:06 2018/8/19
 */
public class IntersectionOfTwoArrays {

    private  static List<Integer> getIntersection(int[] a, int[] b){

        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i <a.length ; i++) {
            set.add(a[i]);
        }
        for (int i = 0; i <b.length ; i++) {
            if (set.contains(b[i]))
                result.add(b[i]);
        }
            return  new ArrayList<Integer>(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] ns = new int[n];
        int[] ms = new int[m];
        for (int i = 0; i <n ; i++) {
            ns[i]=scanner.nextInt();
        }
        for (int i = 0; i <m ; i++) {
            ms[i]= scanner.nextInt();
        }

        System.out.println(getIntersection(ns,ms));
    }
}
