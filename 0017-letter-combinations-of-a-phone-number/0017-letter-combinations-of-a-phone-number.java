class Solution {
    void backtrack(List<String> res,int i,int n,Map<Integer,List<Character>> letters,StringBuilder curr,String digits){
        if(curr.length()==n){
            res.add(curr.toString());
            return;
        }
        if(i>=n || curr.length()>n)
            return;
        List<Character> temp=letters.get(digits.charAt(i)-'0');
        for(char ch:temp){
            curr.append(ch);
            backtrack(res,i+1,n,letters,curr,digits);
            curr.deleteCharAt(curr.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        int len=digits.length();
        Map<Integer,List<Character>> letters=new HashMap<>();
        int count=97;
        for(int i=2;i<=9;i++){
            letters.put(i,new ArrayList<>());
            int size=(i==7 || i==9)?4:3;
            for(int j=0;j<size;j++)
                letters.get(i).add((char)(count++));
        }
        StringBuilder curr=new StringBuilder();
        backtrack(res,0,digits.length(),letters,curr,digits);
        return res;
    }
}