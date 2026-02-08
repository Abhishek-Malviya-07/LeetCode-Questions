class Solution {
    public boolean isBalanced(TreeNode root) {
        // If checkHeight returns -1, it means the tree is unbalanced
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1; // Left subtree is already unbalanced

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1; // Right subtree is already unbalanced

        // Check if current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}