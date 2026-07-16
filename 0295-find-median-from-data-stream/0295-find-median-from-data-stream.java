class MedianFinder {
    PriorityQueue<Integer> minHeap,maxHeap;
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty()){
            maxHeap.add(num);
            return;
        }
        else{
            if(num<maxHeap.peek())
                maxHeap.add(num);
            else
                minHeap.add(num);
        }
        if(minHeap.size()-1>maxHeap.size())
            maxHeap.add(minHeap.poll());
        else if(maxHeap.size()-1>minHeap.size())
            minHeap.add(maxHeap.poll());
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size())
            return (double)((minHeap.peek()+maxHeap.peek())/2.0);
        return (minHeap.size()>maxHeap.size())?minHeap.peek():maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */