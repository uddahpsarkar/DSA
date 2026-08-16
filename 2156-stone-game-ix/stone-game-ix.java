class Solution {
    public boolean stoneGameIX(int[] stones) {
//        int temp = 0;
//         for(int i=0; i<stones.length;i++){
//             temp += stones[i];
//         }
//         if(temp == 0 || temp < 3 || stones.length < 2){ 
//              return false;
//         } 
//         if(temp > 3){
//         for(int i=0; i<temp; i++){
//              temp = temp/3; 
//         }
//         } 
//         if(temp%3 == 0){
//            System.out.println(temp%3);  
//             return true;
//         }

//         return false; 

        int[] count = new int[3];
        
        for (int stone : stones) {
            count[stone % 3]++;
        }
         
        if (count[0] % 2 == 0) { 
            return count[1] > 0 && count[2] > 0;
        }  
        else { 
            return Math.abs(count[1] - count[2]) > 2;
        }
    }
}