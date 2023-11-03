package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 破解闯关密码 {

    /**
     * 闯关游戏需要破解一组密码，闯关组给出的有关密码的线索是：
     *
     * 一个拥有密码所有元素的非负整数数组 password
     * 密码是 password 中所有元素拼接后得到的最小的一个数
     * 请编写一个程序返回这个密码。
     */
    public String crackPassword(int[] password) {
        List<String> list = new ArrayList();

        for (int num: password) {
            list.add(String.valueOf(num));
        }

        // 自定义排序器
        Collections.sort(list, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        StringBuilder sb = new StringBuilder();
        for (String str: list) {
            sb.append(str);
        }

        return sb.toString();
    }
}
