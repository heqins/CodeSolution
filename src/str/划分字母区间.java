package str;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 划分字母区间 {

    /**
     * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
     *
     * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
     *
     * 返回一个表示每个字符串片段的长度的列表。
     */
    public List<Integer> partitionLabels(String s) {
        // strs数组存储的是每个字母的最大位置索引下标，当最大位置索引下标和当前下标相等时，代表可以进行分隔
        int[] strs = new int[26];
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            strs[chs[i] - 'a'] = i;
        }

        // 使用pre指针记录区间左边
        int pre = -1;
        int index = 0;

        List<Integer> result = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            index = Math.max(index, strs[chs[i] - 'a']);
            if (index == i) {
                result.add(i - pre);
                pre = i;
            }
        }

        return result;
    }
}
