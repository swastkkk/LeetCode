class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int pos=k%(m*n);
        int arr[]=new int[m*n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[(n*i+j+pos)%(m*n)]=grid[i][j];
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<m;i++){
            res.add(new ArrayList<>());
            for(int j=0;j<n;j++){
                res.get(i).add(arr[n*i+j]);
            }
        }
        return res;

    }
}