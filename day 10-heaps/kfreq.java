class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> bucket1=new HashMap<>();
        for(int num:nums){
            bucket1.put(num,bucket1.getOrDefault(num,0)+1);
        }
        
        Map<Integer,List<Integer>> bucket2=new HashMap<>();
        for(Integer num:bucket1.keySet()){
            Integer elefreq=bucket1.get(num);
            if(!bucket2.containsKey(elefreq)){
                bucket2.put(elefreq,new ArrayList<>());
            }
            bucket2.get(elefreq).add(num);
        }
        
        int[] res=new int[k];
        for(int n=nums.length;n>0;n--){
            if(bucket2.containsKey(n)){
                List<Integer> list=bucket2.get(n);
                for(Integer integer:list){
                    res[--k]=integer;
                    if(k==0)
                        return res;
                }
            }
        }
        return res;
    }
}
