import java.util.HashSet;
import java.util.Set;

public class contains_duplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 4, 4};
        contains_duplicate cd = new contains_duplicate();
        System.out.println(cd.containsDuplicate(test));
    }
}
