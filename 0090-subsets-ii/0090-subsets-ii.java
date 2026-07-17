class Solution {
    void backtrack(int nums[],int k,Set<List<Integer>> res,List<Integer> temp){
        if(k==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[k]);
        backtrack(nums,k+1,res,temp);
        temp.remove(temp.size()-1);
        backtrack(nums,k+1,res,temp);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res=new HashSet<>();
        backtrack(nums,0,res,new ArrayList<>());
        return new ArrayList<>(res);
    }
}