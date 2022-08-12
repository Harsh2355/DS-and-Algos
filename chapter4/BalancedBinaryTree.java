//  Leetcode Problem : https://leetcode.com/problems/balanced-binary-tree/

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return checkBalanced(root) != -1;
    }
    
    public int checkBalanced(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        int leftSize = root.left == null ? 0 : checkBalanced(root.left);
        if (leftSize == -1) return -1;
        int rightSize = root.right == null ? 0 : checkBalanced(root.right);
        if (rightSize == -1) return -1;
        int diff = Math.abs(leftSize - rightSize);
        if (diff > 1) return -1;
        
        return 1 + Math.max(leftSize, rightSize);
    }
    
}