class Solution {
    public boolean isPowerOfThree(int n) {
     boolean result = false;
     
     if(n<=0){
        return result;
     }
     for(long i=0; i<=999; i++){ 
          if((long)Math.pow(3,i) == n){
               result = true;
          }
     }
     return result;
    }
}