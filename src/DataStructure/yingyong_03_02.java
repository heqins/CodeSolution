package DataStructure;

import java.util.Arrays;
import java.util.HashMap;

public class yingyong_03_02 {
    public static void frequency(String str) {
        HashMap<Character, Integer> m = new HashMap<>();
        for (char c: str.toCharArray()) {
            if(!m.containsKey(c)) {
                m.put(c, 1);
            }else {
                m.put(c, m.get(c) + 1);
            }
        }

        System.out.println(m.toString());
    }

    public static void main(String[] args) {
        String test = new String("Hello World! I'm your nightmare.");
        frequency(test);
    }
}
