package num;

public class 最长上传前缀 {

    /**
     * 给你一个 n 个视频的上传序列，每个视频编号为 1 到 n 之间的 不同 数字，你需要依次将这些视频上传到服务器。请你实现一个数据结构，在上传的过程中计算 最长上传前缀 。
     *
     * 如果 闭区间 1 到 i 之间的视频全部都已经被上传到服务器，那么我们称 i 是上传前缀。最长上传前缀指的是符合定义的 i 中的 最大值 。
     *
     * 请你实现 LUPrefix 类：
     *
     * LUPrefix(int n) 初始化一个 n 个视频的流对象。
     * void upload(int video) 上传 video 到服务器。
     * int longest() 返回上述定义的 最长上传前缀 的长度。
     *
     *
     * 示例 1：
     *
     * 输入：
     * ["LUPrefix", "upload", "longest", "upload", "longest", "upload", "longest"]
     * [[4], [3], [], [1], [], [2], []]
     * 输出：
     * [null, null, 0, null, 1, null, 3]
     *
     * 解释：
     * LUPrefix server = new LUPrefix(4);   // 初始化 4个视频的上传流
     * server.upload(3);                    // 上传视频 3 。
     * server.longest();                    // 由于视频 1 还没有被上传，最长上传前缀是 0 。
     * server.upload(1);                    // 上传视频 1 。
     * server.longest();                    // 前缀 [1] 是最长上传前缀，所以我们返回 1 。
     * server.upload(2);                    // 上传视频 2 。
     * server.longest();                    // 前缀 [1,2,3] 是最长上传前缀，所以我们返回 3 。
     *
     *
     * 提示：
     *
     * 1 <= n <= 105
     * 1 <= video <= 105
     * video 中所有值 互不相同 。
     * upload 和 longest 总调用 次数至多不超过 2 * 105 次。
     * 至少会调用 longest 一次。
     */

    private int[] num;

    private int currentNum;

    public 最长上传前缀(int n) {
        num = new int[n + 1];

        currentNum = 1;
    }

    public void upload(int video) {
        num[video] = 1;

        while (currentNum <= num.length - 1 && num[currentNum] == 1) {
            ++currentNum;
        }
    }

    public int longest() {
        return currentNum - 1;
    }


    // 树状数组  + 二分
    class BinaryIndexTree {
        int[] num;

        int n;

        public BinaryIndexTree(int n) {
            num = new int[n + 1];
            this.n = n;
        }

        public int lowbit(int x) {
            return x & (-x);
        }

        public void add(int x, int delta) {
            while (x <= n) {
                num[x] += delta;
                x += lowbit(x);
            }
        }

        public int query(int x) {
            int res = 0;
            while (x > 0) {
                res += num[x];
                x -= lowbit(x);
            }

            return res;
        }
    }

    private BinaryIndexTree tree;

    private int len;

//    public LUPrefix2(int n) {
//        tree = new BinaryIndexTree(n);
//
//        len = n;
//    }

    public void upload2(int video) {
        tree.add(video, 1);
    }

    public int longest2() {
        int left = 0, right = len;

        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 可行解，向右查询更高的地方还有没有可行解
            if (tree.query(mid) == mid) {
                result = mid;

                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return result;
    }
}
