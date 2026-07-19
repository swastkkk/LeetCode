class Solution {
    void permutations(int nums[],int i,List<Integer> curr,Set<List<Integer>> res){
        if(i>=nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int pos=0;pos<=curr.size();pos++){
            curr.add(pos,nums[i]);
            permutations(nums,i+1,curr,res);
            curr.remove(pos);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> res=new HashSet<>();
        permutations(nums,0,new ArrayList<>(),res);
        return new ArrayList<>(res);
    }
}