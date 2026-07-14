class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((b,a)->(a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]));
        
        for(int i=0;i<points.length;i++){
            pq.add(new int[]{points[i][0],points[i][1]});
            if(pq.size()>k)
                pq.poll();
        }
        int ans[][]=new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            ans[i++]=pq.poll();
        }
        return ans;
    }
}