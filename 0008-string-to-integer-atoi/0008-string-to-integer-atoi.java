class Solution {
    int getNum(String s,int i,int sign,long num){
        if(i>=s.length() || !Character.isDigit(s.charAt(i)))
            return (int)(sign*num);
        num=num*10+(s.charAt(i)-'0');
        if((num*sign)<=Integer.MIN_VALUE)   return Integer.MIN_VALUE;
        if((num*sign)>=Integer.MAX_VALUE)   return Integer.MAX_VALUE;

        return getNum(s,i+1,sign,num);
    }
    public int myAtoi(String s) {
        int num=0,i=0,n=s.length();
        while(i<n && s.charAt(i)==' ')
            i++;

        if(i==n)
            return 0;
        int sign=1;
        if(s.charAt(i)=='+' || s.charAt(i)=='-'){
            sign=(s.charAt(i)=='+')?1:-1;
            i++;
        }
        num=getNum(s,i,sign,num);
        return num;
    }
}