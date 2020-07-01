/**
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

 

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

 

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
**/

public class container_with_most_water {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);

            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        if (height == null || height.length == 0) return 0;

        int maxArea = 0;
        int area;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                area = (j - i) * Math.min(height[i], height[j]);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,8,6,2,5,4,8,3,7};
        container_with_most_water ms = new container_with_most_water();
        System.out.println(ms.maxArea(test));
    }
}
