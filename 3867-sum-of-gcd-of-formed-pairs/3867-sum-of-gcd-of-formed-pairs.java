class Solution {
    int gcd(int a,int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            nums[i]=gcd(max,nums[i]);
        }
        Arrays.sort(nums);
        long sum=0;
        for(int i=0;i<n/2;i++){
            sum+=gcd(nums[i],nums[n-i-1]);
        }
        return sum;
    }
}