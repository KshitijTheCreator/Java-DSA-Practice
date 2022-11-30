//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long[] prefixSum= new long[nums.length+1];
        int sum =0;
        int window = Integer.MAX_VALUE;
        Deque<Integer> dq = new LinkedList<>();

        for(int i=0; i< nums.length; i++){
            prefixSum[i+1] = prefixSum[i]+ nums[i];
        }

        for(int i=0; i< nums.length +1; i++){
            while(dq.size() > 0 && prefixSum[i] - prefixSum[dq.getFirst()] >= k){ // a possible answer
                int idx = dq.pollFirst();
                window = Math.min(window, i- idx);
            }
            while(dq.size() >0 && prefixSum[i] <= prefixSum[dq.getLast()]){ // possibility of shrinking the window
                dq.pollLast();
            }
            dq.add(i);
        }
        return window == Integer.MAX_VALUE ? -1 : window;
    }
}
