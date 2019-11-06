import java.util.Stack;

public class trapping_rain_water {
    public static int trap(int[] A) {
        Stack<Integer> stack = new Stack<Integer>();
        int sum = 0;
        int pre = 0;
        int i = -1;
        while(++i < A.length){
            if(A[i]==0){pre = 0;continue;}
            while(!stack.isEmpty() && A[i] >= A[stack.peek()]){
                // pre??????
                sum += (A[stack.peek()] - pre) * (i-stack.peek()-1);
                pre = A[stack.pop()];
            }
            if(!stack.isEmpty()){
                sum += (A[i] - pre) * (i-stack.peek()-1);
                pre = A[i];
            }
            stack.push(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(A));
    }
}
