package num;

public class 统计目标成绩的出现次数 {

    /**
     * 某班级考试成绩按非严格递增顺序记录于整数数组 scores，请返回目标成绩 target 的出现次数。
     */
    public int countTarget(int[] scores, int target) {
        int count = 0;
        for (int num: scores) {
            if (num == target) {
                count++;
            }
        }

        return count;
    }

    // 使用二分法降低时间复杂度
    private int count = 0;
    public int countTarget2(int[] scores, int target) {
        helper(scores, target, 0, scores.length - 1);

        return count;
    }

    // 时间复杂度O(logn)
    public void helper(int[] scores, int target, int left, int right) {
        if (left <= right) {
            int mid = right + (left - right) / 2;
            if (scores[mid] == target) {
                count++;

                helper(scores, target, left, mid - 1);
                helper(scores, target, mid + 1, right);
            }else if (scores[mid] > target) {
                helper(scores, target, left, mid - 1);
            }else {
                helper(scores, target, mid + 1, right);
            }
        }
    }
}
