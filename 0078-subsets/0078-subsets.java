class Solution {
    List<List<Integer>> res=new ArrayList<>();
    void backtrack(int nums[],int k,int n,List<Integer> temp){
        if(k==n){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[k]);
        backtrack(nums,k+1,n,temp);
        temp.remove(temp.size()-1);
        backtrack(nums,k+1,n,temp);
    }

    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        backtrack(nums,0,n,new ArrayList<>());
        return res;
    }
}