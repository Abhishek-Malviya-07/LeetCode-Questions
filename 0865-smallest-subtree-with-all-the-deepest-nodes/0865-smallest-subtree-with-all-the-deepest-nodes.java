class Solution {
    // A simple class to hold two pieces of information
    class Result {
        TreeNode node;
        int dist;
        Result(TreeNode n, int d) {
            node = n;
            dist = d;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).node;
    }

    private Result helper(TreeNode node) {
        if (node == null) return new Result(null, 0);

        Result left = helper(node.left);
        Result right = helper(node.right);

        // If left side is deeper, pass the left result up
        if (left.dist > right.dist) {
            return new Result(left.node, left.dist + 1);
        }
        
        // If right side is deeper, pass the right result up
        if (right.dist > left.dist) {
            return new Result(right.node, right.dist + 1);
        }

        // If they are equal, the current node is the common ancestor
        return new Result(node, left.dist + 1);
    }
}