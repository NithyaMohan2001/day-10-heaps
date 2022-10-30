class MedianFinder {
    Queue<Integer> maxheap=new PriorityQueue<>((a,b)->b-a);
    Queue<Integer> minheap=new PriorityQueue<>();
    
    int size=0;
    public MedianFinder() {
        
    }

    public void addNum(int num) {
        size++;
        
        if(maxheap.isEmpty() || num <=maxheap.peek()){
            maxheap.add(num);
        }else{
            minheap.add(num);
        }
        
        if(minheap.size()+1<maxheap.size()){
            Integer element=maxheap.poll();
            minheap.add(element);
        }else if(maxheap.size() <minheap.size()){
            Integer element=minheap.poll();
            maxheap.add(element);
        }
    }
    
    public double findMedian() {
        if(size%2!=0)return (double)maxheap.peek();
        
        return(maxheap.peek()+minheap.peek())/2.0;
    }
}
