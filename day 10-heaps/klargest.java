class KthLargest {
    PriorityQueue<Integer> minheap;
    
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        minheap=new PriorityQueue<>();
        for(int el:nums){
            add(el);
        }
    }
    
    public int add(int val) {
        minheap.add(val);
        if(minheap.size()>k){
            minheap.poll();
        }
        return minheap.peek();
    }
}
