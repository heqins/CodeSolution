public class number_of_1bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        /**
         * << 左移运算符，num << 1,相当于num乘以2
         *
         * >> 右移运算符，num >> 1,相当于num除以2
         *
         * >>> 无符号右移，忽略符号位，空位都以0补齐
         */
        int count = 0;
        for(int i=1; i<33; i++){
            if(getBit(n, i) == true){
                count++;
            }
        }
        return count;
    }

    public boolean getBit(int n, int i){
        return (n & (1 << i)) != 0;
    }

    public static void main(String[] args) {
        number_of_1bits nob = new number_of_1bits();
        System.out.println(nob.hammingWeight(00000000000000000000000000001011));
    }
}
