//https://leetcode.com/problems/cherry-pickup-ii/description/
class Solution {
    Integer[][][] dp;
    int rows;
    int cols;
    public int cherryPickup(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        //rows for current row.. one col for robot1 and other for robot2
        dp = new Integer[rows][cols][cols];
        
        return dfs(grid, 0, 0, cols -1);
    }
    private int dfs(int[][] grid, int r, int c1, int c2){
        if(r< 0 || r>= rows || c1 >=cols || c1<0 || c2 >= cols || c2 <0){
            return 0;
        }
        if(dp[r][c1][c2] != null){
            return dp[r][c1][c2];
        }
        
        //not with col on moving below each step we have 3 possibility:
        //  col =-1: move left down .. col = 0: move vertical down... col =1: move down right
        int maxCherry =0; //this is cherry picking for the further row
        for(int i=-1; i<= 1; i++){
            for(int j =-1; j<= 1; j++){
                int newCol1 = c1+i;
                int newCol2 = c2+j;
                maxCherry = Math.max(maxCherry, dfs(grid, r+1, newCol1, newCol2));
            }
        }
        int currCherry =0; //this is cherry picking for the current configuration
        if(c1 == c2){
            currCherry = grid[r][c1];
        }else{
            currCherry = grid[r][c1] + grid[r][c2];
        }
        
        dp[r][c1][c2] = currCherry + maxCherry;
        return dp[r][c1][c2];
        
    }
}
