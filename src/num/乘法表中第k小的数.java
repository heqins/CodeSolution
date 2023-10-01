package num;

import java.util.Arrays;

public class 乘法表中第k小的数 {

    /**
     * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第 k 小的数字吗？
     *
     * 乘法表是大小为 m x n 的一个整数矩阵，其中 mat[i][j] == i * j（下标从 1 开始）。
     *
     * 给你三个整数 m、n 和 k，请你在大小为 m x n 的乘法表中，找出并返回第 k 小的数字。
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0],right = matrix[n-1][n-1];
        System.out.println(Arrays.deepToString(matrix)+",k = "+k+",left = "+left+" right = "+right);
        while(left < right){//最终左右相等，则设定边界可取
            int mid = (left + right)/2;
            int cnt = count(matrix,n,mid);
            if(cnt >= k) right = mid ;//mid >= target，则mid作为右边界(包括)
            else  left = mid + 1;//mid < target，则mid + 1作为右边界(可能包括)
            //最后一步当right - left = 1时，计算出mid = left
            //那么下一步的边界取值会有两种情况：(left，mid)；(mid+1，right)
            //左右边界都是相等的，跳出循环
            System.out.println("当前数字 = "+ mid +",小于等于它的数字数量 = "+cnt+",left = "+left+",right = "+right);
        }
        return left;
    }

    public static int count(int[][] matrix, int n, int mid) {
        int i = n - 1;
        int ans = 0;
        for(int j = 0; j < n;j++){
            if(i < 0) break;
            while(matrix[i][j] > mid){
                i--;
                if(i < 0) break;
            }
            ans += i+1;
        }
        return ans;
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = count(matrix, n, mid);
            if (count >= k) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    public int count2(int[][] matrix, int n, int mid) {
        int count = 0;
        int i = n - 1;

        for (int j = 0; j < n; j++) {
            if (i < 0) {
                break;
            }

            while (matrix[i][j] > mid) {
                i--;
                if (i < 0) {
                    break;
                }
            }

            count += i + 1;
        }

        return count;
    }

    public int findKthNumber(int m, int n, int k) {
        int left = 0;

        // 注意右端点不是m * n - 1
        int right = m * n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = count(mid, m, n);
            // 这个设计是为了确保最终的二分搜索结果是第 k 小的数字，而不是第 k + 1 小的数字。让我解释一下：
            //当 count < k 时，这意味着不大于 mid 的数字数量不足 k 个，我们需要搜索的数字在更大的一侧。
            // 因此，将 left 更新为 mid + 1，排除了当前 mid，并将搜索范围限制在右半部分。
            //当 count >= k 时，这意味着不大于 mid 的数字数量至少为 k 个，
            // 我们需要继续搜索左半部分以找到确切的第 k 小的数字。因此，将 right 更新为 mid，
            // 保留了当前 mid 并继续搜索左侧。
            if (cnt < k) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left;
    }

    public int count(int x, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int temp = Math.min(n, x / i);
            count += temp;
        }

        return count;
    }
}
