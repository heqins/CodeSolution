package Str;

import java.util.ArrayList;
import java.util.List;

public class fizz_buzz {
    public List<String> fizzBuzz(int n) {
        if (n == 0) {return null;}
        List<String> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0) {list.add("FizzBuzz");}
            else if (i % 5 == 0) {list.add("Buzz");}
            else if (i % 3 == 0) {list.add("Fizz");}
            else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }
}
