package greedy;

public class 加油站_2 {

    /**
     * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
     * @param args
     */
    public static int solve(int[] gas, int[] cost) {
        int currentSum = 0;
        int resultIndex = 0;
        int totalSum = 0;

        // 也就是说明他的起点是唯一的，只有从cursum<0的下一个节点位置开始，它行走的路径最长，能够获得累加的机会更大。
        for (int i = 0; i < gas.length; i++) {
            currentSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (currentSum < 0) {
                resultIndex = i + 1;
                currentSum = 0;
            }
        }

        // 判断第一个位置开始出发是否能跑完
        if (totalSum < 0) {
            return -1;
        }

        return resultIndex;
    }
}
