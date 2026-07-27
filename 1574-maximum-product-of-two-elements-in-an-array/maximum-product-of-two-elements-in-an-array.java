class Solution {
    public int maxProduct(int[] nums) { 
        int larg = Integer.MIN_VALUE;
        int slarg = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > larg){
                slarg = larg;
                larg = nums[i];
            }
            else if(larg >= nums[i] & nums[i] > slarg){
                slarg  = nums[i];
            } 
        }
        return (slarg-1)*(larg-1);
         
    }
}