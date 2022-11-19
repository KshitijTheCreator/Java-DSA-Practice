//Generating possible subsets of the given array..
// METHOD 1: Using bit manipulation

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i< (1 << n); i++){
            
            List<Integer> list = new ArrayList<>();    
            
            for(int j=0; j< n; j++){
                if(((i >> j) & 1) == 1){
                    list.add(nums[j]);        
                }
            }
            ans.add(list);
        }
        return ans;
    }
}

//METHOD 2: Using Backtracking approach

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> container = new ArrayList<>();
        backtrack(nums, 0, ans, container);
        return ans;
    }
    private void backtrack(int[] nums, int index, List<List<Integer>> ans, List<Integer> container){
        ans.add(new ArrayList<>(container));
        
        for(int i = index; i < nums.length; i++){
            container.add(nums[i]);
            backtrack(nums, i+1, ans, container);
            container.remove(container.size()-1);
        }
    }
}
