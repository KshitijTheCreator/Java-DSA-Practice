//https://leetcode.com/contest/biweekly-contest-36/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> ans = new ArrayList<>();
        
        HashMap<String, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i< keyName.length; i++){
            String name =keyName[i];
            map.put(name, map.getOrDefault(name, new ArrayList<>()));
            map.get(name).add(getTime(keyTime[i]));
        }
        
        for(String k : map.keySet()){
            List<Integer> l = map.get(k);
            Collections.sort(l);
                for(int i=2; i<l.size(); i++){
                    if(l.get(i) - l.get(i-2) <= 60){
                    ans.add(k);
                    break;
                }   
            }
        }
        Collections.sort(ans);
        return ans;
    }
    int getTime(String s){
        int index = s.indexOf(":");
        int hour = Integer.parseInt(s.substring(0, index));
        int min = Integer.parseInt(s.substring(index+1));
        
        return (hour*60)+min;
    }
}
