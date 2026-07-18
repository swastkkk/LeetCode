class Solution {
    void backtrack(int candidates[],int target,int sum,int index,List<List<Integer>> res,List<Integer> curr){
        if(index<0 || sum>target)
            return;
        if(sum==target){
            res.add(new ArrayList<>(curr));
            return;
        }

            curr.add(candidates[index]);
            backtrack(candidates,target,sum+candidates[index],index,res,curr);
            curr.remove(curr.size()-1);
            backtrack(candidates,target,sum,index-1,res,curr);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,candidates.length-1,res,curr);
        return res;
    }
}