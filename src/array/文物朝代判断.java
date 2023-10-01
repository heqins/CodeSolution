package array;

import java.util.HashSet;
import java.util.Set;

public class 文物朝代判断 {

    /**
     * 展览馆展出来自 13 个朝代的文物，每排展柜展出 5 个文物。某排文物的摆放情况记录于数组 place
     * ，其中 place[i] 表示处于第 i 位文物的所属朝代编号。
     * 其中，编号为 0 的朝代表示未知朝代。请判断并返回这排文物的所属朝代编号是否连续（如遇未知朝代可算作连续情况）。
     */

    // 顺子
    // 先看下题目给的示例：[0,0,1,2,5]，为什么这个能够成顺子，因为0代表大小王，可以当作顺子中的任何一个缺少的数字

    public boolean checkDynasty(int[] place) {
        Set<Integer> set = new HashSet();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num: place) {
            if (num == 0) {
                continue;
            }

            max = Math.max(num, max);
            min = Math.min(num, min);

            if (max - min >= 5) {
                return false;
            }

            if (set.contains(num)) {
                return false;
            }

            set.add(num);
        }

        return true;
    }
}
