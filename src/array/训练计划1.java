package array;

public class 训练计划1 {

    /**
     * 教练使用整数数组 actions 记录一系列核心肌群训练项目编号。为增强训练趣味性，
     * 需要将所有奇数编号训练项目调整至偶数编号训练项目之前。请将调整后的训练项目编号以 数组 形式返回。
     */
    public int[] trainingPlan(int[] actions) {
        int start = 0;
        int end = actions.length - 1;

        while (start < end) {
            if (actions[start] % 2 == 0 && actions[end] % 2 != 0) {
                int temp = actions[start];
                actions[start] = actions[end];
                actions[end] = temp;

                start++;
            }else if (actions[start] % 2 != 0) {
                start++;
            }else if (actions[end] % 2 == 0) {
                end--;
            }else {
                start++;
                end--;
            }
        }

        return actions;
    }
}
