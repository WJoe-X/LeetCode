package lib.sixzeroseven;

/**
 * @auther: WJoe
 * @Description: Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * @Date : 21:59 2018/7/4
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int heighth = 0;
        int area = 0;
        while (left <= right) {
            heighth = Math.min(height[left], height[right]);
            area = Math.max(area, heighth * (right - left));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return area;
    }
}
