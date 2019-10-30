import java.util.*;

public class binary_tree_zigzag_level_order_traversal {
    private Stack<TreeNode> leftStack = new Stack();
    private Stack<TreeNode> rightStack = new Stack();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        leftStack.push(root);

        List<List<Integer>> returnList = new ArrayList();
        if(root == null) {
            return returnList;
        }

        List<Integer> fList = new ArrayList();
        fList.add(root.val);
        returnList.add(fList);

        while(!leftStack.isEmpty() || !rightStack.isEmpty()) {

            List<Integer> lList = new ArrayList();
            while(!leftStack.isEmpty()) {
                TreeNode lNode = leftStack.pop();


                if(lNode.right != null) {
                    rightStack.push(lNode.right);
                    lList.add(lNode.right.val);
                }

                if(lNode.left != null) {
                    rightStack.push(lNode.left);
                    lList.add(lNode.left.val);
                }
            }

            if(!lList.isEmpty()) {
                returnList.add(lList);
            }

            List<Integer> rList = new ArrayList();
            while(!rightStack.isEmpty()) {
                TreeNode rNode = rightStack.pop();


                if(rNode.left != null) {
                    leftStack.push(rNode.left);
                    rList.add(rNode.left.val);
                }

                if(rNode.right != null) {
                    leftStack.push(rNode.right);
                    rList.add(rNode.right.val);
                }
            }

            if(!rList.isEmpty()) {
                returnList.add(rList);
            }
        }

        return returnList;
    }
}

