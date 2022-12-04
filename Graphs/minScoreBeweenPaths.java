//https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/

class Solution {
    HashMap<Integer, List<Integer>> graph;
    HashSet<Integer> visited;
    HashMap<Integer, Integer> min;
    int ans =Integer.MAX_VALUE;
    
    private void buildGraph(int n, int[][] roads){
        for(int i=1; i<=n; i++){
            graph.put(i, new ArrayList<>());
            min.put(i, Integer.MAX_VALUE);
        }
        
        for(int[] road: roads){
            int r1 = road[0];
            int r2 = road[1];
            int distance = road[2];
            
            graph.get(r1).add(r2);
            graph.get(r2).add(r1);
            
            min.put(r1, Math.min(distance, min.get(r1)));
            min.put(r2, Math.min(distance, min.get(r2)));
        }
    }
    
    public int minScore(int n, int[][] roads) {
        graph = new HashMap<>();
        visited = new HashSet<>();
        min = new HashMap<>();
        
        buildGraph(n, roads);
        dfs(1);
        
        return ans;
    }
    
    private void dfs(int curr){
        visited.add(curr);
        List<Integer> neighbour = graph.get(curr);
        
        for(int i=0; i <neighbour.size(); i++){
            int road = neighbour.get(i);
            if(!visited.contains(road)){
                ans = Math.min(ans, min.get(road));
                dfs(road);
            }
        }
    }
}
