public class single_number {
    public int singleNumber(int[] nums) {
        // 异或： 相当于整个序列为0 ^ single number
        int result = 0;
        for (int num : nums) {
            result = result ^ num; // ^ is XOR operator
            System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2, 2, 3, 3, 4, 4, 5};
        single_number sn = new single_number();
        System.out.println(sn.singleNumber(test));
//        System.out.println(4 ^ 4);
    }
}
