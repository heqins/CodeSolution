package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最长连续序列_2 {

    /**
     * 题目：输入一个无序的整数数组，请计算最长的连续数值序列
     * 的长度。例如，输入数组[10，5，9，2，4，3]，则最长的连续数值
     * 序列是[2，3，4，5]，因此输出4。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {10, 5, 9, 2, 4, 3};
        System.out.println(solve(nums));
    }

    public static int solve(int[] nums) {
        Map<Integer, Integer> fathers = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        Set<Integer> all = new HashSet<>();
        for (int num: nums) {
            all.add(num);
            fathers.put(num, num);
            counts.put(num, 1);
        }

        for (int num: nums) {
            if (all.contains(num - 1)) {
                union(fathers, counts, num, num - 1);
            }

            if (all.contains(num + 1)) {
                union(fathers, counts, num, num + 1);
            }
        }

        int result = 0;
        for (int num: all) {
            result = Math.max(result, counts.getOrDefault(num, 0));
        }

        return result;
    }

    public static void union(Map<Integer, Integer> fathers, Map<Integer, Integer> counts, int i, int y) {
        int fatherOfI = findFathers(fathers, i);
        int fatherOfJ = findFathers(fathers, y);

        if (fatherOfI != fatherOfJ) {
            int countI = counts.getOrDefault(fatherOfI, 0);
            int countJ = counts.getOrDefault(fatherOfJ, 0);

            fathers.put(fatherOfI, fatherOfJ);
            // 需要更新父节点的长度为合并后两个子树的长度
            counts.put(fatherOfJ, countI + countJ);
        }
    }

    public static int findFathers(Map<Integer, Integer> fathers, int i) {
        if (fathers.get(i) != i) {
            fathers.put(i, findFathers(fathers, fathers.get(i)));
        }

        return fathers.get(i);
    }
}
