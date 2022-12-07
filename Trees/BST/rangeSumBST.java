// https://leetcode.com/problems/range-sum-of-bst/
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        int sum =0;
        if(root.val > low){
            sum += rangeSumBST(root.left, low, high);
        }
        if(root.val < high){
            sum += rangeSumBST(root.right, low, high);
        }
        if(root.val <= high && root.val >= low){
            sum += root.val;
        }
        return sum;
    }
}
