public class jump_game {
    // greedy algorithm
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        jump_game jg = new jump_game();
        System.out.println(jg.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
