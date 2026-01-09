class Solution {
    class Pair {
        TreeNode node;
        int depth;
        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return getLCA(root).node;
    }

    private Pair getLCA(TreeNode node) {
        if (node == null) return new Pair(null, 0);

        Pair left = getLCA(node.left);
        Pair right = getLCA(node.right);

        if (left.depth > right.depth) {
            return new Pair(left.node, left.depth + 1);
        }
        
        if (right.depth > left.depth) {
            return new Pair(right.node, right.depth + 1);
        }

        return new Pair(node, left.depth + 1);
    }
}