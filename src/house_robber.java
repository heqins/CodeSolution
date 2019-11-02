public class house_robber {
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        //Initialize an arrays to store the money
        int[] mark = new int[nums.length];

        //We can infer the formula from problem:mark[i]=max(num[i]+mark[i-2],mark[i-1])
        //so initialize two nums at first.
        mark[0] = nums[0];
        mark[1] = Math.max(nums[0], nums[1]);

        //Using Dynamic Programming to mark the max money in loop.
        for(int i=2;i<nums.length;i++){
            mark[i] = Math.max(nums[i]+mark[i-2], mark[i-1]);
        }
        return mark[nums.length-1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{3, 1, 1, 3, 1}));
    }
}
