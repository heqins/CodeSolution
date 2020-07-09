题目地址（547. 朋友圈）

https://leetcode-cn.com/problems/friend-circles/
题目描述

班上有  N  名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B  的朋友，B 是 C  的朋友，那么我们可以认为 A 也是 C  的朋友。所谓的朋友圈，是指所有朋友的集合。

给定一个  N * N  的矩阵  M，表示班级中学生之间的朋友关系。如果 M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

示例 1:

输入: [[1,1,0], [1,1,0], [0,0,1]] 输出: 2 说明：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。 第 2 个学生自己在一个朋友圈。所以返回 2。 示例 2:

输入: [[1,1,0], [1,1,1], [0,1,1]] 输出: 1 说明：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1。 注意：

N 在[1,200]的范围内。 对于所有学生，有 M[i][i] = 1。 如果有 M[i][j] = 1，则有 M[j][i] = 1。
前置知识

    并查集

思路

并查集有一个功能是可以轻松计算出连通分量，然而本题的朋友圈的个数，本质上就是连通分量的个数，因此用并查集可以完美解决。

为了简单更加清晰，我将并查集模板代码单尽量独拿出来。
代码

find, union, connected 都是典型的模板方法。 懂的同学可能也发现了，我没有做路径压缩，这直接导致 find union connected 的时间复杂度最差的情况退化到 $O(N)$。

当然优化也不难，我们只需要给每一个顶层元素设置一个 size 用来表示连通分量的大小，这样 union 的时候我们将小的拼接到大的上即可。 另外 find 的时候我们甚至可以路径压缩，将树高限定到常数，这样时间复杂度可以降低到 $O(1)$。

class UF:
    parent = {}
    cnt = 0
    def __init__(self, M):
        n = len(M)
        for i in range(n):
            self.parent[i] = i
            self.cnt += 1

    def find(self, x):
        while x != self.parent[x]:
            x = self.parent[x]
        return x
    def union(self, p, q):
        if self.connected(p, q): return
        self.parent[self.find(p)] = self.find(q)
        self.cnt -= 1
    def connected(self, p, q):
        return self.find(p) == self.find(q)

class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        n = len(M)
        uf = UF(M)
        for i in range(n):
            for j in range(i):
                if M[i][j] == 1:
                    uf.union(i, j)
        return uf.cnt

复杂度分析

    时间复杂度：平均 $O(logN)$，最坏的情况是 $O(N)$
    空间复杂度：我们使用了 parent， 因此空间复杂度为 $O(N)$
    
    
    
class UnionFind{
    private int[] parents;
    private int circleCount;
    
    public UnionFind(int n)
    {
        parents = new int[n];
        for (int i = 0; i < n; i++)
        {
            parents[i] = i;
        }
    }
    
    public int find(int x)
    {
        if (parents[x] == x)
        {
            return x;
        }
        
        return parents[x] = find(parents[x]);
    }
    
    public void union(int a, int b)
    {
        int groupA = find(a);
        int groupB = find(b);
        
        if (groupA != groupB)
        {
            parents[groupA] = groupB;
            circleCount--;
        }
    }
    
    public void setCircleCount(int circleCount)
    {
        this.circleCount = circleCount;
    }
    
    public int getCircleCount()
    {
        return this.circleCount;
    }
}

class Solution {
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0)
        {
            return 0;
        }
        
        int m = M.length;
        int n = M[0].length;
        
        UnionFind unionFind = new UnionFind(m * n);
        unionFind.setCircleCount(m);
        
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (M[i][j] == 1 && i != j)
                {
                    unionFind.union(i, j);
                }
            }
        }
        
        return unionFind.getCircleCount();
    }
}
