package lib.sixzeroseven.array;

/**
 * @auther: WJoe
 * @Description: Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * @Date : 14:03 2018/7/8
 */
public class RemoveDuplicatesFromSortedArrary {

    public int removeDuplicates(int[] nums) {
       if (nums == null||nums.length==0){
           return  0;
       }
       if (nums.length==1){
           return  1;
       }
       int flag =1;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i] != nums[i-1]){
                nums[flag]=nums[i];
                flag++;
            }
        }
        return  flag;
    }
}
