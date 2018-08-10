package lib.sixzeroseven;

import java.util.*;

/**
 * @auther: WJoe
 * @Description: 统计前K个高频词
 * @Date : 9:47 2018/7/27
 */
public class TopKsum {

    public static int[] findTopKsum(int[] arr, int k) {
        int[] result = new int[k];
        if (arr == null || arr.length < k) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (int i = 0; i < arr.length; i++) {
            if (null == map.get(arr[i])) {
                map.put(arr[i], 0);
            }
            map.put(arr[i], map.get(arr[i]) + 1);
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();

        for (Map.Entry<Integer, Integer> entry : set) {
            queue.add(entry);
        }
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();
        }


        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();
        int[] result = findTopKsum(ints, k);
        for (int i = 0; i <k ; i++) {
            System.out.println(result[i]);
        }
    }

}
