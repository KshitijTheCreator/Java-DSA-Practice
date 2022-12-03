// https://leetcode.com/problems/sort-characters-by-frequency/
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c: s.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0) +1);
        }
        
       
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) ->hm.get(b) - hm.get(a));
        maxHeap.addAll(hm.keySet());
        
        StringBuilder result = new StringBuilder();
        
        while(!maxHeap.isEmpty()){
            char current = maxHeap.poll();
            for(int i=0; i< hm.get(current); i++){
                result.append(current);
            }
        }
        return result.toString();
    }
