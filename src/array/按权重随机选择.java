package array;

import java.util.Random;

public class 按权重随机选择 {

    /**
     * 给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。
     * 请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内
     * （含 0 和 w.length - 1）选出并返回一个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。
     * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），
     * 而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
     */

    private int[] preSum;

    private Random random;

    public 按权重随机选择(int[] w) {
        preSum = w;
        for (int i = 0; i < w.length; i++) {
            if (i > 0) {
                preSum[i] = preSum[i - 1] + w[i];
            }else {
                preSum[i] = w[i];
            }
        }

        random = new Random();
    }

    public int pickIndex() {
        // 需要获取区间的最大值，限制random生成的值
        int max = preSum[preSum.length - 1];

        int rand = random.nextInt(max) + 1;

        for (int i = 0; i < preSum.length; i++) {
            if (rand <= preSum[i]) {
                return i;
            }
        }

        return 0;
    }
}
