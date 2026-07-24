class Solution {
    boolean isPalindrome(String s){
        int low=0,high=s.length()-1;
        if(s.length()==1)
            return true;
        if(s.length()==0)
            return false;
        while(low<=high){
            if(s.charAt(low)!=s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    void backtrack(int i,int j,String s,List<List<String>> res,String curr,List<String> temp){
        if(isPalindrome(curr)){
            temp.add(curr);
            int tem=j;
            j=i;
            backtrack(i,j,s,res,"",temp);
            temp.remove(temp.size()-1);
            j=tem;
        }

        if(i==s.length() && i==j){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(i>=s.length())
            return;
        
        backtrack(i+1,j,s,res,curr+s.charAt(i),temp);
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        backtrack(0,0,s,res,"",temp);
        return res;
    }
}