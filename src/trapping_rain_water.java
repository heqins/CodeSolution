import java.util.Stack;

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
