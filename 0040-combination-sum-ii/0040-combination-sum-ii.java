class Solution {
    void backtrack(int[]candidates,int target,int ind,Set<List<Integer>> res,List<Integer> curr){
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target<0 || ind>=candidates.length)
            return;
        
        curr.add(candidates[ind]);
        backtrack(candidates,target-candidates[ind],ind+1,res,curr);
        curr.remove(curr.size()-1);
        int i;
        for(i=ind;i<candidates.length;i++){
            if(candidates[ind]!=candidates[i])
                break;
        }
        backtrack(candidates,target,i,res,curr);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res=new HashSet<>();
        //backtrack(candidates,target,0,res,new ArrayList<>());
        Arrays.sort(candidates);
        backtrack(candidates,target,0,res,new ArrayList<>());
        return new ArrayList<>(res);
    }
}