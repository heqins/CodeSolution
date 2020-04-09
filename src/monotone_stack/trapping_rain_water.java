import java.util.Stack;

/**
给了边界的高度（黑色部分），让求能装的水量（蓝色部分）。 为啥能用单调栈来做呢？我们先来考虑一下，

什么情况下可以装下水呢，是不是必须两边高，中间低呢？我们对低洼的地方感兴趣，就可以使用一个单调递减栈，

将递减的边界存进去，一旦发现当前的数字大于栈顶元素了，那么就有可能会有能装水的地方产生。此时我们当前的数字是右边界，

我们从栈中至少需要有两个数字，才能形成一个坑槽，先取出的那个最小的数字，就是坑槽的最低点，再次取出的数字就是左边界，

我们比较左右边界，取其中较小的值为装水的边界，然后此高度减去水槽最低点的高度，乘以左右边界间的距离就是装水量了。

由于需要知道左右边界的位置，所以我们虽然维护的是递减栈，但是栈中数字并不是存递减的高度，而是递减的高度的坐标。

这应该属于单调栈的高级应用了，可能并不是那么直接就能想出正确的解法。

**/

public class trapping_rain_water {
    public static int trap(int[] height) {
        int left = 0;
        int leftMax = 0;
        int right = height.length - 1;
        int rightMax = 0;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                res += leftMax - height[left];
                left++;
            }else {
                rightMax = Math.max(height[right], rightMax);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(A));
    }
}
