/**
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
**/

/**
这道二叉树的之字形层序遍历是之前那道 Binary Tree Level Order Traversal 的变形，不同之处在于一行是从左到右遍历，

下一行是从右往左遍历，交叉往返的之字形的层序遍历。最简单直接的方法就是利用层序遍历，并使用一个变量 cnt 来统计当前的层数（从0开始），

将所有的奇数层的结点值进行翻转一下即可，参见代码如下：

**/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                temp.add(cur.val);
            }
            if (count % 2 != 0) Collections.reverse(temp);
            count++;
            res.add(temp);
        }
        
        return res;
    }
}


/**
复杂度分析：

    时间复杂度 O(N)O(N)O(N) ： NNN 为二叉树的节点数量，即 BFS 需循环 NNN 次，占用 O(N)O(N)O(N) ；双端队列的队首和队尾的添加和删除操作的时间复杂度均为 O(1)O(1)O(1) 。
    空间复杂度 O(N)O(N)O(N) ： 最差情况下，即当树为满二叉树时，最多有 N/2N/2N/2 个树节点 同时 在 deque 中，使用 O(N)O(N)O(N) 大小的额外空间。

打印： 若为奇数层，将 node.val 添加至 tmp 尾部；否则，添加至 tmp 头部；

代码：

    Python 中使用 collections 中的双端队列 deque() ，其 popleft() 方法可达到 O(1)O(1)O(1) 时间复杂度；列表 list 的 pop(0) 方法时间复杂度为 O(N)O(N)O(N) 。
    Java 中将链表 LinkedList 作为双端队列使用。
**/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}

作者：jyd
链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/solution/mian-shi-ti-32-iii-cong-shang-dao-xia-da-yin-er--3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

