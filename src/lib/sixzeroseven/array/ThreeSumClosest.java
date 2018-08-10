package lib.sixzeroseven.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @auther: WJoe
 * @Description: Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @Date : 15:27 2018/7/5
 */
public class ThreeSumClosest {
    /**
     * 思路和ThreeSum类似，只是判断条件变了
     *
     * @param nums
     * @param target
     * @return
     */

        public int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length < 3) return 0;
            Arrays.sort(nums);
            int ret = 0;
            int closestDist = Integer.MAX_VALUE;
            int len =  nums.length;
            for (int i = 0; i < len-2; i++) {
                if (i > 0 && nums[i] == nums[i-1])
                    continue;
                int left = i+1, right = len-1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum < target) {
                        if (target-sum < closestDist) {
                            closestDist = target - sum;
                            ret = sum;
                        }
                        left++;
                    } else if (sum > target) {
                        if (sum-target < closestDist) {
                            closestDist = sum - target;
                            ret = sum;
                        }
                        right--;
                    } else { //when sum == target, return sum.
                        return sum;
                    }
                }
            }
            return ret;
        }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        ThreeSumClosest ts = new ThreeSumClosest();
        System.out.println(ts.threeSumClosest(arr, target));

    }
}