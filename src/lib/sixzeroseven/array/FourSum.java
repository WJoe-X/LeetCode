package lib.sixzeroseven.array;

import java.util.*;

/**
 * @auther: WJoe
 * @Description:Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * @Date : 16:55 2018/7/5
 */
public class FourSum {
    private  static  Set<List<Integer>> sets = new HashSet<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                lists.addAll(Sum(nums, i, j, target));
            }
        }
        return lists;
    }

    private static List<List<Integer>> Sum(int[] nums, int head, int tailer, int target) {
        int left = tailer + 1;
        int right = nums.length - 1;
        List<List<Integer>> lists = new ArrayList<>();
        while (right > left) {
            int diff = nums[head] + nums[tailer] + nums[right] + nums[left] - target;
            if (diff > 0) {
                right--;
            } else if (diff < 0) {
                left++;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[head]);
                list.add(nums[tailer]);
                list.add(nums[right]);
                list.add(nums[left]);
                if (!sets.contains(list)){
                    sets.add(list);
                    lists.add(list);
                }
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
        int target = sc.nextInt();
        FourSum ts = new FourSum();
        System.out.println(ts.fourSum(arr, target));
    }

}
