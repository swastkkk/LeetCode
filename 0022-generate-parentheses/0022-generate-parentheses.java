class Solution {
    void backtrack(int open,int closed,int n,StringBuilder str,List<String> res){
        if(open==closed && open==n){
            res.add(str.toString());
            return;
        }
        if(open<n){
            str.append('(');
            backtrack(open+1,closed,n,str,res);
            str.deleteCharAt(str.length()-1);
        }
        if(closed<open){
            str.append(')');
            backtrack(open,closed+1,n,str,res);
            str.deleteCharAt(str.length()-1);
        }
            
    }
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        backtrack(0,0,n,new StringBuilder(),result);
        return result;
    }
}