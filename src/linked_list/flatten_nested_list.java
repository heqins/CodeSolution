/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }

 *因为有递归， 但是如果每次遇到List的时候，都先保存后面的， 那么读的时候就可以先读前面的， 而且，再遇到list的时候， 也可以同样的方式展开， 继续push到stack里 
 *面，这样就可以符合顺序取出来。
 */
public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> s;
    public NestedIterator(List<NestedInteger> nestedList) {
        s = new Stack<>();
        flatten(s, nestedList);
    }

    @Override
    public Integer next() {
        return hasNext()?s.pop().getInteger():null;
    }

    @Override
    public boolean hasNext() {
        while (!s.isEmpty()) {
            if (s.peek().isInteger()) {
                return true;
            }
            
            flatten(s, s.pop().getList());
        }
        return false;
    }
    
    public void flatten(Stack<NestedInteger> s, List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            s.push(nestedList.get(i));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
