package lib.sixzeroseven.array;

import java.util.*;

/**
 * @auther: WJoe
 * @Description: Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @Date : 14:07 2018/7/5
 */
public class ThreeSum {

    /**
     * 1、排序
     * 2、排序之后，我们就可以对数组用两个指针分别从前后两端向中间扫描了，
     * 如果是 2Sum，我们找到两个指针之和为target，
     * 那 3Sum 类似，我们可以先固定一个数，然后找另外两个数之和为第一个数的相反数就可以了。
     * 注意重复值以及空值
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            lists.addAll(Sum(nums, i));
        }
        return lists;
    }

    private static List<List<Integer>> Sum(int[] nums, int head) {

        int left = head + 1;
        int target = nums[head];
        int right = nums.length - 1;

        List<List<Integer>> lists = new ArrayList<>();
        while (right > left) {
            if (target + nums[right] + nums[left] > 0) {
                right--;
            } else if (target + nums[right] + nums[left] < 0) {
                left++;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(target);
                list.add(nums[right]);
                list.add(nums[left]);
                lists.add(list);
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                right--;
                left++;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.threeSum(arr));
    }
}
