package greedy;

public class 分发糖果 {

    /**
     * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
     *
     * 你需要按照以下要求，给这些孩子分发糖果：
     *
     * 每个孩子至少分配到 1 个糖果。
     * 相邻两个孩子评分更高的孩子会获得更多的糖果。
     * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
     * @param args
     */
    public static void main(String[] args) {
        int[] ratings = new int[]{1, 2, 2};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        // 贪心算法，所有孩子初始化1个糖果
        int[] candy = new int[ratings.length];
        for (int i = 0; i < candy.length; i++) {
            candy[i] = 1;
        }

        for (int i = 1; i < ratings.length; i++) {
            // 每次和左边的孩子对比，如果比左边的孩子得分高，则分到的糖果+1
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            // 每次和右边的孩子对比，如果比右边的孩子得分高，则比较右边的糖果数+1和当前的糖果数，取最大值
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }

        int result = 0;
        for (int num: candy) {
            result += num;
        }

        return result;
    }
}
