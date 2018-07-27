package lib.sixzeroseven.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther: WJoe
 * @Description:
 * @Date : 19:26 2018/7/11
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return lists;
        }
        Arrays.sort(candidates);
        getResult(lists, new ArrayList<Integer>(), candidates, 0, target);
        return lists;

    }

    private static void getResult(List<List<Integer>> result, List<Integer> current, int[] candidates, int start, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            current.add(candidates[i]);
            getResult(result, current, candidates,i, target - candidates[i]);
            current.remove(current.size() - 1);//后退一步
        }


    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        System.out.println(new CombinationSum().combinationSum(nums, 7));
    }
}
