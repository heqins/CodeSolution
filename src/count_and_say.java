public class count_and_say {
    public static String countAndSay(int n) {
        /**
         * 题意是n=1时输出字符串1；n=2时，数上次字符串中的数值个数，因为上次字符串有1个1，
         * 所以输出11；n=3时，由于上次字符是11，有2个1，所以输出21；n=4时，由于上次字符串是21，有1个2和1个1，所以输出1211
         */
        StringBuilder curr=new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i=1;i<n;i++){
            prev=curr;
            curr=new StringBuilder();
            count=1;
            say=prev.charAt(0);

            for (int j=1,len=prev.length();j<len;j++){
                if (prev.charAt(j)!=say){
                    curr.append(count).append(say);
                    count=1;
                    say=prev.charAt(j);
                }
                else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();
    }

    public static String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        }
        char[] re = countAndSay2(n - 1).toCharArray();
        int count = 0;
        char cur = re[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < re.length; i++) {
            if (cur != re[i]) {
                sb.append(count);
                sb.append(cur);
                cur = re[i];
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count > 0 ? count + String.valueOf(cur) : "");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay2(3));
    }
}
