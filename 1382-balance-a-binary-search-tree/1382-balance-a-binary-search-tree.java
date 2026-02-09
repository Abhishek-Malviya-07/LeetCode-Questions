class Solution {
    public TreeNode balanceBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        dummy.right = root;
        
        // Step 1: Create the Vine
        int count = createVine(dummy);
        
        // Step 2: Compress the Vine into a balanced tree
        compress(dummy, count);
        
        return dummy.right;
    }

    private int createVine(TreeNode root) {
        int count = 0;
        TreeNode curr = root.right;
        TreeNode parent = root;
        
        while (curr != null) {
            if (curr.left != null) {
                // Right Rotation
                TreeNode leftChild = curr.left;
                curr.left = leftChild.right;
                leftChild.right = curr;
                parent.right = leftChild;
                curr = leftChild;
            } else {
                // Move down the vine
                count++;
                parent = curr;
                curr = curr.right;
            }
        }
        return count;
    }

    private void compress(TreeNode root, int count) {
        // Calculate nodes in the bottom-most level
        int m = (int) Math.pow(2, (int) (Math.log(count + 1) / Math.log(2))) - 1;
        
        // Initial rotations for the "extra" nodes
        performRotations(root, count - m);
        
        // Successive passes to balance the remaining tree
        while (m > 1) {
            m /= 2;
            performRotations(root, m);
        }
    }

    private void performRotations(TreeNode root, int k) {
        TreeNode curr = root.right;
        TreeNode parent = root;
        for (int i = 0; i < k; i++) {
            // Left Rotation
            TreeNode rightChild = curr.right;
            curr.right = rightChild.left;
            rightChild.left = curr;
            parent.right = rightChild;
            
            parent = rightChild;
            curr = parent.right;
        }
    }
}