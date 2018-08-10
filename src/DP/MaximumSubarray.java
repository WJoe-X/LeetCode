package DP;

import org.omg.CORBA.MARSHAL;

/**
 * @auther: WJoe
 * @Description: Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * @Date : 16:25 2018/8/10
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int max = nums[nums.length - 1];
        int cur = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= 0) {
                cur = 0;
                if (nums[i] > max)
                    max = nums[i];
            } else {
                while (i >= 0 && cur + nums[i] > 0) {
                    cur += nums[i];
                    if (cur > max)
                        max = cur;
                    i--;
                }
                cur = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] n = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(n));
    }

}
