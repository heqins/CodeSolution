package array;

import java.util.Arrays;

public class 字节跳动_生成数字 {

    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) {
        System.out.println(chooseSort(new int[]{2, 4, 5, 9}, 2451));
    }

    public static int chooseSort(int[] num, int target) {
        Arrays.sort(num);

        int targetTime = 0;
        int temp = target;

        while(temp != 0){
            temp /= 10;

            targetTime++;
        }

        dfs(num, 0, target, targetTime, 0);

        return ans;

    }

    public static void dfs(int[]num, int res, int target, int targetTime, int curTime){
        if(curTime >= targetTime){
            return;
        }

        for(int i = 0; i < num.length; i++){
            res = res * 10 + num[i];

            curTime++;

            if (res > target) {
                return;
            } else {
                ans = Math.max(ans, res);
            }

            dfs(num, res, target, targetTime, curTime);

            res /= 10;

            curTime--;

        }


    }

}
