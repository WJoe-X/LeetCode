package lib.sixzeroseven.array;

import java.util.Scanner;

/**
 * @auther: WJoe
 * @Description: Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * @Date : 19:56 2018/7/8
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] rs = new int[]{-1,-1};
        if (nums==null||nums.length==0){
            return rs;
        }

        int left = 0;
        int right = nums.length;

        while (right >left) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                rs[0] = mid;
                rs[1] = mid;
                while (mid + 1 < right && nums[rs[0] + 1] == target) {
                    rs[1]++;
                }
                while (mid - 1 > left && nums[rs[1] - 1] == target) {
                    rs[0]--;
                }
                return  rs;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
      return  rs;
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i] = sc.nextInt();
        }
        int target  = sc.nextInt();
        SearchForARange  searchForARange = new SearchForARange();
        System.out.println(searchForARange.searchRange(nums,target)[0]);
        System.out.println(searchForARange.searchRange(nums,target)[1]);
    }
}
