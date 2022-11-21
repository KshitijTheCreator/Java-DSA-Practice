//https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 int sum =0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        convertBST(root.right);
        sum += root.val;
        root.val =sum;
        convertBST(root.left);
        
        return root;
    }
