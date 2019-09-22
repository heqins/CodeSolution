public class reverse_bits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // 最简单的做法，原数不断右移取出最低位，赋给新数的最低位后新数再不断左移。
        // i >>= 1 is just shorthand for i = i >> 1 in the same way that i += 4 is short for i = i + 4
        int res = 0;
        for(int i = 0; i < 32; i++, n >>= 1){
            res = res << 1 | (n & 1);
        }
        return res;
    }

    public static void main(String[] args) {
        reverse_bits rb = new reverse_bits();
        System.out.println(Integer.toBinaryString(rb.reverseBits(00111)));
    }
}
