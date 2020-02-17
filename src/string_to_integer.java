class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0 || str == null) {
            return 0;
        }
        
        int num = 0;
        boolean negativeFalse = false;
        int i = 0;
        char[] input = str.toCharArray();
        
        while (i < input.length && input[i] == ' ') {
            i++;
        }
        
        if (i == input.length) {
            return 0;
        }else if (input[i] == '+') {
            i++;
        }else if (input[i] == '-') {
            i++;
            negativeFalse = true;
        }
        
        while (i < input.length && input[i] <= '9' && input[i] >= '0') {
            int temp = input[i] - '0';
            temp = negativeFalse ? -temp:temp;
            
            if (num == 0 && temp == 0) {
                i++;
            } else if (num == Integer.MIN_VALUE / 10 && temp <= -8 || num < Integer.MIN_VALUE / 10) {
                return Integer.MIN_VALUE;
            } else if (num == Integer.MAX_VALUE / 10 && temp >= 7 || num > Integer.MAX_VALUE / 10) {
                return Integer.MAX_VALUE;
            } else {
                num = num * 10 + temp;
                i++;
            }
        }
        return num;
    }
}
