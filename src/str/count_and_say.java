/**
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.

Note: Each term of the sequence of integers will be represented as a string.

 

Example 1:

Input: 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: 4
Output: "1211"
Explanation: For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12" which means frequency = 1 and value = 2, the same way "1" is read as "11", so the answer is the concatenation of "12" and "11" which is "1211".

**/

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
