class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Character> maxheap=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        maxheap.addAll(map.keySet());
        StringBuilder res=new StringBuilder();
        while(!maxheap.isEmpty()){
            char ch=maxheap.remove();
            int count=map.get(ch);
            while(count!=0){
                res.append(ch);
                count--;
            }
        }
        return res.toString();
    }

}
