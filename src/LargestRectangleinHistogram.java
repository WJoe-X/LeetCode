import java.util.Stack;

/**
 * @auther: WJoe
 * @Description: 直方图是由许多矩形组成，在给定的直方图中找出最大的矩形面积。为了简化问题，假定所有矩形宽度都为1个单位。
 * @Date : 16:33 2018/8/26
 */
public class LargestRectangleinHistogram {

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int length = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int i = 0;
        while (i < length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                i++;
            } else {
                int index = stack.pop();
                max = Math.max(max, heights[index] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            max = Math.max(max, heights[index] * (stack.isEmpty() ? i : i - stack.peek() - 1));
        }
        return max;
    }
}
