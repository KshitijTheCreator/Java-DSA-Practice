//https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/description/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> store;
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        store = new ArrayList<>();
        inorder(root);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i< queries.size(); i++){
            List<Integer> l = new ArrayList<>();
            int min = getMinQuery(queries.get(i));
            l.add(min);
            int max = getMaxQuery(queries.get(i));
            l.add(max);
            ans.add(l);
        }
        return ans;
    }
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        store.add(root.val);
        inorder(root.right);
    }
    private int getMinQuery(int val){
        int start =0, end =store.size()-1;
        int ans =-1;
      
        while(start <= end){
            int mid = start + (end -start)/2;
            if(store.get(mid) == val){
                return val;
            }
            if(store.get(mid) > val){
                end = mid-1;
            }
            else{
                ans = store.get(mid);
                start = mid+1;
            }
        }
        return ans;
    }
    private int getMaxQuery(int val){
        int start =0, end =store.size()-1;
        int ans =-1;
        
        while(start <= end){
            int mid = start + (end -start)/2;
            
            if(store.get(mid) < val){
                start = mid+1;
            }
            else{
                ans = store.get(mid);
                end = mid-1;
            }
        }
        return ans;
    }
}
