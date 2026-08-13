class Solution {
    public int removeElement(int[] nums, int val) { 
        // if(nums.length == 0){
        //     return " ";
        // }
        int writePointer = 0;
 
        for (int readPointer = 0; readPointer < nums.length; readPointer++) {
            if (nums[readPointer] != val) {
                nums[writePointer] = nums[readPointer];
                writePointer++;
            }
        }
 
        int zeroStart = writePointer;  
        while (writePointer < nums.length) {
            nums[writePointer] = val;
            writePointer++;
        }
        
        return zeroStart;  
    }
}