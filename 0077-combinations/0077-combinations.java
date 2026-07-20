class Solution {
    void backtrack(int i,int n,int k,List<List<Integer>> res,List<Integer> curr){
        if(curr.size()==k){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i>n || curr.size()>k)
            return;
        curr.add(i);
        backtrack(i+1,n,k,res,curr);
        curr.remove(curr.size()-1);
        backtrack(i+1,n,k,res,curr);

    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        backtrack(1,n,k,res,curr);
        return res;
    }
}