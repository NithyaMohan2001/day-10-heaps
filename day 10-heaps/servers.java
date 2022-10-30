class Solution {

public int[] assignTasks(int[] servers, int[] tasks) {
    int m=servers.length;
    int n=tasks.length;
    int counter=0;
    PriorityQueue<int[]> freeQ=new PriorityQueue<>((a, b) -> (a[0]==b[0])?a[1]-b[1]:a[0]-b[0]);
    PriorityQueue<int[]> busyQ=new PriorityQueue<>((a, b) -> a[2]-b[2]);
    for(int i=0;i<m;i++){
        freeQ.offer(new int[]{servers[i], i});
    }
    int []ans=new int[n];
    Queue<Integer> taskQ=new LinkedList();
    while(!taskQ.isEmpty() || counter<n){
        if(counter<n)
            taskQ.offer(counter);
        while(!busyQ.isEmpty() && busyQ.peek()[2]==counter){
            int[] top = busyQ.poll();
            freeQ.offer(new int[]{top[0], top[1]});
        }
        while(!freeQ.isEmpty() && !taskQ.isEmpty()){
               int task= taskQ.poll();
            int[] busy = freeQ.poll();
            ans[task]=busy[1];
            int val=counter+tasks[task];
            busyQ.offer(new int[]{busy[0], busy[1], val});
        }
        // dont waste time on doing counter++, directly jump onto the next time when a server becomes available.
        if(freeQ.isEmpty() && counter>n){
            counter=busyQ.peek()[2];
        }
        else
            counter++;
    }
    return ans;