package array;

import java.util.Stack;

public class 商品折扣后的最终价格 {

    /**
     * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
     *
     * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
     *
     * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
     */
    public static void main(String[] args) {
        int[] prices = new int[]{8, 4, 6, 2, 3};
        finalPrices(prices);
    }

    public static int[] finalPrices(int[] prices) {
        // 单调栈的解法
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                result[index] = prices[index] - prices[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = prices[index];
        }

        return result;
    }
}
