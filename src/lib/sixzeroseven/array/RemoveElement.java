package lib.sixzeroseven.array;

import java.util.Scanner;

/**
 * @auther: WJoe
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length. * @Date : 14:11 2018/7/8
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int right = nums.length-1;
        int left = 0;
        while (left <= right) {
            if (nums[left] == val) {
                count++;
                if (nums[right] != val) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    right --;
                    left++;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums  = new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i] = sc.nextInt();
        }
        int val = sc.nextInt();
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(nums,val));
    }
}
