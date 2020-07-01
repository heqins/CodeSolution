/**
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

 

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

 

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
**/


/**
比如我们计算n面积的时候，假如左侧的线段高度比右侧的高度低，那么我们通过左移右指针来将长度缩短为n-1的做法是没有意义的，
因为`新的形成的面积变成了(n-1) * heightOfLeft 这个面积一定比刚才的长度为n的面积nn * heightOfLeft 小`

也就是说最大面积`一定是当前的面积或者通过移动短的线段得到`。
关键点：
- 双指针优化时间复杂度
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
