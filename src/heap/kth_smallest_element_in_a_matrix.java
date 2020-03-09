/**
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.
**/

public int kthSmallest(int[][] matrix, int k) {
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
	for (int[] row : matrix) {
		for (int cell : row) {
			maxHeap.add(cell);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
	}
	return maxHeap.poll();
}


