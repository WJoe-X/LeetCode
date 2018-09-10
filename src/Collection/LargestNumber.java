package Collection;

import java.util.*;

/**
 * @auther: WJoe
 * @Description:
 * @Date : 17:04 2018/8/26
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums ==null || nums.length == 0)
            return null;
        Integer[] array = new Integer[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            array[i] = nums[i];
        }

        Arrays.sort(array, new Comparator<Integer> (){
            @Override
            public int compare(Integer i1, Integer i2){
                String s1 = i1.toString() + i2.toString();
                String s2 = i2.toString() + i1.toString();
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        while(sb.charAt(0)=='0'&&sb.length()>1)
            sb.deleteCharAt(0);
        return sb.toString();


    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        Integer n  = 999999998;
        String str1 = "我java";
        StringBuilder sb = new StringBuilder(str1);//构造一个StringBuilder对象
        sb.insert(1, "正在学习");//在指定的位置1，插入指定的字符串

        System.out.println(sb.toString());
        System.out.println(sb.delete(0,1).toString());

        System.out.println(n.toString());
        System.out.println(largestNumber.largestNumber(new int []{999999998,999999997,999999999}));
    }

}

