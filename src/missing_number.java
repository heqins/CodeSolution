public class missing_number {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumS = (n + 1) * n / 2;
        int sum = 0;
        for(int i: nums) {
            sum += i;
        }
        return sumS - sum;
    }

    public static void main(String[] args) {
        int[] test = new int[]{0 ,3 ,1 ,2 ,4, 5};
        missing_number mn = new missing_number();
        System.out.println(mn.missingNumber(test));
    }
}
