import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路: 遇到这种问题，很显然，第一个想法我们首先回去想到DFS,递归求解，对于数组中的每一个元素，
 * 找到以他为首节点的Permutations,这就要求在递归中，每次都要从数组的第一个元素开始遍历，
 * 这样，就引入了另外一个问题，我们会对于同一元素访问多次，这就不是我们想要的答案了，所以我们引入了一个bool类型的数组，
 * 用来记录哪个元素被遍历了(通过下标找出对应).在对于每一个Permutation进行求解中，
 * 如果访问了这个元素,我们将它对应下表的bool数组中的值置为true,访问结束后，我们再置为false.
 */

public class permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, List<Integer> temp, boolean[] isUsed) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                temp.add(nums[i]);
                isUsed[i] = true;
                dfs(res, nums, temp, isUsed);
                temp.remove(temp.size() - 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        permutations p = new permutations();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(p.permute(nums));
    }
}
