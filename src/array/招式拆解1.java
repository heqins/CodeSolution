package array;

import java.util.HashMap;
import java.util.Map;

public class 招式拆解1 {

    /**
     * 某套连招动作记作序列 arr，其中 arr[i] 为第 i 个招式的名字。请返回 arr 中最多可以出连续不重复的多少个招式。
     * 输入: arr = "dbascDdad"
     * 输出: 6
     * 解释: 因为连续且最长的招式序列是 "dbascD" 或 "bascDd"，所以其长度为 6。
     */
    public int dismantlingAction(String arr) {
        if (arr.length() == 0) {
            return 0;
        }

        int left = -1;
        Map<Character, Integer> map = new HashMap();

        int result = -1;

        for (int i = 0; i < arr.length(); i++) {
            // 双指针，维护左指针，如果有出现重复元素则更新
            if (map.containsKey(arr.charAt(i))) {
                left = Math.max(left, map.get(arr.charAt(i)));
            }

            map.put(arr.charAt(i), i);

            // 每次更新左右指针区间长度
            result = Math.max(result, i - left);
        }

        return result;
    }
}
