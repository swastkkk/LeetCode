class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList <Integer> new_num=new ArrayList<>();

        for(int i=digits.length-1;i>=0;i--)
        {
            if(i==digits.length-1)
                digits[i]+=1;
            if(i!=0 && digits[i]>9)
            {
                digits[i]-=10;
                digits[i-1]+=1;
            }
            if(i==0){
                if(digits[0]<=9)
                    new_num.add(0,digits[i]); 
                else{
                    new_num.add(0,digits[i]-10); 
                    new_num.add(0,1); 
                }
                continue;
            }
                new_num.add(0,digits[i]);                
        }
        int[] arr=new int[new_num.size()];
        for (int i=0;i<new_num.size();i++)
            arr[i] = new_num.get(i);

        return arr;
    }
}