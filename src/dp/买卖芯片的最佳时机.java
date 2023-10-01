package dp;

public class 买卖芯片的最佳时机 {

    /**
     * 数组 prices 记录了某芯片近期的交易价格，其中 prices[i] 表示的 i 天该芯片的价格。你只能选择 某一天 买入芯片，并选择在 未来的某一个不同的日子 卖出该芯片。请设计一个算法计算并返回你从这笔交易中能获取的最大利润。
     *
     * 如果你不能获取任何利润，返回 0。
     */
    public int bestTiming(int[] prices) {
        int result = 0;
        int min = Integer.MAX_VALUE;

        for (int price: prices) {
            min = Math.min(min, price);
            result = Math.max(result, price - min);
        }

        return result;
    }
}
